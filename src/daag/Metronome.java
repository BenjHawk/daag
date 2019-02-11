package daag;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class Metronome {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService sES = Executors.newScheduledThreadPool(5);

		System.out.println("playing one measure...");
		
		ScheduledFuture loop = sES.scheduleAtFixedRate(new Runnable() {
			private int it = 1;
			@Override
			public void run() {
				System.out.println("beat " + it++);
			}
		}, 0, 1, TimeUnit.SECONDS);
		
		ScheduledFuture scheduledFuture = sES.schedule(new Callable() {
			@Override
			public Object call() throws Exception {
				return "end of measure.";
			}
		}, 3, TimeUnit.SECONDS);
		
		System.out.println(scheduledFuture.get());

		sES.shutdown();
	}
}
