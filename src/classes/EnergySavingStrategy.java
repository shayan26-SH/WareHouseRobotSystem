package classes;

public class EnergySavingStrategy implements MovementStrategy{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("Robot is moving in energy saving mode.");
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "Energy Saving Movement";
	}

}
