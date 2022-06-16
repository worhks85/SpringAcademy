package aop13;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//Around : 핵심 메서드 호출 시점을 개발자가 직접 설정

@Aspect
public class WorkAspect {
	
	@Around("execution(* usingComputer(..))")
	public Object workingAdvice(ProceedingJoinPoint pjp) {
		String computer = "";
		Object result = "";
		
		//before
		String pwd = (String)pjp.getArgs()[0];
		System.out.println("컴퓨터 부팅 후 " + pwd + "입력하여 로그인");
		
		try {
			result = pjp.proceed(); //핵심 메서드를 호출
			
			//After-returning
			computer = pjp.getTarget().getClass().getSimpleName();
			System.out.println(computer + "작업종료");
			
		} catch (Throwable e) {
			//After-throwing
			System.out.println("예외발생! AS 신청");
		} 
		
		
		//After
		computer = pjp.getTarget().getClass().getSimpleName();
		System.out.println(computer + "시스템 종료");
		
		
		return result;
		
	}
	
}