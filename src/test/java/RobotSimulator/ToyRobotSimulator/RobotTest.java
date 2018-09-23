package RobotSimulator.ToyRobotSimulator;


import static org.junit.Assert.*;


import org.junit.Test;



public class RobotTest {

	Robot robot = new Robot();
	
	@Test
	public void testPlace() {
		
		assertTrue(robot.place(0,1, "North"));
		assertFalse(robot.place(5, 5, "West"));
	}

	@Test
	public void testIsValid() {
		assertTrue(robot.isValid(0,0));
		assertFalse(robot.isValid(5, 5));
	}

	@Test
	public void testReport() {
		robot.place(3, 1, "South");
		assertEquals("3,1,South",robot.report());
	}

	@Test
	public void testMove() {
		robot.place(3, 1, "South");
		robot.move();
		assertEquals("3,0,South",robot.report());
	}

	@Test
	public void testLeft() {
		robot.place(3, 1, "South");
		robot.left();
		assertEquals("3,1,East",robot.report());
	}

	@Test
	public void testRight() {
		robot.place(3, 1, "South");
		robot.right();
		assertEquals("3,1,West",robot.report());
	}

}
