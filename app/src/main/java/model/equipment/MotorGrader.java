package model.equipment;

public class MotorGrader extends Machinery {

    public MotorGrader() {
        setType(MOTORGRADER);
    }

    public MotorGrader(String machineId, String model) {
        super(machineId, model, MOTORGRADER);
    }
}
