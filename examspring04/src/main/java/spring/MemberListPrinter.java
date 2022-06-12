package spring;

import java.util.List;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(
			MemberDao memberDao, 
			MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		List<Member> result = memberDao.selectAll();
		for(Member member : result) {
			printer.print(member);
		}
	}
}


