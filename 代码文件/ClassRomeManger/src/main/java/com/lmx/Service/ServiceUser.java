package com.lmx.Service;

import com.lmx.Mapper.Mapper;
import com.lmx.Pojo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class ServiceUser {
//    用户模块对数据库的操作

private SqlSessionFactory build;

    public ServiceUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        build = sqlSessionFactoryBuilder.build(inputStream);

    }
    //    查找登录进来学生的id
    public String ServieSelectStudent(String username,String password){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        String i = mapper.SelectStudent(username, password);
        return i;
    }
    //    查找登录进来老师的id
    public String ServieSelectTeacher(String username,String password){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        String i = mapper.SelectTeacher(username, password);
        return i;

    }
    //    查找登录进来管理员的id
    public String ServieSelectManger(String username, String password){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        String i = mapper.SelectManger(username, password);
        return i;
    }
    //根据日期查找空闲教室
    public HashSet<Croom> ServiceSelectspareclassroom(String date, String starttime, String endtime){
        HashSet<Croom> objects = new HashSet<>();
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Croom> crooms = mapper.SelectSparetime(date, starttime, endtime);
        ArrayList<Croom> crooms1 = mapper.SelectRequestKong(date, starttime, endtime);
        crooms.addAll(crooms1);
        for (Croom c:crooms){
            objects.add(c);
        }
        return objects;

    }
//    插入课程
    public Integer ServiceInsertCourse(String id,String cname, String starttime,
                                       String endtime, String datetime,
                                      String cid, String tid){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        int integer = mapper.InsertCourse( id,cname, starttime, endtime, datetime, cid);
        if (integer>0){
            Integer integer1 = mapper.InsertTeaCou(tid, id);
        }
        sqlSession.commit();
        return integer;
    }
//    查找楼号
    public ArrayList<String> ServiceSelectCroom(){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<String> strings = mapper.SelectCroom();
        return strings;
    }
//    查找所有教室
    public ArrayList<String> ServiceSelectCoomroom(String roomnumber){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<String> strings = mapper.SelectCoomroom(roomnumber);
        return strings;
    }
//    验证是否这个时间段没有课程没有活动
    public ArrayList<Croom> ServiceSelectRequestCourse(String datetime,String startrequest,
                                                       String endrequest,
                                                       String foolnumber,
                                                       String roomnumber){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Croom> crooms = mapper.SelectRequestCourse(datetime, startrequest, endrequest, foolnumber, roomnumber);
        System.out.println("需求表中的信息"+crooms);

        ArrayList<Croom> crooms1 = mapper.SelectCoursrGuDing(datetime, startrequest, endrequest, foolnumber, roomnumber);
        System.out.println("课程表中的信息"+crooms1);
        crooms.addAll(crooms1);
        return crooms;
    }
//查询学生的
   public ArrayList<RequestLog> ServiceSelectrequestlog(String sid){
       SqlSession sqlSession = this.build.openSession();
       Mapper mapper = sqlSession.getMapper(Mapper.class);
       ArrayList<RequestLog> selectrequestlog = mapper.Selectrequestlog(sid);
       return selectrequestlog;
   }
//   查询老师的
   public ArrayList<RequestLog> SelectrequestlogTeacher(String tsid){
       SqlSession sqlSession = this.build.openSession();
       Mapper mapper = sqlSession.getMapper(Mapper.class);
       ArrayList<RequestLog> selectrequestlog = mapper.SelectrequestlogTeacher(tsid);
       return selectrequestlog;
   }
//  恢复表
   public  Integer ServiceInsertRequest(RequestLog requestLog){
       SqlSession sqlSession = this.build.openSession();
       Mapper mapper = sqlSession.getMapper(Mapper.class);
       Integer integer = mapper.InsertRequest(requestLog);
       sqlSession.commit();
       return integer;
   }
//   删除表
    public Integer ServiceDelectRequestLog(String id){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);


        Integer integer = mapper.DelectRequestLog(id);
        sqlSession.commit();
        return integer;
    }
}
