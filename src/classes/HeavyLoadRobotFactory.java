package classes;



public class HeavyLoadRobotFactory implements RobotFactory {

    @Override
    public Robot createRobot(String robotId, int batteryLevel) {

        return new Robot(
                robotId,
                "Heavy Load Robot",
                batteryLevel,
                new HeavyLoadMovementStrategy()
        );
    }
}