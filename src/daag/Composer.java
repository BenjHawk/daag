package daag;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * This class composes audio atmospheres.
 * 
 * @author bhauc
 *
 */
public class Composer implements Listener {

	private Seed seed;
	private ArrayList<Musician> musicians;
	private int time;
	private int measure;
	private int bpm;

	public Composer() {
	}

	/**
	 * Listen gets called by tick-generator and decides what instrument should be
	 * called. Possible bottleneck in multithreading.
	 */
	public synchronized void listen() {
		compose(new ComposeStrategy() {

			@Override
			public Seed compose(Seed seed) {
				// TODO Auto-generated method stub
				return null;
			}

		});
		System.out.println(musicians.get(count()).mockPlay());
	}

	/**
	 * Initializes Composer from Seed.
	 * 
	 * @param seed
	 */
	public void fromSeed(Seed seed) {
		int musicianCnt;

		this.seed = seed;
		bpm = seed.getBpm();

		musicianCnt = seed.getMusicianCnt();
		musicians = new ArrayList<>(musicianCnt);
		for (int i = 0; i < musicianCnt; i++) {
			musicians.add(new Musician(i));
		}
	}

	public int getBpm() {
		return bpm;
	}

	/**
	 * alters Seed by applying compose strategy
	 * 
	 * @param cs
	 */
	private void compose(ComposeStrategy cs) {
		System.out.println("Composer:composing.");
	}

	// TODO: make private after testing
	private int count() {
		int tmp = this.time;
		this.time = (this.time + 1) % this.measure;
		return tmp;
	}

}
