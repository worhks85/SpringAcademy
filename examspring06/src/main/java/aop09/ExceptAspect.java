package aop09;

import org.aspectj.lang.JoinPoint;

public class ExceptAspect {
	public void problem(JoinPoint jp) {
		System.out.println("예외발생! AS 신청");
		
		
	}
}
