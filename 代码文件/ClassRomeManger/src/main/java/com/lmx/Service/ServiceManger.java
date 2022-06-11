package com.lmx.Service;

import com.lmx.Mapper.Mapper;
import com.lmx.Pojo.Equipment;
import com.lmx.Pojo.Request;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ServiceManger {
//    管理员对数据库的操作
private SqlSessionFactory build;

    public ServiceManger() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        build = sqlSessionFactoryBuilder.build(inputStream);

    }
//    找到所有的学生审批
    public ArrayList<Request> ServiceSelectRequestToManger(){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Request> requests = mapper.SelectRequsrtToManger();
        return  requests;
    }
    //    找到所有的老师审批
    public ArrayList<Request> ServiceSelectRequestTeacherToManger(){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Request> requests = mapper.SelectRequestTeacherTomanger();
        return  requests;
    }
//    查找所有的坏的设备
    public ArrayList<Equipment> ServiceSelectBadEquipment(){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Equipment> equipment = mapper.SelectEquipmentBad();
        return  equipment;
    }
//    报修好的设备
    public Integer ServiceUpdateEquipmentGood(String id){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Integer integer = mapper.UpdateEquipmentGood(id);
        sqlSession.commit();
        return integer;
    }
// 学生审批1-正在审核2-通过3-驳回
    public Integer ServiceUpdateTracherRqquestStudent(String id,Integer status,String mid){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Integer integer = mapper.UpdateTracherRqquestStudent(id,status,mid);
        sqlSession.commit();
        return integer;
    }
//
// 老师审批结果，1-正在审核2-通过3-驳回
public Integer ServiceUpdateTracherRqquestTeacher(String id,Integer status){
    SqlSession sqlSession = this.build.openSession();
    Mapper mapper = sqlSession.getMapper(Mapper.class);
    Integer integer = mapper.UpdateTracherRqquestTeacher(id,status);
    sqlSession.commit();
    return integer;
}
// 查询出已审批的结果
    public ArrayList<Request> ServiceSelectAllrequestManger(String id){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        ArrayList<Request> requests = mapper.SelectrequestMananger(id);
        ArrayList<Request> requests1 = mapper.SelectrequestMangerTeacher(id);
        requests.addAll(requests1);
        System.out.println(requests);
        return requests;
    }
    public Integer ServiceDelectRequest(String id){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Integer integer = mapper.DelectRequest(id);
        sqlSession.commit();
        return integer;
    }
    public Integer ServiceDelectRequestmoretime(String datetime,String endtime){
        SqlSession sqlSession = this.build.openSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        Integer integer = mapper.DelectRequestmoretime(datetime,endtime);
        sqlSession.commit();
        return integer;
    }
}
