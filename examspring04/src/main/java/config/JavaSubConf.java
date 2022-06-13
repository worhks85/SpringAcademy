package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring.MemberDao;
import spring.MemberPrinter;
import spring.MemberRegisterService;

//팩토리 메서드 패턴
@Configuration //자바로 스프링 동작을 설정하는 파일이다.
public class JavaSubConf {
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao); //직접 주입
			//스프링은 memberDao()를 호출하는 것이 아니다!
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
}










