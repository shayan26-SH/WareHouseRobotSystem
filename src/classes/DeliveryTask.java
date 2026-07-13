package classes;

public class DeliveryTask {
	  private String taskId;
	    private String pickupLocation;
	    private String destination;
	    private double packageWeight;
	    private boolean routeClear;
	    private boolean packagePickedUp;
	    private boolean delivered;
	    
	    
	    
	    public DeliveryTask(String taskId, String pickupLocation, String destination, double packageWeight,
				boolean routeClear, boolean packagePickedUp, boolean delivered) {
			this.taskId = taskId;
			this.pickupLocation = pickupLocation;
			this.destination = destination;
			this.packageWeight = packageWeight;
			this.routeClear = routeClear;
			this.packagePickedUp = packagePickedUp;
			this.delivered = delivered;
		}
		/**
		 * @return the packagePickedUp
		 */
		public boolean isPackagePickedUp() {
			return packagePickedUp;
		}
		/**
		 * @param packagePickedUp the packagePickedUp to set
		 */
		public void setPackagePickedUp(boolean packagePickedUp) {
			this.packagePickedUp = packagePickedUp;
		}
		/**
		 * @return the delivered
		 */
		public boolean isDelivered() {
			return delivered;
		}
		/**
		 * @param delivered the delivered to set
		 */
		public void setDelivered(boolean delivered) {
			this.delivered = delivered;
		}
		/**
		 * @param routeClear the routeClear to set
		 */
		public void setRouteClear(boolean routeClear) {
			this.routeClear = routeClear;
		}
		/**
		 * @return the taskId
		 */
		public String getTaskId() {
			return taskId;
		}
		/**
		 * @param taskId the taskId to set
		 */
		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
		/**
		 * @return the pickupLocation
		 */
		public String getPickupLocation() {
			return pickupLocation;
		}
		/**
		 * @param pickupLocation the pickupLocation to set
		 */
		public void setPickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
		}
		/**
		 * @return the destination
		 */
		public String getDestination() {
			return destination;
		}
		/**
		 * @param destination the destination to set
		 */
		public void setDestination(String destination) {
			this.destination = destination;
		}
		/**
		 * @return the packageWeight
		 */
		public double getPackageWeight() {
			return packageWeight;
		}
		/**
		 * @param packageWeight the packageWeight to set
		 */
		public void setPackageWeight(double packageWeight) {
			this.packageWeight = packageWeight;
		}
	    public boolean isRouteClear() {
	    	return routeClear;
	    }
	    
}
