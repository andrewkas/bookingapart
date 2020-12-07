package org.homeapart.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logging {



        private static final Logger log = Logger.getLogger(Logging.class);

//    @Before("aroundRepositoryPointcut()")
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("Method " + joinPoint.getSignature().getName() + " start");
//    }
//
//    @AfterReturning(pointcut = "aroundRepositoryPointcut()")
//    public void doAccessCheck(JoinPoint joinPoint) {
//        log.info("Method " + joinPoint.getSignature().getName() + " finished");
//    }

        @Pointcut("execution(* org.homeapart.repository.impl.UserRepositoryImpl.*(..))")
        public void aroundRepositoryPointcut() {
        }

        @Around("aroundRepositoryPointcut()")
        public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

            //Use StopWatch

            log.info("Method " + joinPoint.getSignature().getName() + " start");
            Object proceed = joinPoint.proceed();
            log.info("Method " + joinPoint.getSignature().getName() + " finished");
            return proceed;
        }

    }


