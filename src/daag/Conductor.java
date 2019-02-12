package daag;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Conductor {

	private final int THREADCOUNT = 4;
	private int time;
	private Seed composition;
	private ArrayList<Listener> listeners;
	private ScheduledExecutorService scheduler;

	public Conductor(Composer composer) {
		listeners = new ArrayList<>();
		listeners.add(composer);
		scheduler = Executors.newScheduledThreadPool(THREADCOUNT);
	}

	public boolean start() throws InterruptedException, ExecutionException {
		System.out.println("Conductor::start()");
		tick();
		return true;
	}

	public boolean stop() {
		System.out.println("Conductor::stop()");
		scheduler.shutdownNow();
		return true;
	}

	/**
	 * a fixed delay. Each tick will call all subscribed Listeners.
	 * 
	 * @param interval in milliseconds for which the clock emits ticks
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	private void tick() throws InterruptedException, ExecutionException {
		// TODO: call all Listeners (those are the Composer and all Musicians)
		System.out.println("Conductor::tick()");
			scheduler.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					System.out.println("Conductor::tick():run()");
					count();
				}
			}, 0, composition.getBpm(), TimeUnit.MILLISECONDS);
	}

	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	public void delListener(Listener listener) {
		listeners.remove(listener);
		// TODO: test method. Perhaps equals() has to be overridden in Listener Classes
		throw new NotImplementedException();
	}
	
	private synchronized void count() {
		time++;
		time = time % composition.getMeasure();
	}

	public int getTime() {
		return time;
	}
	

}
