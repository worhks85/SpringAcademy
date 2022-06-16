package aop07;

import org.aspectj.lang.JoinPoint;

public class FinishAspect {
	public void shutdown(JoinPoint jp) {
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "시스템 종료");
	}
}
