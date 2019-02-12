package daag;

public class Note {

	private int volume;
	private int pitch;
	private int duration;
	
	public Note(int volume, int pitch, int duration) {
		this.volume = volume;
		this.pitch = pitch;
		this.duration = duration;
	}

	public int getVolume() {
		return volume;
	}

	public int getPitch() {
		return pitch;
	}

	public int getDuration() {
		return duration;
	}
	
	
}
