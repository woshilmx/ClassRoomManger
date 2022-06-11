package com.lmx.Pojo;

public class RequestLog {
    private String id;
    private String thing;
    private String datetime;
    private String startrequest;
    private String endrequest;
    private String cid;
    private String sid;
    private String tsid;
    private Integer status;
    private String mid;
    private String foolnumber;
    private  String roomnumber;

    public RequestLog() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStartrequest() {
        return startrequest;
    }

    public void setStartrequest(String startrequest) {
        this.startrequest = startrequest;
    }

    public String getEndrequest() {
        return endrequest;
    }

    public void setEndrequest(String endrequest) {
        this.endrequest = endrequest;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTsid() {
        return tsid;
    }

    public void setTsid(String tsid) {
        this.tsid = tsid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getFoolnumber() {
        return foolnumber;
    }

    public void setFoolnumber(String foolnumber) {
        this.foolnumber = foolnumber;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    @Override
    public String toString() {
        return "RequestLog{" +
                "id='" + id + '\'' +
                ", thing='" + thing + '\'' +
                ", datetime='" + datetime + '\'' +
                ", startrequest='" + startrequest + '\'' +
                ", endrequest='" + endrequest + '\'' +
                ", cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                ", tsid='" + tsid + '\'' +
                ", status=" + status +
                ", mid='" + mid + '\'' +
                ", foolnumber='" + foolnumber + '\'' +
                ", roomnumber='" + roomnumber + '\'' +
                '}';
    }
}
