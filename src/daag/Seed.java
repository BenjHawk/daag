package daag;

/**
 * This class holds all information, that is needed to define a certain audio
 * atmosphere. It is used to initialize and store compositions used by 
 * Composer.
 * @author bhauc
 *
 */
public class Seed implements Cloneable{
	private int musicianCnt;
	private int measure;
	private int bpm;

	public int getMeasure() {
		return measure;
	}

	public void setMeasure(int measure) {
		this.measure = measure;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public int getMusicianCnt() {
		return musicianCnt;
	}

	public void setMusicianCnt(int musicianCnt) {
		this.musicianCnt = musicianCnt;
	}
	
	public Seed() {
		loadSeedFromFile("mockLink");
	}
	
	@Override
	public Seed clone() throws CloneNotSupportedException {
		return (Seed) super.clone();
	}
	
	private void loadSeedFromFile(String url) {
		//TODO: implement

		musicianCnt = 1;// mocking data
		measure = 4;	// mocking data
		bpm = 120;		// mocking data
	}
	
}
