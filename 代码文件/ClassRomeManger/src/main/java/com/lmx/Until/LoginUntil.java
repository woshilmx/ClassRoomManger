package com.lmx.Until;

import com.lmx.Service.ServiceUser;

import java.io.IOException;

public class LoginUntil {
    public static String success( String index,String usernaem,String password) throws IOException {
        ServiceUser serviceUser = new ServiceUser();
        String id=null;
        switch (index){
            case "管理员":

                id = serviceUser.ServieSelectManger(usernaem,password);
                break;
            case "教师":
                id=serviceUser.ServieSelectTeacher(usernaem,password);
                break;
            case "学生":
                id= serviceUser.ServieSelectStudent(usernaem,password);
                break;
        }
        if (id!=null){
            return id;
        }
        else {
            return null;
        }
    }
}
