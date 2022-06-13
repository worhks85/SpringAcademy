package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.JavaMainConf;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainXmlJava {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("main-conf.xml");
		
		MemberRegisterService mrs = 
				ctx.getBean("memberRegSvc", 
						MemberRegisterService.class);
		
		RegisterRequest rr = new RegisterRequest();
		rr.setEmail("garnet2929@naver.com");
		rr.setPassword("1234");
		rr.setConfirmPassword("123");
		rr.setName("홍길동");
		
		mrs.regist(rr);
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", 
						MemberInfoPrinter.class);
		infoPrinter.printMemberInfo("garnet2929@naver.com");
		
		System.out.println("종료");
	}
}





