package classes;


public class StandardRobotFactory implements RobotFactory {

    @Override
    public Robot createRobot(String robotId, int batteryLevel) {

        return new Robot(
                robotId,
                "Standard Robot",
                batteryLevel,
                new NormalMovementStrategy()
        );
    }
}