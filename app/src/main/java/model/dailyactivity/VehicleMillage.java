package model.dailyactivity;

import java.util.Date;

import model.equipment.Vehicle;
import model.site.Site;

public class VehicleMillage extends DailyActivity{

    private Vehicle vehicle;

    public VehicleMillage() {
    }

    public VehicleMillage(Date date, Site site, String operator, Vehicle vehicle) {
        super(date, site, operator);
        this.vehicle = vehicle;

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleMillage setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }


}
