package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	@Autowired
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	@RequestMapping(value="/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	
	@RequestMapping(value="register/step2", method=RequestMethod.POST)
	public String handleStep2(
			@RequestParam(value="agree", defaultValue = "false") boolean ag,
			Model model) {//Model객체는 스프링이 생성하고 jsp처리할 때까지 유지
		if(!ag) {
			return "redirect:/register/step1";
		}
		model.addAttribute("formData", new RegisterRequest()); //폼 생성에 사용할 비어있는 객체를 등록
		return "register/step2";
	}
	
	@RequestMapping(value="register/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1";
	}
	
	@RequestMapping(value="register/step3", method=RequestMethod.POST)
	public String handleStep3(
			@ModelAttribute("formData")RegisterRequest regReq,
			Errors errors) { //Errors선언은 커맨드객체 바로 뒤에!
							//@ModelAttribute지정이 없으면 커맨드객체의 클래스명에서 소문자로 시작하는 이름으로 모델에 등록됨
		System.out.println(regReq);
		
		System.out.println(errors.getObjectName()); //Errors는 커맨드객체를 참조
		
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
/*			List<ObjectError> err = errors.getAllErrors();
			for(ObjectError e : err) {
				System.out.println(" + ":code:" + e.getCode());
			}
*/
			List<FieldError> err = errors.getFieldErrors();
			for(FieldError fe : err) {
				System.out.println(fe.getField() + ":" + fe.getCode());
			}
			return "register/step2";
		}
		
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(AlreadyExistingMemberException e) {
			//e.printStackTrace();
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}

}








