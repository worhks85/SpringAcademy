package aop09;

import java.util.Scanner;

public class Programmer implements Person {
	public int usingComputer(String pwd) {

		System.out.println("[코딩을 한다.]"); //핵심기능
		Scanner sc = new Scanner(System.in);
		System.out.print("코딩중 입력 (1 입력시 예외로 판단): ");
		int state = sc.nextInt();
		if(state == 1 ) {
			throw new RuntimeException("오류");

		}
		return 100;
	}
}
