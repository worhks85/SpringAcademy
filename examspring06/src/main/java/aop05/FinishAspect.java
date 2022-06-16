package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class FinishAspect {
	
	@After("execution(* usingComputer(..))")
	public void shutdown(JoinPoint jp) {
		String computer = jp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "시스템 종료");
	}
}
