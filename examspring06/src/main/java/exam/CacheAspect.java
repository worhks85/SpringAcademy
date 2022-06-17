package exam;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAspect {
	private Map<Long , Object> cache = new HashMap<>();
	
	public Object execute(ProceedingJoinPoint pjp) throws Throwable{
		Long num = (Long)pjp.getArgs()[0];
		if(cache.containsKey(num)) {
			System.out.println("Cache에서 구함 : " + num);
			return cache.get(num);
		}
		Object res = pjp.proceed(); //캐시에 없다면 factorial을 수행
		cache.put(num, res);
		System.out.println("Cache에 추가함 : " + num);
		return res;
	}
	
}
