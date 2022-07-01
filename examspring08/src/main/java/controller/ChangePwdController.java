package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.ChangePwdCommand;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@ModelAttribute("cmd")ChangePwdCommand pwdCmd, HttpSession session) {
		//@ModelAttribute("cmd")ChangePwdCommand pwdCmd
		// model.addAttribute("cmd", pwdCmd); 이것과 같음
		
		//이 세션에서 값을 확인하는 부분은 interceptor로 변경될 것임
		if(session.getAttribute("authInfo") == null) {
			return "redirect:/login";
		}
		return "edit/changePwdForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
			@ModelAttribute("cmd")ChangePwdCommand pwdCmd,
			Errors errors,
			HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		
		if(errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		try {
			changePasswordService.changePassword(
					authInfo.getEmail(), 
					pwdCmd.getCurrentPassword(), 
					pwdCmd.getNewPassword());
			return "edit/changePwd";
		}catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("currentPassword", "notMatching");
		}catch(MemberNotFoundException e) {
			errors.reject("memberNotFound");
		}
		return "edit/changePwdForm";
	}
	
}









