package model.equipment;

public class GenSet extends Machinery {

    public GenSet() {
        setType(GENSET);
    }

    public GenSet(String machineId, String model) {
        super(machineId, model, GENSET);
    }
}
