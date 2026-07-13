package classes;

public class HeavyLoadMovementStrategy implements MovementStrategy{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Robot is moving slowly because of a heavy package.");
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "Heavy Load Movement";
	}

}
