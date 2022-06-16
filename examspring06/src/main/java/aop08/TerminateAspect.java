package aop08;

import org.aspectj.lang.JoinPoint;

public class TerminateAspect {
	
	public void terminate(JoinPoint jp) {
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "작업종료");
	}
	
}
