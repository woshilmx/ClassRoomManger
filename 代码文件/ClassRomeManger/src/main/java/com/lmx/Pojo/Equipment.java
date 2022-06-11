package com.lmx.Pojo;

public class Equipment {
    private String id;
    private String name;
    private Integer number;
    private String STATU;
    private String decription;
    private Integer cid;
    private String foolnumber;
    private String roomnumber;

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

    public Equipment() {
    }

    public Equipment(String id, String name, Integer number, String STATU, String decription) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.STATU = STATU;
        this.decription = decription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSTATU() {
        return STATU;
    }

    public void setSTATU(String STATU) {
        this.STATU = STATU;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", STATU='" + STATU + '\'' +
                ", decription='" + decription + '\'' +
                ", cid=" + cid +
                '}';
    }
}
