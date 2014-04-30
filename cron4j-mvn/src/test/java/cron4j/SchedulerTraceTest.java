package it.sauronsoftware;

import it.sauronsoftware.cron4j.Scheduler;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SchedulerTraceTest {

	@BeforeClass
		public static void testSetup() {
		}

	@AfterClass
		public static void testCleanup() {
			// Teardown for data used by the unit tests
		}

	@Test
		public void testTrace() {
			MyTask task = new MyTask();
			Scheduler scheduler = new Scheduler();
			scheduler.schedule("* * * * *", task);
			scheduler.start();
			
			MyTask task2 = new MyTask();
			Scheduler scheduler2 = new Scheduler();
			scheduler2.schedule("* * * * *", task2);
			scheduler2.start();
			
			MyTask task3 = new MyTask();
			Scheduler scheduler3 = new Scheduler();
			scheduler3.schedule("* * * * *", task3);
			scheduler3.start();
			
			try {
				Thread.sleep(60L * 1000L);
			} catch (InterruptedException e) {
				;
			}
			scheduler.stop();
			scheduler2.stop();
			scheduler3.stop();
		}
}
