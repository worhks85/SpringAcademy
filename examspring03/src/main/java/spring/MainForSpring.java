package spring;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForSpring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		processNewCommand(new String[] { "new", "a", "aname", "1", "1"});
		processNewCommand(new String[] { "new", "b", "bname", "1", "1"});
		processNewCommand(new String[] { "new", "c", "cname", "1", "1"});
		
		while(true) {
			System.out.print("명령어 입력>");
			String command = in.nextLine();
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return;
			}
			if(command.startsWith("new")) {
				System.out.println("등록기능");
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change")){
				System.out.println("변경기능");
				processChangeCommand(command.split(" "));
			}else if(command.equals("list")){
				processListCommand();
			}else if(command.startsWith("info")) {
				processInfoCommand(command.split(" "));
			}
			else {
				help();
			}
			
			
		}
	}

	private static void processInfoCommand(String[] args) {
		if(args.length != 2) {
			help();
			return;
		}
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(args[1]);
	}

	private static void processListCommand() {
		MemberListPrinter listPrinter = 
				ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}

	private static void processChangeCommand(String[] args) {
		if(args.length != 4) {
			help();
			return;
		}
		ChangePasswordService pwdSvc = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			pwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호가 변경되었습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("회원이 존재하지 않습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일 또는 비밀번호를 확인해주세요.");
		}
	}

	private static void help() {
		System.out.println("사용법");
		System.out.println("new <email> <name> <pass1> <pass2>");
		System.out.println("change <email> <oldpwd> <newpwd>");
		System.out.println("list");
		System.out.println("info <email>");
		System.out.println();
	}
	
	//private static Assembler assembler = new Assembler();
	private static GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:appctx.xml");
			//classpath: 는 resources/ 폴더 
	
	private static void processNewCommand(String[] args) {
		if(args.length != 5) {
			help();
			return;
		}
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		if(!req.isPasswordEqualsToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않음");
			return;
		}
		
		try {
			regSvc.regist(req);
			System.out.println("등록되었습니다.");
		}catch(AlreadyExistingMemberException e) {
			System.out.println(e.getMessage());
		}
	}
}

















