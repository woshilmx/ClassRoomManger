package com.lmx.Pojo;

public class Teacher {
//    创建教师对象

    private String tname;
    private String worknumber;
    private String tdept;
    private String tpassword;

    public Teacher() {
    }

    public Teacher(String tname, String worknumber, String tdept, String tpassword) {

        this.tname = tname;
        this.worknumber = worknumber;
        this.tdept = tdept;
        this.tpassword = tpassword;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tname='" + tname + '\'' +
                ", worknumber='" + worknumber + '\'' +
                ", tdept='" + tdept + '\'' +
                ", tpassword='" + tpassword + '\'' +
                '}';
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

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }
}
