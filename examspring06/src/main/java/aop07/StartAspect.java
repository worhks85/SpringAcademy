package aop07;

import org.aspectj.lang.JoinPoint;
//POJO 클래스
//Plain Old Java Object
public class StartAspect{
	public void beforAdvice(JoinPoint jp) { 
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 후 " + pwd + "입력하여 로그인");
	}
}
