package test;

import org.junit.jupiter.api.Test;

import daag.DaagInstrument;
import daag.Note;

class DaagInstrumentTest {

	@Test
	void playTest() {
		DaagInstrument instrument = new DaagInstrument();
		instrument.play(new Note(0,60,1000));
		System.out.println("blub");
	}

}
