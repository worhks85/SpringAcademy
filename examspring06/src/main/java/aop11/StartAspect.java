package aop11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//POJO 클래스
//Plain Old Java Object

@Aspect

public class StartAspect{
	@Before("MyPointcut.commonPoinCut()")
	
	public void beforAdvice(JoinPoint jp) { 
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 후 " + pwd + "입력하여 로그인");
	}
}
