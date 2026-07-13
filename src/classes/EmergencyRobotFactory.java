package classes;


public class EmergencyRobotFactory implements RobotFactory {

    @Override
    public Robot createRobot(String robotId, int batteryLevel) {

        return new Robot(
                robotId,
                "Emergency Robot",
                batteryLevel,
                new EmergencyMovementStrategy()
        );
    }
}