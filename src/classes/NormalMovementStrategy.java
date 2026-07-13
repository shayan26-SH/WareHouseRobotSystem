package classes;

public class NormalMovementStrategy implements MovementStrategy{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Robot is normally moving.");
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "Normal Movement";
	}

}
