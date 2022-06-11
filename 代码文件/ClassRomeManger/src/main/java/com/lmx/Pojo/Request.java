package com.lmx.Pojo;

public class  Request{
    private String id;
    private String thing;
    private String datetime;
    private String startrequest;
    private String endrequest;
    private Integer status;
    private String foolnumber;
    private  String roomnumber;
    private String name ;//姓名
    private String sdept;//部门
    private String studentid;//学号
    private String tname;//老师姓名
    private String worknumber;//老师工号
    private String tdept;//教师所属部门
    private String mid;
    private String cid;
    private String sid;
    private String tsid;

    public Request() {
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", thing='" + thing + '\'' +
                ", datetime='" + datetime + '\'' +
                ", startrequest='" + startrequest + '\'' +
                ", endrequest='" + endrequest + '\'' +
                ", status=" + status +
                ", foolnumber='" + foolnumber + '\'' +
                ", roomnumber='" + roomnumber + '\'' +
                ", name='" + name + '\'' +
                ", sdept='" + sdept + '\'' +
                ", studentid='" + studentid + '\'' +
                ", tname='" + tname + '\'' +
                ", worknumber='" + worknumber + '\'' +
                ", tdept='" + tdept + '\'' +
                ", mid='" + mid + '\'' +
                ", cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                ", tsid='" + tsid + '\'' +
                '}';
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getWorknumber() {
        return worknumber;
    }

    public void setWorknumber(String worknumber) {
        this.worknumber = worknumber;
    }

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
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
}
