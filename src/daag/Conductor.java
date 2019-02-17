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
	private Listener composer;
	private Seed composition;
//	private ArrayList<Listener> listeners;
	private ScheduledExecutorService scheduler;

	public Conductor() {
//		listeners = new ArrayList<>();
		scheduler = Executors.newScheduledThreadPool(THREADCOUNT);
	}

	public boolean start() {
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
	private void tick() {
		// TODO: call all Listeners (those are the Composer and all Musicians)
		System.out.println("Conductor::tick()");
			scheduler.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
//					System.out.println("Conductor::tick():run()");
//					for(Listener listener : listeners)
//						listener.listen(time);
					composer.listen(time);
					for(Listener musician: composition.getMusicians())
						musician.listen(time);
					count();
				}
			}, 0, composition.getBpm(), TimeUnit.MILLISECONDS);
	}

//	private void addListener(Listener listener) {
//		listeners.add(listener);
//	}
//
//	private void delListener(Listener listener) {
//		listeners.remove(listener);
//		// TODO: test method. Perhaps equals() has to be overridden in Listener Classes
//		throw new NotImplementedException();
//	}
	
	private synchronized void count() {
		time++;
		time = time % composition.getMeasure();
	}

	public int getTime() {
		return time;
	}
	
	public void setComposition(Seed composition) {
		this.composition = composition;
	}
	
	public void setComposer(Listener composer) {
//		addListener(composer);
		this.composer = composer;
	}

}
