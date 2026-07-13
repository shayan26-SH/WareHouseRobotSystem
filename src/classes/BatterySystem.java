package classes;
//mport classes.Robot;
public class BatterySystem {

	public boolean checkBattery(Robot robot) {
		if(robot == null)throw new IllegalArgumentException();
		return robot.getBatterylevel() >= 15;
	}
}
