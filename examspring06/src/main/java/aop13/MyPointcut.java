package aop13;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
	
	@Pointcut("execution(* usingComputer(..))")
	public void commonPointcut() {}
}
