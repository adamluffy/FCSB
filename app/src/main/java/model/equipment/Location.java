package model.equipment;

import java.util.Date;

import model.site.Site;

public class Location {

    private Site site;
    private Date fromDate;
    private Date endDate;

    public Location() {
    }

    public Location(Site site, Date fromDate) {
        this.site = site;
        this.fromDate = fromDate;

    }

    public Site getSite() {
        return site;
    }

    public Location setSite(Site site) {

        this.site = site;
        return this;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Location setFromDate(Date fromDate) {

        this.fromDate = fromDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Location setEndDate(Date endDate) {

        this.endDate = endDate;
        return this;
    }
}
