package classes;

public class MovementContext {
	private MovementStrategy strategy;

	public MovementContext(MovementStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * @return the strategy
	 */
	public MovementStrategy getStrategy() {
		return strategy;
	}

	/**
	 * @param strategy the strategy to set
	 */
	public void setStrategy(MovementStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException();
		} else {
			this.strategy = strategy;
		}
	}

	public void executeMovement() {
		strategy.move();
	}
}
