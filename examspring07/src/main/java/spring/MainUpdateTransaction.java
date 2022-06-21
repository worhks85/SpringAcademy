package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainUpdateTransaction {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("appctx.xml");
		
		ChangePasswordService changePasswordService = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		String email = "tester@test.com";
		changePasswordService.changePassword(email, "1234", "1234"); 
		//비밀번호가 변경이 되던 안되던 트랜잭션 동작 확인
		//autocommit - false
		//update~
		//autocommit - true
		
	}
		
}
