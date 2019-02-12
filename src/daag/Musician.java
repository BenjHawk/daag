package daag;

/**
 * Ein Musiker hat ein Notenblatt. Aus dem Notenblatt liest der Musiker wann er
 * welche Note zu spielen hat. Dazu hört der Musiker auf die Uhr. Eine Note hat
 * eine Lautstärke einen Tonwert und einen Zeitwert.
 * 
 * @author bhauc
 *
 */
public class Musician implements Listener {

	private DaagInstrument instrument;
	// private measure<Note> "notenBlatt";

	public Musician() {
		instrument = new DaagInstrument();
	}

	private void play(Note note) {
//		System.out.println("Musician::mockPlay()");
		instrument.play(note);
	}

	@Override
	public void listen() {
		Note noteToPlay;
		// TODO Auto-generated method stub
		noteToPlay = lookUpSheetOfMusic();
		play(noteToPlay);
	}

	private Note lookUpSheetOfMusic() {
		// TODO: implement / overwrite mocking behavior 
		return new Note(0, 60, 1);
	}
}
