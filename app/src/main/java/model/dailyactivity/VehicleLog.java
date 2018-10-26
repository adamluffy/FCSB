package model.dailyactivity;

import java.util.Date;

public class VehicleLog implements Log{

    protected Date time;
    protected String activity;
    protected int millage;

    public VehicleLog() {
    }

    public VehicleLog(Date time, String activity, int millage) {
        this.time = time;
        this.activity = activity;
        this.millage = millage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }


    @Override
    public void setActivity(String activity) {
        this.activity=activity;
    }

    @Override
    public String getActivity() {
        return this.activity;
    }
}
