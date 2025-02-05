package Lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	 private GradeBook firstgb;
	    private GradeBook secondgb;
	;
	@BeforeEach
	void setUp() throws Exception {
	 firstgb = new GradeBook(5);
	secondgb = new GradeBook(5);
		
		firstgb.addScore(60.0);
		secondgb.addScore(50.0);
		firstgb.addScore(80.0);
		secondgb.addScore(75.0);

	}

	@AfterEach
	void tearDown() throws Exception {
		firstgb =  null;
		secondgb = null;
	}
	

	@Test
	void testaddScore() {
        assertTrue(firstgb.toString().trim().equals("60.0 80.0"));
        assertTrue(secondgb.toString().trim().equals("50.0 75.0"));
		
        assertEquals(2, firstgb.getScoreSize());
		assertEquals(2, secondgb.getScoreSize());
		
	}
	@Test
	void testsum() {
		assertEquals(140.0, firstgb.sum(), .0001);
		assertEquals(125.0, secondgb.sum(), .0001);

	}
	
	@Test
	void testMinimum() {
		assertEquals(60.0, firstgb.minimum(), .001);
		assertEquals(50.0, secondgb.minimum(), .001);
	}
	@Test
	void testfinalScore() {
		assertEquals(80.0, firstgb.finalScore());
		assertEquals(75.0, secondgb.finalScore());
	}
}
