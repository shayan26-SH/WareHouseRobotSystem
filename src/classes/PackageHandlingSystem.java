package classes;


public class PackageHandlingSystem {

    public void pickUpPackage(DeliveryTask task) {

        if (task == null)
            throw new IllegalArgumentException();

        task.setPackagePickedUp(true);
    }

    public void deliverPackage(DeliveryTask task) {

        if (task == null)
            throw new IllegalArgumentException();

        task.setDelivered(true);
    }

}