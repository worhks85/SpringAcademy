package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberInfoPrinter;
import spring.MemberPrinter;

//팩토리 메서드 패턴
@Configuration //자바로 스프링 동작을 설정하는 파일이다.
public class ConfigPart2 {
	
	@Autowired
	//private MemberDao memberDao;
	private ConfigPart1 configPart1;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setMemberDao(configPart1.memberDao());
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}

}










