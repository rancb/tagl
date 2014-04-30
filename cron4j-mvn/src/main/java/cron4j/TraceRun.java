package it.sauronsoftware.cron4j;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.*;

import it.sauronsoftware.cron4j.ThreadID;

@Aspect
public class TraceRun {

	@Pointcut("execution(* java.lang.Runnable.run()) && this(it.sauronsoftware.cron4j.TimerThread)")
	public void runtrace() {}

	/*@Before("runtrace()")
	public void avantRun() {
	    System.out.println("####################Debut run " + ThreadID.getID() + 
	    " sur " + ThreadID.getNb() + " appels de la methode.");
	}
	
	@After("runtrace()")
	public void apresRun() {
		System.out.println("####################Fin run " + ThreadID.getID() + 
	    " sur " + ThreadID.getNb() + " appels de la methode.");
	}*/
	
	@Around("runtrace()")
	public Object aroundRun(ProceedingJoinPoint tjp) throws java.lang.Throwable{
		System.out.println("####################Debut run " + ThreadID.getID() + 
		" sur " + ThreadID.getNb() + " appels de la methode.");
		Object o = tjp.proceed(null);
		System.out.println("####################Fin run " + ThreadID.getID() + 
		" sur " + ThreadID.getNb() + " appels de la methode.");
		return o;
	}
	
}
