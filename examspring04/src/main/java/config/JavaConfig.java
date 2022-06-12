package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
@Configuration //자바로 스프링 동작을 설정하는 파일이다.
public class JavaConfig {
	
	//팩토리 메서드 패턴
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());	//직접 주입
		// 스프링은 memberDao()를 호출하는 것이 아니다.
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter =
				new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}
	
	
}
