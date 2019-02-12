package daag;

/**
 * This class composes audio atmospheres.
 * 
 * @author bhauc
 *
 */
public class Composer implements Listener {

	private Seed seed;
	private Seed composition;

	public Composer() {
	}

	/**
	 * Listen gets called by tick-generator and decides what instrument should be
	 * called. Possible bottleneck in multithreading.
	 */
	public synchronized void listen(int time) {
		// TODO: save Strategy to global variable instead of recreating it every time listen gets called
		compose(new ComposeStrategy() {

			@Override
			public Seed compose(Seed seed) {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

	/**
	 * Initializes Composer from Seed.
	 * 
	 * @param seed
	 */
	public void plantSeed(Seed seed) {

		this.seed = seed;
		
		try {
			this.composition = seed.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return current composition as Seed
	 */
	public Seed getComposition() {
		return composition;
	}

	/**
	 * @return current original Seed
	 */
	public Seed getSeed() {
		return seed;
	}

	/**
	 * alters Seed by applying compose strategy
	 * 
	 * @param cs
	 */
	private void compose(ComposeStrategy cs) {
		System.out.println("Composer:composing.");
	}
}
