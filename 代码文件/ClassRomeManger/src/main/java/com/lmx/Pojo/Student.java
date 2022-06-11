package com.lmx.Pojo;

public class Student {

    private String studentid;
    private String name;
    private String sdept;
    private String password;
    private Integer classnumber;

    public Student() {
    }

    public Student( String studentid, String name, String sdept, String password) {

        this.studentid = studentid;
        this.name = name;
        this.sdept = sdept;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", name='" + name + '\'' +
                ", sdept='" + sdept + '\'' +
                ", password='" + password + '\'' +
                ", classnumber=" + classnumber +
                '}';
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(Integer classnumber) {
        this.classnumber = classnumber;
    }
}
