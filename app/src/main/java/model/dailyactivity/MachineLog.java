package model.dailyactivity;

import java.util.Date;

import utility.DateTimeUtility;

public class MachineLog implements Log {

    protected Date start;
    protected Date end;
    protected double hour;
    protected String activity;

    public MachineLog() {
    }

    public MachineLog(Date start, Date end, String activity) {
        this.start = start;
        this.end = end;
        this.activity = activity;
        this.hour = DateTimeUtility.timeDiff(start,end);
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public double getHour() {
        return hour;
    }

    @Override
    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String getActivity() {
        return this.activity;
    }
}
