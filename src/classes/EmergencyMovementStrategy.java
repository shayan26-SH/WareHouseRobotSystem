package classes;

public class EmergencyMovementStrategy implements MovementStrategy {

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Robot is moving in emergency mode.");
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "Emmergency Movement";
	}

}
