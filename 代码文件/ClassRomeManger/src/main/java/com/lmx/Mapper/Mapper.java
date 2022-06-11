package com.lmx.Mapper;

import com.lmx.Pojo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface Mapper {
// 根据用户名和密码查询学生
    String SelectStudent(@Param("studentid") String studentid,@Param("password") String password);
    // 根据用户名和密码查询教师
    String SelectTeacher(@Param("worknumber") String worknumber, @Param("tpassword") String tpassword);
    // 根据用户名和密码查询管理员
    String SelectManger(@Param("username") String username, @Param("mpassword") String mpassword);
//   根据日期，开始时间，结束时间，查询空闲教室
    ArrayList<Croom> SelectSparetime(@Param("datetime") String datetime,
                            @Param("starttime") String starttime,@Param("endtime") String endtimg);

// 审批教室
//获取教室编号
    String SelectCroommumber(@Param("foolnumber") String fllimumber,
                              @Param("roomnumber") String roomnumber);
//    插入申请
//private String thing;
//    private String datetime;
//    private String startrequest;
//    private String endrequest;
//    private Integer status;
//    private Integer sid;
//    private Integer tsid;
    Integer IsertRequest(@Param("id") String id,@Param("thing") String thing,
                         @Param("datetime") String datetime,@Param("startrequest") String start,
                         @Param("endrequest") String endrequest,@Param("status") Integer status,
                         @Param("cid") String cid,
                         @Param("sid") String sid,@Param("tsid") String tsid
                         );

//    找到自己的审批申请
    ArrayList<Request> SelectRequest(@Param("sid") String sid);
//    得到某个教室的设备名称
    ArrayList<Equipment> SelectEquipment(@Param("foolnumber") String fllimumber,
                                         @Param("roomnumber") String roomnumber);
//更新设备表中的损坏信息
    Integer UpdateEquipment(@Param("name") String name,@Param("STATU")
            Integer status,@Param("decription") String decription,
                            @Param("foolnumber") String foolnumber,
                            @Param("roomnumber") String roomnumber);
//    插入课程
    Integer InsertCourse(@Param("id") String id,@Param("cname") String cname,@Param("starttime") String starttime,
                         @Param("endtime") String endtime,@Param("datetime") String datetime,
                         @Param("cid") String cid);
//    查找老师的申请信息
    ArrayList<Request> SelectRequestTeacher(@Param("tsid") String tsid);
// 查找待审批的请求
    ArrayList<Request> SelectRequsrtToManger();
// 查找老师审批
    ArrayList<Request> SelectRequestTeacherTomanger();
//    查找到所有的报修设备
    ArrayList<Equipment> SelectEquipmentBad();
//    设备修改后报修
    Integer UpdateEquipmentGood(@Param("id") String id);
    // 教师审批
    Integer UpdateTracherRqquestTeacher(@Param("id") String id,@Param("status") Integer status);
    // 学生审批
    Integer UpdateTracherRqquestStudent(@Param("id") String id,@Param("status") Integer status,@Param("mid") String mid);
// 查找出学生审批结果记录
    ArrayList<Request> SelectrequestMananger(@Param("id") String id);
    //查找老师审批结果
    ArrayList<Request> SelectrequestMangerTeacher(@Param("id") String id);
    // 删除request表中某一行的数据
    Integer DelectRequest(@Param("id") String id);
    // 查询出request表中的空闲教室
    ArrayList<Croom> SelectRequestKong(@Param("datetime") String datetime,@Param("startrequest")String startrequest,
                                       @Param("endrequest") String endrequest);
//    查询出所有楼号
    ArrayList<String> SelectCroom();
//    查询出楼号下的教室
    ArrayList<String> SelectCoomroom(@Param("foolnumber") String foolnumber);
//    验证这个教室是非空
ArrayList<Croom> SelectRequestCourse(@Param("datetime") String datetime,@Param("startrequest")String startrequest,
                                   @Param("endrequest") String endrequest,
                                     @Param("foolnumber") String foolnumber,
                                     @Param("roomnumber") String roomnumber);
// 验证课程
ArrayList<Croom> SelectCoursrGuDing(@Param("datetime") String datetime,@Param("starttime")String starttime,
                                     @Param("endtime") String endtime,
                                     @Param("foolnumber") String foolnumber,
                                     @Param("roomnumber") String roomnumber);
//删除需求表中超过时间的地方
    Integer DelectRequestmoretime(@Param("datetime") String datetime,@Param("endrequest") String endrequest);
//    查询出学生日志表中误删的东西
    ArrayList<RequestLog> Selectrequestlog(@Param("sid") String sid);
    ArrayList<RequestLog> SelectrequestlogTeacher(@Param("tsid") String tsid);
//    恢复到request表中
    Integer InsertRequest(RequestLog requestLog);
//    删除requestlog表中的数据
    Integer DelectRequestLog(@Param("id") String id);
//    插入连接表中
    Integer InsertTeaCou(@Param("tsid")String tsid,@Param("coid") String coid);
}
