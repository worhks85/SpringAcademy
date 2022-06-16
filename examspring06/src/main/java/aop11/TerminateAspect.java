package aop11;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TerminateAspect {
	@AfterReturning("MyPointcut.commonPoinCut()")
	public void terminate(JoinPoint jp) {
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "작업종료");
	}
	
}
