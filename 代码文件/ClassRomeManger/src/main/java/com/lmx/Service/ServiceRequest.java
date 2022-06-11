package com.lmx.Service;

import com.lmx.Mapper.Mapper;
import com.lmx.Pojo.Equipment;
import com.lmx.Pojo.Request;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ServiceRequest {
    private SqlSessionFactory build;
    public ServiceRequest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        build = sqlSessionFactoryBuilder.build(inputStream);

    }
//查找到 教室的id
    public  String ServiceClassrooid(String fool,String classroom){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        String integer = mapper.SelectCroommumber(fool, classroom);
        return integer;
    }
//    审批对数据库的操作
    public  Integer ServiceInsertRequest(Request request){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Integer integer = mapper.IsertRequest(request.getId(),request.getThing(), request.getDatetime(), request.getStartrequest(), request.getEndrequest(), request.getStatus(), request.getCid(), request.getSid(), request.getTsid());
        sqlSession.commit();
        return  integer;
    }
    public ArrayList<Request> ServiceSelectArrylist(String sid){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Request> requests = mapper.SelectRequest(sid);
        return requests;
    }

    public ArrayList<Request> ServiceTeacherSelectArrylist(String sid){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Request> requests = mapper.SelectRequestTeacher(sid);
        return requests;
    }
//   查找出申报教室的设备信息
    public ArrayList<Equipment> ServiceEqument(String floor,String calssroomnumber){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Equipment> equipments = mapper.SelectEquipment(floor, calssroomnumber);
        return equipments;
    }
//    更新设备信息
public Integer ServiceUpdateEqument(String name,
        Integer status, String decription,
                              String foolnumber,
                              String roomnumber){
    System.out.println("传来的name"+name);
    SqlSession sqlSession = this.build.openSession();
    Mapper mapper = sqlSession.getMapper(Mapper.class);
    Integer integer = mapper.UpdateEquipment(name, status, decription, foolnumber, roomnumber);
    sqlSession.commit();
    return integer;
}

}
