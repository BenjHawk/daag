package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import daag.Composer;
import daag.Conductor;
import daag.Seed;

class ConductorTest {

	Conductor c;

	@BeforeEach
	void init() {
		Composer comp = new Composer();
		comp.plantSeed(new Seed());
		c = new Conductor(comp);
	}

	@Test
	@Disabled
	void testConductor() {
		assertTrue(c != null);
	}

	@Test
	void testStartStop() {
		try {
			c.start();
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		} finally {
			c.stop();
		}
	}

	@Test
	@Disabled
	void testAddListener() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDelListener() {
		fail("Not yet implemented");
	}

}
