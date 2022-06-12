package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberRegisterService;
@Configuration //자바로 스프링 동작을 설정하는 파일이다.
@Import(ConfigPartSub.class) //다른 자바설정 파일을 포함
public class ConfigPartMain {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(); //직접 주입
	}
	

}
	

