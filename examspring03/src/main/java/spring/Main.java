package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appctx.xml");
		
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





