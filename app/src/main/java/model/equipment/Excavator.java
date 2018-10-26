package model.equipment;

public class Excavator extends Machinery{

    private String category;

    public Excavator() {
        setType(EXCAVATOR);
    }

    public Excavator(String machineId, String model, String category) {
        super(machineId, model, EXCAVATOR);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Excavator setCategory(String category) {

        this.category = category;
        return this;
    }
}
