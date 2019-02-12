package daag;

import java.util.ArrayList;

/**
 * Ein Musiker hat ein Notenblatt. Aus dem Notenblatt liest der Musiker wann er
 * welche Note zu spielen hat. Dazu hört der Musiker auf die Uhr. Eine Note hat
 * eine Lautstärke einen Tonwert und einen Zeitwert.
 * 
 * @author bhauc
 *
 */
public class Musician implements Listener {

	private ArrayList<Note> sheetOfMusic;
	private DaagInstrument instrument;
	// private measure<Note> "notenBlatt";

	public Musician() {
		instrument = new DaagInstrument();
		sheetOfMusic = new ArrayList<>();
	}

	private void play(Note note) {
//		System.out.println("Musician::mockPlay()");
		if (note != null)
			instrument.play(note);
	}

	@Override
	public void listen(int time) {
		Note noteToPlay;
		// TODO Auto-generated method stub
		noteToPlay = lookUpSheetOfMusic(time);
		play(noteToPlay);
	}

	private Note lookUpSheetOfMusic(int time) {
		// TODO: implement / overwrite mocking behavior
		return sheetOfMusic.get(time);
	}
}
