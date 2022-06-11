package com.lmx.Pojo;

public class Course {
    //    创建课程表
    private String id;
    private String cname;
    private String starttime;
    private String endtime;
    private String datetime;
    private Integer cid;
    private Integer tid;

    public Course() {
    }

    public Course(String id, String cname, String starttime, String endtime, String datetime, Integer cid, Integer tid) {
        this.id = id;
        this.cname = cname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.datetime = datetime;
        this.cid = cid;
        this.tid = tid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", cname='" + cname + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", datetime='" + datetime + '\'' +
                ", cid=" + cid +
                ", tid=" + tid +
                '}';
    }
}
