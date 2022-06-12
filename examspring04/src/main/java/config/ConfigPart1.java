package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberRegisterService;
@Configuration //자바로 스프링 동작을 설정하는 파일이다.
public class ConfigPart1 {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(); //직접 주입
	}
	

}
	

