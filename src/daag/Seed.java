package daag;

import java.util.ArrayList;

/**
 * This class holds all information, that is needed to define a certain audio
 * atmosphere. It is used to initialize and store compositions used by Composer.
 * 
 * @author bhauc
 *
 */
public class Seed implements Cloneable {
	private ComposeStrategy composeStrategy;
	private ArrayList<ArrayList<Note>> sheetsOfMusic;
	private ArrayList<Musician> musicians;
	private int musicianCnt;
	private int measure;
	private int bpm;

	public ArrayList<Musician> getMusicians(){
		return musicians;
	}
	
	public ComposeStrategy getComposeStrategy() {
		return composeStrategy;
	}
	
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

//	public int getMusicianCnt() {
//		return musicianCnt;
//	}

//	public void setMusicianCnt(int musicianCnt) {
//		this.musicianCnt = musicianCnt;
//	}

	public Seed(String url) {
		loadSeedFromFile(url);
	}

	@Override
	public Seed clone() throws CloneNotSupportedException {
		return (Seed) super.clone();
	}

	private void loadSeedFromFile(String url) {
		System.err.println("Seed:loadSeedFromFile():not implemented. Mocking behavior.");
		// TODO: implement
		// TODO: parse (e.g. JSON file)
		composeStrategy = new ComposeStrategy() {
			@Override
			public Seed compose(Seed seed) {
				// TODO Compose shouldn't create a new Seed but change current composition(s)
				return null;
			}
		};
		sheetsOfMusic = parseSheetsOfMusic();
		musicianCnt = 1;// mocking data
		musicians = parseMusicians();
		measure = 4; // mocking data
		bpm = 120; // mocking data
	}
	
	private ArrayList<Musician> parseMusicians() {
		//mocking
		ArrayList<Musician> musicians = new ArrayList<>();
		for (int i = 0; i < musicianCnt; i++)
			musicians.add(new Musician(assignSheetOfMusic()));
		return musicians;
	}

	private ArrayList<ArrayList<Note>> parseSheetsOfMusic() {
		//mocking
		ArrayList<ArrayList<Note>> sheetsOfMusic = new ArrayList<>();
		sheetsOfMusic.add(new ArrayList<Note>());
		sheetsOfMusic.get(0).add(new Note(0, 60, 1000));
		sheetsOfMusic.get(0).add(new Note(0, 62, 1000));
		sheetsOfMusic.get(0).add(new Note(0, 65, 1000));
		sheetsOfMusic.get(0).add(new Note(0, 67, 1000));
		sheetsOfMusic.get(0).add(new Note(0, 70, 1000));
		return sheetsOfMusic;
	}
	
	private ArrayList<Note> assignSheetOfMusic() {
		return sheetsOfMusic.get(0); // mocking
	}

}
