package model.equipment;

public class ADT extends Machinery{

    private String category;

    public ADT() {
        setType(ADT);
    }

    public ADT(String machineId, String model, String category) {
        super(machineId, model, ADT);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public ADT setCategory(String category) {
        this.category = category;
        return this;
    }

}
