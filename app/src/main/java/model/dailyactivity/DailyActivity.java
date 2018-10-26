package model.dailyactivity;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

import model.site.Site;

public class DailyActivity {

    private Date date;
    private Site site;
    private String operator;
    private @ServerTimestamp Date createdAt;
    private Date updateAt;

    DailyActivity() {}

    DailyActivity(Date date, Site site, String operator) {
        this.date = date;
        this.site = site;
        this.operator = operator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }



}
