package aop09;

import java.util.Scanner;

public class Progamer implements Person{
	public int usingComputer(String pwd) {
		
		System.out.println("[게임을 한다.]");  //핵심기능
		Scanner sc = new Scanner(System.in);
		System.out.print("게임중 입력 (1 입력시 예외로 판단): ");
		int state = sc.nextInt();
		if(state == 1 ) {
			throw new RuntimeException("오류");
			
		}
		return 200;
	}
}
