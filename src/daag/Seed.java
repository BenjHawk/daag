package daag;

/**
 * This class holds all information, that is needed to define a certain audio
 * atmosphere.
 * @author bhauc
 *
 */
public class Seed {
	private int musicianCnt = 1;
	private int measure = 4;
	private int bpm = 120;

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
	
}
