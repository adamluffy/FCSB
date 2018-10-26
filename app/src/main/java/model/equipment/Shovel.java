package model.equipment;

public class Shovel extends Machinery {

    public Shovel() {

        setType(SHOVEL);
    }

    public Shovel(String machineId, String model) {
        super(machineId, model, SHOVEL);
    }
}
