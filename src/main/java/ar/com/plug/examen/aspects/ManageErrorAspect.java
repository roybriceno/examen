package ar.com.plug.examen.domain.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Aspect
@Component

public class ManageErrorAspect {


	@Pointcut("execution(* ar.com.plug.examen.app.rest..*(..))")

	public void methodsAround() {
	}

	@Around("methodsAround()")
	public Object logError(ProceedingJoinPoint joinPoint) throws Throwable {

		try {
			long start = System.currentTimeMillis();

			Object responsevalue = joinPoint.proceed();
			long executionTime = System.currentTimeMillis() - start;
			log.info("Se ejecutó correctamente: " + executionTime);
			return responsevalue;
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
}
