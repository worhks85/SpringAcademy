package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memberDao;
	
	private MemberPrinter printer;
	
//	public MemberInfoPrinter() {
//		System.out.println("MemberInfoPrinter()");
//		this.memberDao = memberDao;
//	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
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









