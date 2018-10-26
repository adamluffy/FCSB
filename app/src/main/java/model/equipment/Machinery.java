package model.equipment;


public class Machinery {

    public static final String ADT = "ADT";
    public static final String EXCAVATOR = "Excavator";
    public static final String BULLDOZER = "Bulldozer";
    public static final String MOTORGRADER = "Motor Grader";
    public static final String ROLLER = "Roller";
    public static final String DUMPTRUCK = "Dump Truck";
    public static final String WATERTANKER = "Water Tanker";
    public static final String DIESELTANKER = "Diesel Tanker";
    public static final String SHOVEL = "Shovel";
    public static final String GENSET = "Generator Set";

    private String machineId;
    private String model;
    private String type;
    private Location location;
    private BreakdownInfo info;

    public Machinery() {
    }

    public Machinery(String machineId, String model, String type) {
        this.machineId = machineId;
        this.model = model;
        this.type = type;
    }

    public String getMachineId() {
        return machineId;
    }

    public Machinery setMachineId(String machineId) {
        this.machineId = machineId;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Machinery setModel(String model) {
        this.model = model;
        return this;
    }

    public String getType() {
        return type;
    }

    public Machinery setType(String type) {

        this.type = type;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Machinery setLocation(Location location) {

        this.location = location;
        return this;
    }

    public BreakdownInfo getInfo() {
        return info;
    }

    public Machinery setInfo(BreakdownInfo info) {

        this.info = info;
        return this;
    }


}
