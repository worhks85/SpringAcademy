package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy //프록시 객체를 인터페이스를 기반으로 생성
public class StartAspect{

	@Before("execution(* usingComputer(..))")
	public void beforAdvice(JoinPoint jp) { 
		String pwd = (String)jp.getArgs()[0];
		System.out.println("컴퓨터 부팅 후 " + pwd + "입력하여 로그인");
	}

}