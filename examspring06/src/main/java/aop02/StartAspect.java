package aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //하나의 관점(공통기능 묶음)
public class StartAspect{

	//조언(advice)
	//execution(표현식) : 포인트 컷(조인 포인트 중 공통기능이 실행될 어떤 지점)
	@Before("execution(public int aop02.*.usingComputer(String))")
	public void beforAdvice(JoinPoint jp) { 
		//JoinPoint: 핵심 메서드를 실행한 대상(포인트 컷 한 지점 정보)
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 후 " + pwd + "입력하여 로그인");
	}

}
