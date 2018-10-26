package model.dailyactivity;

public class MeterHour {

    private int startMeter;
    private int endMeter;
    private int meterHour;

    public MeterHour() {
    }

    public MeterHour(int startMeter, int endMeter) {
        this.startMeter = startMeter;
        this.endMeter = endMeter;
        this.meterHour = endMeter-startMeter;
    }

    public int getStartMeter() {
        return startMeter;
    }

    public void setStartMeter(int startMeter) {
        this.startMeter = startMeter;
    }

    public int getEndMeter() {
        return endMeter;
    }

    public void setEndMeter(int endMeter) {
        this.endMeter = endMeter;
    }

    public int getMeterHour() {
        return meterHour;
    }
}
