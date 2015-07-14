package modelTest.fontTest;

import static org.junit.Assert.*;
import model.Font;

import org.junit.Test;

public class fontTest {

	@Test
	public void test() {
		assertEquals(0, Font.whichDigitForPosition(0));
		assertEquals(0, Font.whichDigitForPosition(1));
		assertEquals(0, Font.whichDigitForPosition(2));
		
		assertEquals(1, Font.whichDigitForPosition(3));
		assertEquals(1, Font.whichDigitForPosition(4));
		assertEquals(1, Font.whichDigitForPosition(5));
		
		assertEquals(2, Font.whichDigitForPosition(6));
		assertEquals(2, Font.whichDigitForPosition(7));
		
		assertEquals(3, Font.whichDigitForPosition(8));
		assertEquals(3, Font.whichDigitForPosition(9));
		assertEquals(3, Font.whichDigitForPosition(10));

		assertEquals(4, Font.whichDigitForPosition(11));
		assertEquals(4, Font.whichDigitForPosition(12));
		assertEquals(4, Font.whichDigitForPosition(13));
	}

}
