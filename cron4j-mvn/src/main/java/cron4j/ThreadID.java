package it.sauronsoftware.cron4j;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadID {
	private static final AtomicInteger nextId = new AtomicInteger(0);
	private static final AtomicInteger nbCall = new AtomicInteger(0);

	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
			protected Integer initialValue() {
				nbCall.getAndIncrement();
				return nextId.getAndIncrement();
			}
	};

	public static int getID() {
		return threadId.get();
	}
	
	public static int getNb() {
		return nbCall.get();
	}
}
