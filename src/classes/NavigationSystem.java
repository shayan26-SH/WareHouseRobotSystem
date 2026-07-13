package classes;

public class NavigationSystem {
	public boolean checkRoute(DeliveryTask task) {
		if (task == null)
			throw new IllegalArgumentException();
		return task.isRouteClear();
	}
}
