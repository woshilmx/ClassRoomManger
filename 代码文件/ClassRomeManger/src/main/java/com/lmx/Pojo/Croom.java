package com.lmx.Pojo;

public class Croom {
//    创建教室对象
    private String id;
    private String foolnumber;
    private String roomnumber;
    private Integer maxperson;

    public Croom() {
    }

    public Croom(String id, String foolnumber, String roomnumber, Integer maxperson) {
        this.id = id;
        this.foolnumber = foolnumber;
        this.roomnumber = roomnumber;
        this.maxperson = maxperson;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getMaxperson() {
        return maxperson;
    }

    public void setMaxperson(Integer maxperson) {
        this.maxperson = maxperson;
    }

    @Override
    public String toString() {
        return "Croom{" +
                "id='" + id + '\'' +
                ", foolnumber='" + foolnumber + '\'' +
                ", roomnumber='" + roomnumber + '\'' +
                ", maxperson=" + maxperson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Croom croom = (Croom) o;

        if (foolnumber != null ? !foolnumber.equals(croom.foolnumber) : croom.foolnumber != null) return false;
        if (roomnumber != null ? !roomnumber.equals(croom.roomnumber) : croom.roomnumber != null) return false;
        return maxperson != null ? maxperson.equals(croom.maxperson) : croom.maxperson == null;
    }

    @Override
    public int hashCode() {
        int result = foolnumber != null ? foolnumber.hashCode() : 0;
        result = 31 * result + (roomnumber != null ? roomnumber.hashCode() : 0);
        result = 31 * result + (maxperson != null ? maxperson.hashCode() : 0);
        return result;
    }
}
