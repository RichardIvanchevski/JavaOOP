package robots;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ServiceTests {
    private Service service;
    private Robot robot1;
    private Robot robot2;

    @Before
    public void setUp() {
        service = new Service("Robot Service", 3);
        robot1 = new Robot("R2D2");
        robot2 = new Robot("C3PO");
    }

    @Test
    public void testAddRobot() {
        service.add(robot1);
        assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotToFullService() {
        Service service = new Service("Robot Service", 1);
        service.add(robot1);
        service.add(robot2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingRobot() {
        service.add(robot1);
        service.remove(robot2.getName());
    }

    @Test
    public void testRemoveExistingRobot() {
        service.add(robot1);
        service.add(robot2);
        service.remove(robot1.getName());
        assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExistingRobotForSale() {
        service.add(robot1);
        service.forSale(robot2.getName());
    }

    @Test
    public void testGetExistingRobotForSale() {
        service.add(robot1);
        service.add(robot2);
        Robot forSaleRobot = service.forSale(robot1.getName());
        assertFalse(forSaleRobot.isReadyForSale());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWithNull() {
        Service service = new Service(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithNegativeNumber() {
        Service service = new Service("Robot Service", -1);
    }

    @Test
    public void testGetName() {
        assertEquals("Robot Service", service.getName());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(3, service.getCapacity());
    }

    @Test
    public void testGetCount() {
        service.add(robot1);
        service.add(robot2);
        assertEquals(2, service.getCount());
    }

    @Test
    public void testReport() {
        service.add(robot1);
        service.add(robot2);
        String expected = "The robot R2D2, C3PO is in the service Robot Service!";
        assertEquals(expected, service.report());
    }
}