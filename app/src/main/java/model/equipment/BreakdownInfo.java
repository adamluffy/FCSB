package model.equipment;

import java.util.Date;

public class BreakdownInfo {

    private Date startDate;
    private Date expectedCompleteDate;
    private String info;

    public BreakdownInfo() {
    }

    public BreakdownInfo(Date startDate, Date expectedCompleteDate, String info) {
        this.startDate = startDate;
        this.expectedCompleteDate = expectedCompleteDate;
        this.info = info;
    }

    public Date getStartDate() {
        return startDate;
    }

    public BreakdownInfo setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getExpectedCompleteDate() {
        return expectedCompleteDate;
    }

    public BreakdownInfo setExpectedCompleteDate(Date expectedCompleteDate) {
        this.expectedCompleteDate = expectedCompleteDate;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public BreakdownInfo setInfo(String info) {
        this.info = info;
        return this;
    }
}
