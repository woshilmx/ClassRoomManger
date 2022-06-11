package com.lmx.View.Person;

import com.lmx.Pojo.Equipment;
import com.lmx.Pojo.Request;
import com.lmx.Service.ServiceManger;
import com.lmx.Until.MyEquipmentbutton;
//import com.lmx.Until.MyTeacherbutton;
import com.lmx.Until.MyFoundButton;
import com.lmx.Until.Mybutton;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class ManangerLogin extends JFrame {
    private String id;
    private JPanel jPanel=new JPanel();
    public ManangerLogin(){
        this.init();

    }
    public ManangerLogin(String id){
        this.id=id;
        this.init();
    }

    private void init() {
        this.setTitle("教室信息管理系统");
        this.setSize(1300,700);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.setjpanel();
        this.setVisible(true);
    }

    private void setjpanel() {
        jPanel.setLayout(null);
        JLabel jLabel = new JLabel("教室信息管理系统---管理员端");
        jLabel.setBounds(485,30,430,40);
        jLabel.setFont(new Font("",Font.BOLD,30));
        jPanel.add(jLabel);

        JMenuBar menuBar = new JMenuBar(); // 创建一个菜单栏
        JMenu fileMenu = new JMenu("教师审批"); // 创建一个菜单
        fileMenu.setFont(new Font(null,Font.BOLD,20));
        JMenu studentmenu = new JMenu("学生审批"); // 创建一个菜单
        studentmenu.setFont(new Font(null,Font.BOLD,20));
        JMenu editMenu = new JMenu("设备"); // 创建一个菜单

        editMenu.setFont(new Font(null,Font.BOLD,20));
        JMenu equment = new JMenu("查找"); // 创建一个菜单
        equment.setFont(new Font(null,Font.BOLD,20));

        menuBar.add(fileMenu);
        menuBar.add(studentmenu);
        menuBar.add(editMenu);
        menuBar.add(equment);

//        教师审批记录点击事件
        fileMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JScrollPane jScrollPane=new JScrollPane();
                ArrayList<Request> res=null;
                try {

                    res = new ServiceManger().ServiceSelectRequestTeacherToManger();
                    System.out.println(res.size());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                String columnNames[]={"事项","使用日期","开始时间","结束时间","楼号","教室编号",
                        "姓名","工号","所属院系","通过","驳回"};
                DefaultTableModel dm = // 重写表格
                        new DefaultTableModel(columnNames,0); // 列名
                JTable jTable = new JTable(dm);
                jTable.setFont(new Font(null,Font.PLAIN,18));
                jTable.setRowHeight(25);
                JTableHeader tab_header =jTable.getTableHeader();					//获取表头
                tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                tab_header.setPreferredSize(new Dimension(tab_header.getWidth(), 30));

                for (Request r:res){
                    Vector<Object> objects = new Vector<>();
                    objects.add(r.getThing());
                    objects.add(r.getDatetime());
                    objects.add(r.getStartrequest());
                    objects.add(r.getEndrequest());
                    objects.add(r.getFoolnumber());
                    objects.add(r.getRoomnumber());
                    objects.add(r.getTname());
                    objects.add(r.getWorknumber());
                    objects.add(r.getTdept());
                    dm.addRow(objects);
                }
                Mybutton.arrayList=res;
                jTable.getColumnModel().getColumn(9).setCellEditor(new Mybutton("通过",2,res,dm,id));
                jTable.getColumnModel().getColumn(9).setCellRenderer(new Mybutton("通过",2,res,dm,id) );
                jTable.getColumnModel().getColumn(10).setCellEditor(new Mybutton("驳回",3,res,dm,id));
                jTable.getColumnModel().getColumn(10).setCellRenderer(new Mybutton("驳回",3,res,dm,id) );

                //                显示
                jScrollPane.setViewportView(jTable);
                setContentPane(jScrollPane);
                setVisible(true);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
//        学生审批界面
        studentmenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JScrollPane jScrollPane=new JScrollPane();
                ArrayList<Request> requests=null;
                try {
                    ServiceManger serviceManger = new ServiceManger();

                    requests = serviceManger.ServiceSelectRequestToManger();
                    System.out.println(requests);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                String columnNames[]={"事项","使用日期","开始时间","结束时间","楼号","教室编号",
                        "姓名","学号","所属院系","通过","驳回"};
                DefaultTableModel dm = // 重写表格
                        new DefaultTableModel(columnNames,0); // 列名
                JTable jTable = new JTable(dm);
                jTable.setFont(new Font(null,Font.PLAIN,18));
                jTable.setRowHeight(25);
                JTableHeader tab_header =jTable.getTableHeader();					//获取表头
                tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                tab_header.setPreferredSize(new Dimension(tab_header.getWidth(), 30));

                for (Request r:requests){
                    Vector<Object> objects = new Vector<>();
                    objects.add(r.getThing());
                    objects.add(r.getDatetime());
                    objects.add(r.getStartrequest());
                    objects.add(r.getEndrequest());
                    objects.add(r.getFoolnumber());
                    objects.add(r.getRoomnumber());
                    objects.add(r.getName());
                    objects.add(r.getStudentid());
                    objects.add(r.getSdept());
                    dm.addRow(objects);

                }
Mybutton.arrayList=requests;
                jTable.getColumnModel().getColumn(9).setCellEditor(new Mybutton("通过",2,requests,dm,id));
                jTable.getColumnModel().getColumn(9).setCellRenderer(new Mybutton("通过",2,requests,dm,id) );
                jTable.getColumnModel().getColumn(10).setCellEditor(new Mybutton("驳回",3,requests,dm,id));
                jTable.getColumnModel().getColumn(10).setCellRenderer(new Mybutton("驳回",3,requests,dm,id) );
                jScrollPane.setViewportView(jTable);
                setContentPane(jScrollPane);
                setVisible(true);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
//        设备按钮
        editMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JScrollPane jScrollPane=new JScrollPane();
                ArrayList<Equipment> res=null;
                try {

                    res = new ServiceManger().ServiceSelectBadEquipment();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                String columnNames[]={"设备名称","数量","描述","楼号","教室编号","已修好"};
                DefaultTableModel dm = // 重写表格
                        new DefaultTableModel(columnNames,0); // 列名
                JTable jTable = new JTable(dm);
                jTable.setFont(new Font(null,Font.PLAIN,18));
                jTable.setRowHeight(25);
                JTableHeader tab_header =jTable.getTableHeader();					//获取表头
                tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                tab_header.setPreferredSize(new Dimension(tab_header.getWidth(), 30));
                for (Equipment r:res){
                    Vector<Object> objects = new Vector<>();
                    objects.add(r.getName());
                    objects.add(r.getNumber());
                    objects.add(r.getDecription());
                    objects.add(r.getFoolnumber());
                    objects.add(r.getRoomnumber());

                    dm.addRow(objects);
                }
                MyEquipmentbutton.arrayList=res;
                jTable.getColumnModel().getColumn(5).setCellEditor(new MyEquipmentbutton("已修好",res,dm));
                jTable.getColumnModel().getColumn(5).setCellRenderer(new MyEquipmentbutton("已修好",res,dm) );
                JButton queren = new JButton("确定");
                jScrollPane.setViewportView(jTable);
                setContentPane(jScrollPane);
                setVisible(true);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
//        查找功能的菜单实现
        equment.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                try {
                    JScrollPane jScrollPane=new JScrollPane();
                    ArrayList<Request> requests = new ServiceManger().ServiceSelectAllrequestManger(id);
                    System.out.println(requests);
                    String columnNames[]={"事项","使用日期","开始时间","结束时间","楼号","教室编号",
                            "姓名","学号/工号","所属院系","状态","操作1","操作2"};
                    DefaultTableModel dm = // 重写表格
                            new DefaultTableModel(columnNames,0); // 列名
                    JTable jTable = new JTable(dm);
                    jTable.setFont(new Font(null,Font.PLAIN,18));
                    jTable.setRowHeight(25);
                    JTableHeader tab_header =jTable.getTableHeader();					//获取表头
                    tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                    tab_header.setPreferredSize(new Dimension(tab_header.getWidth(), 30));

                    for (Request r:requests){
                        Vector<Object> objects = new Vector<>();
                        objects.add(r.getThing());
                        objects.add(r.getDatetime());
                        objects.add(r.getStartrequest());
                        objects.add(r.getEndrequest());
                        objects.add(r.getFoolnumber());
                        objects.add(r.getRoomnumber());
//                        如果是老师
                       if (r.getSid()!=null){
                           objects.add(r.getName());
                           objects.add(r.getStudentid());
                           objects.add(r.getSdept());
                           if (r.getStatus()==2){
                               objects.add("已通过");
                           }
                           else {
                               objects.add("已驳回");
                           }
                       }
                       else if (r.getTsid()!=null){
                           objects.add(r.getTname());
                           objects.add(r.getWorknumber());
                           objects.add(r.getTdept());
                            if (r.getStatus()==3){
                               objects.add("已驳回");
                           }
                            else {
                                objects.add("已通过");
                            }
                       }


//                        objects.add(r.getName());
//                        objects.add(r.getStudentid());
//                        objects.add(r.getSdept());
                        dm.addRow(objects);

                    }
                    MyFoundButton.arrayList=requests;
                    jTable.getColumnModel().getColumn(10).setCellEditor(new MyFoundButton("通过",2,dm,id));
                    jTable.getColumnModel().getColumn(10).setCellRenderer(new MyFoundButton("通过",2,dm,id) );
                    jTable.getColumnModel().getColumn(11).setCellEditor(new MyFoundButton("驳回",3,dm,id));
                    jTable.getColumnModel().getColumn(11).setCellRenderer(new MyFoundButton("驳回",3,dm,id) );
                    jScrollPane.setViewportView(jTable);
                    setContentPane(jScrollPane);
                    setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
//        menuBar.add(helpMenu);
//        menuBar.add(quit);
        this.setJMenuBar(menuBar);
        setContentPane(jPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        ManangerLogin manangerLogin = new ManangerLogin();
    }

}
