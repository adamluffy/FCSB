package model.equipment;

public class Bulldozer extends Machinery {

    public Bulldozer() {
        setType(Machinery.BULLDOZER);
    }

    public Bulldozer(String machineId, String model) {
        super(machineId, model, BULLDOZER);
    }

}
