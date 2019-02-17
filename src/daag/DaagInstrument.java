package daag;

import javax.sound.midi.*;

public class DaagInstrument {

	private Synthesizer midiSynth;
	private Instrument[] instr;
	private MidiChannel[] mChannels;

	public DaagInstrument() {
		/*
		 * Create a new Sythesizer and open it. Most of the methods you will want to use
		 * to expand on this example can be found in the Java documentation here:
		 * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
		 */
		try {
			midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			System.err.println("DaagInstrument::Constructor:Error initializing MidiSynthesizer");
			e.printStackTrace();
		}
		// get and load default instrument and channel lists
		instr = midiSynth.getDefaultSoundbank().getInstruments();
		mChannels = midiSynth.getChannels();

		midiSynth.loadInstrument(instr[0]);// load an instrument
	}

	/**
	 * Standard values for note are volume:0 (not implemented), pitch:60, duration:1000
	 * @param note
	 */
	public void play(Note note) {
		// TODO: check midi behavior
		// TODO: do not use Thread.sleep -> use daag.Conductor?
		mChannels[0].noteOn(note.getPitch(), 100);// On channel 0, play note number 60 with velocity 100
		try {
			Thread.sleep(note.getDuration()); // wait time in milliseconds to control duration
		} catch (InterruptedException e) {
			System.err.println("DaagInstrument::play():Error during thread sleep");
			e.printStackTrace();
		}
		mChannels[0].noteOff(60);// turn of the note
	}
}
