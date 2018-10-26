package model.equipment;

public class Vehicle {

    private String plateNumber;
    private String model;
    private String chassis;
    private String engineNo;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String plateNumber, String model, String chassis, String engineNo, String owner) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.chassis = chassis;
        this.engineNo = engineNo;
        this.owner = owner;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
