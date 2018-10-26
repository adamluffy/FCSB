package model.dailyactivity;

import java.util.ArrayList;
import java.util.Date;

import model.equipment.Machinery;
import model.site.Site;

public class OperatingHour extends DailyActivity {

    private Machinery machinery;
    private MeterHour meterHour;

    public OperatingHour() {
    }

    public OperatingHour(Date date, Site site, String operator, Machinery machinery, MeterHour meterHour) {
        super(date, site, operator);
        this.machinery = machinery;
        this.meterHour = meterHour;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public OperatingHour setMachinery(Machinery machinery) {
        this.machinery = machinery;
        return this;
    }

    public MeterHour getMeterHour() {
        return meterHour;
    }

    public OperatingHour setMeterHour(MeterHour meterHour) {
        this.meterHour = meterHour;
        return this;
    }


}
