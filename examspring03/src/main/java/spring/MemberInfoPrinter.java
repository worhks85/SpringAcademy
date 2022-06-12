package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberInfoPrinter(MemberDao memberDao) {
		System.out.println("MemberInfoPrinter()");
		this.memberDao = memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	//@Resource(name="printer2")
	@Resource //name속성을 생략하면 타입(자료형)으로 찾는다.
	@Qualifier("p2")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			System.out.println("존재하지 않음");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
	
}









