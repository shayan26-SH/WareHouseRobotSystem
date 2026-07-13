package classes;

public class Robot {
	private String robotID, robotType;
	private int batterylevel;
	private MovementStrategy movementStrategy;

	public Robot(String robotID, String robotType, int batterylevel, MovementStrategy move) {

		if (robotID == null || robotID.isBlank())
			throw new IllegalArgumentException("Invalid robot ID.");

		if (batterylevel < 0 || batterylevel > 100)
			throw new IllegalArgumentException("Battery must be between 0 and 100.");
		this.robotID = robotID;
		this.robotType = robotType;
		this.batterylevel = batterylevel;
		this.movementStrategy = move;
	}

	/**
	 * @return the robotID
	 */
	public String getRobotID() {
		return robotID;
	}

	/**
	 * @param robotID the robotID to set
	 */
	public void setRobotID(String robotID) {
		this.robotID = robotID;
	}

	/**
	 * @return the robotType
	 */
	public String getRobotType() {
		return robotType;
	}

	/**
	 * @param robotType the robotType to set
	 */
	public void setRobotType(String robotType) {
		this.robotType = robotType;
	}

	/**
	 * @return the batterylevel
	 */
	public int getBatterylevel() {
		return batterylevel;
	}

	/**
	 * @param batterylevel the batterylevel to set
	 */
	public void setBatterylevel(int batterylevel) {
		this.batterylevel = batterylevel;
	}

	/**
	 * @return the move
	 */
	public MovementStrategy getMovementStrategy() {
		return movementStrategy;
	}

	/**
	 * @param move the move to set
	 */
	public void setMovementStrategy(MovementStrategy move) {
		this.movementStrategy = move;
	}

	public void move() {
		movementStrategy.move();
	}

	@Override
	public String toString() {
		return "Robot [ID=" + robotID + ", Type=" + robotType + ", battery=" + batterylevel + "%]";
	}

}
