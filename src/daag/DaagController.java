package daag;

public class DaagController {
	private Conductor conductor;
	private Composer composer;
	
	public DaagController() {
		composer = new Composer();
		conductor = new Conductor();
		composer.setConductor(conductor);
		conductor.setComposer(composer);
	}
	
	public void start() {
		conductor.start();
	};
	
	public void stop() {
		conductor.stop();
	};
	
	public void seed(String url) {
		composer.seed(new Seed(url));
	};
	
	public void harvest() {
		System.err.println("DaagController:harvest():not implemented.");
	};
	
	public void like() {
		System.err.println("DaagController:like():not implemented.");
	};
	
	public void dislike() {
		System.err.println("DaagController:dislike():not implemented.");
	};
}
