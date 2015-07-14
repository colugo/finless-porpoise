package modelTest.clockModelTest;

import static org.junit.Assert.*;
import model.ClockModel;

import org.junit.Before;
import org.junit.Test;

public class WhenCreatingAClock {
	
	ClockModel _clockModel;
	
	@Before
	public void setUp() throws Exception {
		 this._clockModel = new ClockModel();
	}

	@Test
	public void test() {
		assertEquals(0, _clockModel.getHourAngle());
		assertEquals(0, _clockModel.getMinuteAngle());
	}

}
