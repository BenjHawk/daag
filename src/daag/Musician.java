package daag;

import java.util.Observable;
import java.util.Observer;

/**
 * Ein Musiker hat ein Notenblatt. Aus dem Notenblatt liest der Musiker wann er
 * welche Note zu spielen hat. Dazu hört der Musiker auf die Uhr. Eine Note hat
 * eine Lautstärke einen Tonwert und einen Zeitwert.
 * 
 * @author bhauc
 *
 */
public class Musician implements Listener {

	String name; // testing value for visualization
	// measure<Note>

	public Musician(int n) {
		generateTestingName(n);
	}

	/**
	 * testing
	 **/
	private void generateTestingName(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += ".";
		}
		s += n;
		this.name = s;
	}

	/**
	 * testing
	 **/
	public String mockPlay() {
//		System.out.println("Musician::mockPlay()");
		return this.name;
	}

	@Override
	public void listen() {
		// TODO Auto-generated method stub

	}

}
