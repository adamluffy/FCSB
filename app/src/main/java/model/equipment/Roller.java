package model.equipment;

public class Roller extends Machinery {

    public Roller() {
        setType(ROLLER);
    }

    public Roller(String machineId, String model) {
        super(machineId, model, ROLLER);
    }
}
