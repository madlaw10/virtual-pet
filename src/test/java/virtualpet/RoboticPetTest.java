package virtualpet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

@SuppressWarnings("unused")
public class RoboticPetTest {

	@Test
	public void petShouldHaveName() {
		RoboticPet underTest = new RoboticPet("Jeff");

		String actual = underTest.getName();

		assertEquals("Jeff", actual);
	}

	@Test
	public void shouldHaveDefaultBatteryCharge() {
		RoboticPet underTest = new RoboticPet("Jeff");

		int actual = underTest.getBatteryLife();

		assertEquals(0, actual);
	}

//	// Tick test:
//	@Test
//	public void shouldTick() {
//		OrganicPet underTest = new OrganicPet("Jeff");
//
//		int beforeAction = pet.getHunger();
//		pet.tick();
//		int afterAction = pet.getHunger();
//
//		assertEquals(beforeAction + 1, afterAction);
//	}

	@Test
	public void shouldCharge() {
		RoboticPet underTest = new RoboticPet("Jeff");

		underTest.charge();
		int afterCharging = underTest.getBatteryLife();

		assertEquals(0, afterCharging);

	}

	@Test
	public void shouldBeAbleToChangeOil() {
		RoboticPet underTest = new RoboticPet("Jeff");

		underTest.oilChange();
		int afterOilChange = underTest.getOilGauge();

		assertEquals(0, afterOilChange);

	}

	@Test
	public void happinessCheck() {
		RoboticPet underTest = new RoboticPet("Jeff");

		int beforeAction = underTest.getMaintenance();

		underTest.charge();
		underTest.play();
		underTest.oilChange();
		underTest.hug();

		int afterAction = underTest.getMaintenance();

		assertEquals(beforeAction - 4, afterAction);
	}
	
	@Test
	public void tickCheck() {
		RoboticPet underTest = new RoboticPet(null);
		
		int a = underTest.getBatteryLife();
		int b = underTest.getOilGauge();
		int c = underTest.getMaintenance();
		
		underTest.tick(5);
		
		int d = underTest.getBatteryLife();
		int e = underTest.getBatteryLife();
		int f = underTest.getMaintenance();
		
		assertEquals(a + 1, d);
		assertEquals(b + 1, e);
		assertEquals(c + 2, f);

	}
	
}