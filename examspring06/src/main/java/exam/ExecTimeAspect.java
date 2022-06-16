package exam;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExecTimeAspect {
	
	public Object measure(ProceedingJoinPoint pjp) throws Throwable{
		long start =0 ;
		long finish = 0;
		Object res;
		System.out.println();
		try {
			start = System.nanoTime();
			res = pjp.proceed();	//factorial(4) 호출!
			finish = System.nanoTime();
		} finally {
			System.err.printf(pjp.getTarget().getClass().getSimpleName() + " : 실행시간 : " + (finish -start) + "\n");
		}
		
		
		return res;
	}
}
