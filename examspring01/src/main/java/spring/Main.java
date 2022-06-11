package spring;

public class Main {
	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService mrs = 
				new MemberRegisterService(memberDao);
		
		RegisterRequest rr = new RegisterRequest();
		rr.setEmail("garnet2929@naver.com");
		rr.setPassword("1234");
		rr.setConfirmPassword("123");
		rr.setName("홍길동");
		
		mrs.regist(rr);
		System.out.println("종료");
	}
}
