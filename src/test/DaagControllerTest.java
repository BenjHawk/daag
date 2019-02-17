package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import daag.DaagController;

class DaagControllerTest {

	@Test
	void testDaagController() {
		DaagController controller = new DaagController();
		controller.seed("mock");
		controller.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(true);
		controller.stop();
	}

	@Test
	@Disabled
	void testStart() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testStop() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testSeed() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testHarvest() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testLike() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDislike() {
		fail("Not yet implemented");
	}

}
