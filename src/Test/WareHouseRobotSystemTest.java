package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import classes.*;

public class WareHouseRobotSystemTest {

    private BatterySystem batterySystem;
    private NavigationSystem navigationSystem;
    private PackageHandlingSystem packageHandlingSystem;
    private RobotOperationFacade robotFacade;

    @BeforeEach
    void setUp() {

        batterySystem = new BatterySystem();
        navigationSystem = new NavigationSystem();
        packageHandlingSystem = new PackageHandlingSystem();

        robotFacade = new RobotOperationFacade(
                batterySystem,
                navigationSystem,
                packageHandlingSystem
        );
    }

    /*
     * =====================================================
     * TEST CASE 1
     * Factory creates a standard robot.
     * =====================================================
     */

    @Test
    void shouldCreateStandardRobotUsingFactory() {

        RobotFactory factory = new StandardRobotFactory();

        Robot robot = factory.createRobot("R001", 80);

        assertNotNull(robot);
        assertEquals("R001", robot.getRobotID());
        assertEquals(80, robot.getBatterylevel());
        assertEquals("Standard Robot", robot.getRobotType());

        assertInstanceOf(
                NormalMovementStrategy.class,
                robot.getMovementStrategy()
        );
    }

    /*
     * =====================================================
     * TEST CASE 2
     * Successful delivery using Facade.
     * =====================================================
     */

    @Test
    void shouldCompleteSuccessfulDelivery() {

        RobotFactory factory = new StandardRobotFactory();

        Robot robot = factory.createRobot("R002", 80);

        DeliveryTask task = new DeliveryTask(
                "T001",
                "Shelf A",
                "Packing Station",
                20.0,
                true,
                false,
                false
        );

        boolean result =
                robotFacade.executeDeliveryTask(robot, task);

        assertTrue(result);
        assertTrue(task.isPackagePickedUp());
        assertTrue(task.isDelivered());

        assertEquals(
                "Normal Movement",
                robot.getMovementStrategy().getStrategyName()
        );
    }

    /*
     * =====================================================
     * TEST CASE 3
     * Delivery fails when battery is too low.
     * =====================================================
     */

    @Test
    void shouldRejectDeliveryWhenBatteryIsLow() {

        RobotFactory factory = new StandardRobotFactory();

        Robot robot = factory.createRobot("R003", 10);

        DeliveryTask task = new DeliveryTask(
                "T002",
                "Shelf B",
                "Loading Dock",
                15.0,
                true,
                false,
                false
        );

        boolean result =
                robotFacade.executeDeliveryTask(robot, task);

        assertFalse(result);
        assertFalse(task.isPackagePickedUp());
        assertFalse(task.isDelivered());

        assertEquals(10, robot.getBatterylevel());
    }

    /*
     * =====================================================
     * TEST CASE 4
     * Heavy robot uses HeavyLoadMovementStrategy.
     * =====================================================
     */

    @Test
    void shouldUseHeavyLoadStrategyForHeavyPackage() {

        RobotFactory factory = new HeavyLoadRobotFactory();

        Robot robot = factory.createRobot("R004", 70);

        DeliveryTask task = new DeliveryTask(
                "T003",
                "Storage Area",
                "Packing Station",
                100.0,
                true,
                false,
                false
        );

        boolean result =
                robotFacade.executeDeliveryTask(robot, task);

        assertTrue(result);

        assertInstanceOf(
                HeavyLoadMovementStrategy.class,
                robot.getMovementStrategy()
        );

        assertEquals(
                "Heavy Load Movement",
                robot.getMovementStrategy().getStrategyName()
        );

        assertTrue(task.isPackagePickedUp());
        assertTrue(task.isDelivered());
    }

    /*
     * =====================================================
     * TEST CASE 5
     * Strategy changes at runtime.
     * =====================================================
     */

    @Test
    void shouldChangeMovementStrategyAtRuntime() {

        RobotFactory factory = new StandardRobotFactory();

        Robot robot = factory.createRobot("R005", 60);

        assertInstanceOf(
                NormalMovementStrategy.class,
                robot.getMovementStrategy()
        );

        robot.setMovementStrategy(
                new EmergencyMovementStrategy()
        );

        assertInstanceOf(
                EmergencyMovementStrategy.class,
                robot.getMovementStrategy()
        );

        assertEquals(
                "Emergency Movement",
                robot.getMovementStrategy().getStrategyName()
        );
    }

    /*
     * =====================================================
     * TEST CASE 6
     * Delivery fails because the route is blocked.
     * =====================================================
     */

    @Test
    void shouldRejectDeliveryWhenRouteIsBlocked() {

        RobotFactory factory = new EmergencyRobotFactory();

        Robot robot = factory.createRobot("R006", 90);

        DeliveryTask task = new DeliveryTask(
                "T004",
                "Emergency Storage",
                "Loading Dock",
                30.0,
                false,
                false,
                false
        );

        boolean result =
                robotFacade.executeDeliveryTask(robot, task);

        assertFalse(result);
        assertFalse(task.isPackagePickedUp());
        assertFalse(task.isDelivered());
    }
}