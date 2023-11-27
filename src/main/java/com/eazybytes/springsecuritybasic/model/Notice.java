package com.eazybytes.springsecuritybasic.model;

import java.sql.Date;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "notice_details")
public class Notice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "notice_id")
    private int noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notic_beg_date")
    private Date noticBegDt;

    @Column(name = "notic_end_date")
    private Date noticEndDt;

    @Column(name = "created_at")
    private Date createDt;

    @Column(name = "updated_at")
    private Date updateDt;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticBegDt() {
        return noticBegDt;
    }

    public void setNoticBegDt(Date noticBegDt) {
        this.noticBegDt = noticBegDt;
    }

    public Date getNoticEndDt() {
        return noticEndDt;
    }

    public void setNoticEndDt(Date noticEndDt) {
        this.noticEndDt = noticEndDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
