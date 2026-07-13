package classes;

public class RobotOperationFacade {

    private BatterySystem battery;
    private NavigationSystem navi;
    private PackageHandlingSystem packageH;

    public RobotOperationFacade(
            BatterySystem battery,
            NavigationSystem navi,
            PackageHandlingSystem packageH) {

        if (battery == null || navi == null || packageH == null) {
            throw new IllegalArgumentException(
                    "Systems cannot be null."
            );
        }

        this.battery = battery;
        this.navi = navi;
        this.packageH = packageH;
    }

    public BatterySystem getBattery() {
        return battery;
    }

    public void setBattery(BatterySystem battery) {

        if (battery == null) {
            throw new IllegalArgumentException(
                    "Battery system cannot be null."
            );
        }

        this.battery = battery;
    }

    public NavigationSystem getNavi() {
        return navi;
    }

    public void setNavi(NavigationSystem navi) {

        if (navi == null) {
            throw new IllegalArgumentException(
                    "Navigation system cannot be null."
            );
        }

        this.navi = navi;
    }

    public PackageHandlingSystem getPackageH() {
        return packageH;
    }

    public void setPackageH(PackageHandlingSystem packageH) {

        if (packageH == null) {
            throw new IllegalArgumentException(
                    "Package handling system cannot be null."
            );
        }

        this.packageH = packageH;
    }

    public boolean executeDeliveryTask(
            Robot robot,
            DeliveryTask task) {

        if (robot == null || task == null) {
            throw new IllegalArgumentException(
                    "Robot and task cannot be null."
            );
        }

        // Check the robot's battery.
        if (!battery.checkBattery(robot)) {
            return false;
        }

        // Check whether the delivery route is clear.
        if (!navi.checkRoute(task)) {
            return false;
        }

        // Pick up the package.
        packageH.pickUpPackage(task);

        // Move using the robot's current Strategy.
        robot.move();

        // Deliver the package.
        packageH.deliverPackage(task);

        return true;
    }
}