package model.equipment;

public class DumpTruck extends Machinery {

    public DumpTruck() {
        setType(DUMPTRUCK);
    }

    public DumpTruck(String machineId, String model) {
        super(machineId, model, DUMPTRUCK);
    }
}
