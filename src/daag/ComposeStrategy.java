package daag;

public interface ComposeStrategy {
	/**
	 * Alters the seed.
	 * @param seed
	 * @return altered Seed.
	 */
	public Seed compose(Seed seed);
}
