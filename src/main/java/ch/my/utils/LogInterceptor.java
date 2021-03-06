package ch.my.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogInterceptor {
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("coming Around ----\"******************************************\"");
		try {
			System.out.println("coming try block ----");
			jp.proceed();
			System.out.println("end end ----");
		}catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
	}
}
