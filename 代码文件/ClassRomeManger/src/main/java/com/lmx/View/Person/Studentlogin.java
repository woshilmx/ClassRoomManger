package com.lmx.View.Person;

import com.lmx.Pojo.Croom;
import com.lmx.Pojo.Equipment;
import com.lmx.Pojo.Request;
import com.lmx.Pojo.RequestLog;
import com.lmx.Service.ServiceRequest;
import com.lmx.Service.ServiceUser;
import com.lmx.Until.MyRecoverbutton;
import com.lmx.Until.MyShengpibutton;
import com.lmx.Until.Mybutton;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Pattern;

//学生权限之后
public class Studentlogin extends JFrame{
//    private String name;
    private  String id;
    private JPanel jPanel=new JPanel();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Studentlogin(String id) throws HeadlessException {
//        初始化窗体程序
        this.id=id;
        this.init();

    }

    // 初始化
    protected void init() {
        this.setTitle("教室信息管理系统");
        this.setSize(700,700);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.setjpanel();
        this.setVisible(true);


    }
//    创建panel
    private void setjpanel(){
//        创建页面
//        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        JLabel jLabel = new JLabel("教室信息管理系统---学生端");
        jLabel.setBounds(160,30,400,40);
        jLabel.setFont(new Font("",Font.BOLD,30));
        jPanel.add(jLabel);

//        设置菜单组
        JMenuBar menuBar = new JMenuBar(); // 创建一个菜单栏
        JMenu fileMenu = new JMenu("查询"); // 创建一个菜单
        fileMenu.setFont(new Font(null,Font.BOLD,20));
        JMenu editMenu = new JMenu("审批"); // 创建一个菜单

        editMenu.setFont(new Font(null,Font.BOLD,20));
        JMenu equment = new JMenu("设备报修"); // 创建一个菜单

        equment.setFont(new Font(null,Font.BOLD,20));
        JMenu helpMenu = new JMenu("我的申请"); // 创建一个菜单
        JMenu huifu = new JMenu("恢复");//恢复按钮
        huifu.setFont(new Font(null,Font.BOLD,20));
        helpMenu.setFont(new Font(null,Font.BOLD,20));
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(equment);
        menuBar.add(helpMenu);
        menuBar.add(huifu);
//        menuBar.add(quit);
        this.setJMenuBar(menuBar);
        huifu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                try {
                    JScrollPane jScrollPane=new JScrollPane();
                    ServiceUser serviceUser = new ServiceUser();
                    ArrayList<RequestLog> requestLogs = serviceUser.ServiceSelectrequestlog(id);
                    System.out.println(requestLogs);
                    String columnNames[]={"申请事项","日期","开始时间","结束时间","楼号","教室编号","恢复"};
                    DefaultTableModel dm = // 重写表格
                            new DefaultTableModel(columnNames,0); // 列名
                    JTable jTable = new JTable(dm);
                    jTable.setFont(new Font(null,Font.PLAIN,18));
                    jTable.setRowHeight(25);
                    JTableHeader tab_header =jTable.getTableHeader();					//获取表头
                    tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                    tab_header.setPreferredSize(new Dimension(tab_header.getWidth(), 30));
                    for (RequestLog r:requestLogs){
                        Vector<Object> objects = new Vector<>();
                        objects.add(r.getThing());
                        objects.add(r.getDatetime());
                        objects.add(r.getStartrequest());
                        objects.add(r.getEndrequest());
                        objects.add(r.getFoolnumber());
                        objects.add(r.getRoomnumber());

                        dm.addRow(objects);

                    }
                    MyRecoverbutton.arrayList=requestLogs;
                    System.out.println("该学生的id是"+id);
                    jTable.getColumnModel().getColumn(6).setCellEditor(new MyRecoverbutton("恢复",2,requestLogs,dm,id));
                    jTable.getColumnModel().getColumn(6).setCellRenderer(new MyRecoverbutton("恢复",2,requestLogs,dm,id) );
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
//添加查询事件

//        quit.addMenuListener(new MenuListener() {
//
//            @Override
//            public void menuSelected(MenuEvent e) {
//
//            }
//
//            @Override
//            public void menuDeselected(MenuEvent e) {
//                System.exit(0);
//            }
//
//            @Override
//            public void menuCanceled(MenuEvent e) {
//
//            }
//        });
        fileMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
//                getTimeclassroom()a
                addSelect();


//
//                JLabel starttime = new JLabel("开始时间");
//                starttime.setBounds(190,100,400,40);
//                starttime.setFont(new Font("",Font.BOLD,20));
//                jPanel.add(date);
//
//                JLabel end = new JLabel("结束时间");
//                end.setBounds(220,100,400,40);
//                end.setFont(new Font("",Font.BOLD,20));
//                jPanel.add(end);
                setContentPane(jPanel);
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
// 添加审批界面
        editMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JPanel jp = null;
                try {
                    jp = addRequestSwing();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                setContentPane(jp);
                setVisible(true);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
//        添加我的申请界面
        helpMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JScrollPane jScrollPane=new JScrollPane();
                ArrayList<Request> requests = null;
                try {
                    requests = new ServiceRequest().ServiceSelectArrylist(id);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(requests.toString());
                //
                String columnNames[]={"申请事项","日期","开始时间","结束时间","楼号","教室编号","审批状态","删除"};
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
        if (r.getStatus()==1){
            objects.add("正在审批");

        }
        else if(r.getStatus()==2){
            objects.add("通过");
        }
        else {
            objects.add("驳回");
        }
        dm.addRow(objects);

    }
                MyShengpibutton.arrayList=requests;
                System.out.println("该学生的id是"+id);
                jTable.getColumnModel().getColumn(7).setCellEditor(new MyShengpibutton("删除",2,requests,dm,id));
                jTable.getColumnModel().getColumn(7).setCellRenderer(new MyShengpibutton("删除",2,requests,dm,id) );
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
//        设备申报界面
        equment.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JPanel jPanel = null;
                try {
                    jPanel = addEquipment();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                setContentPane(jPanel);
                setVisible(true);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });


        //        添加面板到框架
        this.setContentPane(jPanel);
    }
// 增加审批的功能按钮
    private JPanel addRequestSwing() throws IOException {
        JPanel jp = new JPanel();
        jp.setLayout(null);
        JLabel jLabel = new JLabel("教室信息管理系统---学生端");
        jLabel.setBounds(160,30,400,40);
        jLabel.setFont(new Font("",Font.BOLD,30));
        jp.add(jLabel);

//申请事项
        JLabel thing = new JLabel("申请事项");
        thing.setBounds(100,100,100,40);
        thing.setFont(new Font("",Font.BOLD,20));
        jp.add(thing);
        //      输入框
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font(null,Font.PLAIN,20));
        jTextArea.setBounds(230,90,400,60);
        jp.add(jTextArea);
//
        JLabel use = new JLabel("使用日期");
        use.setBounds(100,170,100,40);
        use.setFont(new Font("",Font.BOLD,20));
        jp.add(use);

        JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("",Font.BOLD,20));
        jTextField.setBounds(230,170,200,40);
        jp.add(jTextField);

        JLabel sta = new JLabel("开始时间");
        sta.setBounds(100,240,100,40);
        sta.setFont(new Font("",Font.BOLD,20));
        jp.add(sta);

        JTextField statext = new JTextField();
        statext.setFont(new Font("",Font.BOLD,20));
        statext.setBounds(230,240,200,40);
        jp.add(statext);

        JLabel end = new JLabel("结束时间");
        end.setBounds(100,310,100,40);
        end.setFont(new Font("",Font.BOLD,20));
        jp.add(end);

        JTextField endtext = new JTextField();
        endtext.setFont(new Font("",Font.BOLD,20));
        endtext.setBounds(230,310,200,40);
        jp.add(endtext);

        JLabel classroom = new JLabel("楼号");
        classroom.setBounds(100,370,100,40);
        classroom.setFont(new Font("",Font.BOLD,20));
        jp.add(classroom);

//        JTextField ca= new JTextField();
//        ca.setFont(new Font("",Font.BOLD,20));
//        ca.setBounds(230,370,200,40);
//        jp.add(ca);
        ArrayList<String> strings = new ServiceUser().ServiceSelectCroom();
        String[] strings1 = strings.toArray(new String[strings.size()]);
        JComboBox<String> ca = new JComboBox<>(strings1);
        ca.setFont(new Font("",Font.BOLD,20));
        ca.setBounds(230,370,200,40);
        ca.setSelectedIndex(-1);
        jp.add(ca);


        JLabel jiaoshi = new JLabel("教室编号");
        jiaoshi.setBounds(100,430,100,40);
        jiaoshi.setFont(new Font("",Font.BOLD,20));
        jp.add(jiaoshi);

//        JTextField jiao= new JTextField();
//        jiao.setFont(new Font("",Font.BOLD,20));
//        jiao.setBounds(230,430,200,40);
//        jp.add(jiao);
        JComboBox<String> jiao = new JComboBox<>();
        jiao.setFont(new Font("",Font.BOLD,20));
        jiao.setBounds(230,430,200,40);
        jp.add(jiao);

        ca.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = ca.getSelectedItem().toString();
                System.out.println(s);
                try {
                    ArrayList<String> strings2 = new ServiceUser().ServiceSelectCoomroom(s);
                    for (String s1:strings2){
                        jiao.addItem(s1);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if (ca.getSelectedItem()!=null){
//                        try {
//                            ArrayList<String> strings2 = new ServiceUser().ServiceSelectCoomroom(ca.getSelectedItem().toString());
//                        for (String s:strings2){
//                            jiao.addItem(s);
//                        }
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }
//            }
//        }).start();



        JButton sumbit = new JButton("提交申请");
        sumbit.setFont(new Font("",Font.BOLD,22));
        sumbit.setBounds(100,500,130,30);
        jp.add(sumbit);
// 设置监听提交事件
        sumbit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flownumber = ca.getSelectedItem().toString();
                String jiaoshi = jiao.getSelectedItem().toString();
                System.out.println(flownumber+jiaoshi);
                try {
                String cid = new ServiceRequest().ServiceClassrooid(flownumber, jiaoshi);
                    System.out.println(cid);
                String thingText = jTextArea.getText();
                String date = jTextField.getText();
                String start = statext.getText();
                String text = endtext.getText();
                    String daterage="^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
                    String time="([0-1]?[0-9]|2[0-3]):([0-5][0-9])$";
                    boolean datepandaun = Pattern.matches(daterage, date);
                    boolean startpandaun = Pattern.matches(time, start);
                    boolean endpandaun = Pattern.matches(time, text);
                    if (datepandaun && startpandaun && endpandaun){
                        Request request = new Request();
                        long l = System.currentTimeMillis();
                        String s = String.valueOf(l);


                        System.out.println(s);
                        request.setId(s);
                        request.setStatus(1);
                        request.setThing(thingText);

                        request.setDatetime(date);
                        request.setStartrequest(start);
                        request.setEndrequest(text);
                        request.setSid(id);
                        request.setCid(cid);

                        Integer chengong = new ServiceRequest().ServiceInsertRequest(request);
                        if (chengong!=0){
                            JOptionPane.showMessageDialog(null,"上传成功","消息",JOptionPane.OK_OPTION);
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"上传失败，请重新上传","消息",JOptionPane.OK_OPTION);
                        }
                        System.out.println(chengong);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"请输入正确的日期与时间格式","消息",JOptionPane.OK_OPTION);
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });

//
        return jp;
    }
//    增加设备界面
    private JPanel addEquipment() throws IOException {
        JPanel jp = new JPanel();

//        标题
        jp.setLayout(null);
        JLabel jLabel = new JLabel("教室信息管理系统---学生端");
        jLabel.setBounds(160,30,400,40);
        jLabel.setFont(new Font("",Font.BOLD,30));
        jp.add(jLabel);

        JLabel classroom = new JLabel("楼号");
        classroom.setBounds(100,100,100,40);
        classroom.setFont(new Font("",Font.BOLD,20));
        jp.add(classroom);

//        JTextField ca= new JTextField();
//        ca.setFont(new Font("",Font.BOLD,20));
//        ca.setBounds(230,100,200,40);
//        jp.add(ca);

        ArrayList<String> strings = new ServiceUser().ServiceSelectCroom();
        String[] strings1 = strings.toArray(new String[strings.size()]);
        JComboBox<String> ca = new JComboBox<>(strings1);
        ca.setFont(new Font("",Font.BOLD,20));
        ca.setBounds(230,100,200,40);
        ca.setSelectedIndex(-1);
        jp.add(ca);

        JLabel jiaoshi = new JLabel("教室编号");
        jiaoshi.setBounds(100,170,100,40);
        jiaoshi.setFont(new Font("",Font.BOLD,20));

        jp.add(jiaoshi);

//        JTextField jiao= new JTextField();
//        jiao.setFont(new Font("",Font.BOLD,20));
//        jiao.setBounds(230,170,200,40);
//        jp.add(jiao);

        JComboBox<String> jiao = new JComboBox<>();
        jiao.setFont(new Font("",Font.BOLD,20));
        jiao.setBounds(230,170,200,40);
        jiao.setSelectedIndex(-1);
        jp.add(jiao);

        ca.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String s = ca.getSelectedItem().toString();
                System.out.println(s);
                try {
                    ArrayList<String> strings2 = new ServiceUser().ServiceSelectCoomroom(s);
                    for (String s1:strings2){
                        jiao.addItem(s1);
                    }
//                    jiao.setSelectedIndex(-1);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        JLabel ename = new JLabel("设备名称");
        ename.setBounds(100,240,100,40);
        ename.setFont(new Font("",Font.BOLD,20));

        jp.add(ename);

       JComboBox shebei = new JComboBox<>();
        shebei.setFont(new Font("",Font.BOLD,20));
        shebei.setBounds(230,240,200,40);
        jp.add(shebei);

        jiao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                shebei.removeAllItems();
                String flow = ca.getSelectedItem().toString();
                String jiao1 = jiao.getSelectedItem().toString();
                ArrayList<Equipment> equipment = null;
                try {
                    equipment = new ServiceRequest().ServiceEqument(flow, jiao1);
                    ArrayList<String> strings = new ArrayList<>();
                    for (Equipment equipment1:equipment){
                        strings.add(equipment1.getName());
                    }
                    if (strings.size()>0){
                        for (String s:strings){
                            shebei.addItem(s);
                        }
                    }
                    else {
                        shebei.addItem("");
                    }


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
//                    添加描述
        JLabel description = new JLabel("损坏描述");
        description.setBounds(100,310,100,40);
        description.setFont(new Font("",Font.BOLD,20));
        jp.add(description);
//                    添加输入框
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font("",Font.PLAIN,20) );
        jTextArea.setBounds(230,300,300,70);
        jp.add(jTextArea);
        System.out.println(jTextArea);

//        JButton fond = new JButton("查找设备");
//        fond.setFont(new Font("",Font.BOLD,22));
//        fond.setBounds(460,170,130,40);
//        jp.add(fond);


        JButton sumbitequemnt =new JButton("提交");
        sumbitequemnt.setFont(new Font("",Font.BOLD,22));
        sumbitequemnt.setBounds(100,400,130,30);
        jp.add(sumbitequemnt);
        sumbitequemnt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enameText = shebei.getSelectedItem().toString();;//设备名称
                String decription = jTextArea.getText();//设备描述
                String flwo = ca.getSelectedItem().toString();
                String jiaoshibianhao = jiao.getSelectedItem().toString();
                Integer status=1;
                try {
                    System.out.println(flwo);
                    System.out.println(jiaoshibianhao);
                    System.out.println(enameText);
                    System.out.println(decription);
                    Integer integer = new ServiceRequest().ServiceUpdateEqument(enameText, status, decription, flwo, jiaoshibianhao);
                    System.out.println(integer);
                    if (integer!=0){
                        JOptionPane.showMessageDialog(null,"提交成功","消息",JOptionPane.OK_OPTION);
                    }else {
                        JOptionPane.showMessageDialog(null,"提交失败","消息",JOptionPane.OK_OPTION);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

//        fond.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //设备名称
//                JLabel ename = new JLabel("设备名称");
//                ename.setBounds(100,240,100,40);
//                ename.setFont(new Font("",Font.BOLD,20));
//                jp.add(ename);
//                String flow = ca.getSelectedItem().toString();
//                String jiao1 = jiao.getSelectedItem().toString();
//                JComboBox<Object> shebei;
////              查找设备名称
//                try {
//                    ArrayList<Equipment> equipment = new ServiceRequest().ServiceEqument(flow, jiao1);
//                    ArrayList<String> strings = new ArrayList<>();
//                    for (Equipment equipment1:equipment){
//                        strings.add(equipment1.getName());
//                    }
//                    String[] strings1 = strings.toArray(new String[strings.size()]);
//
//
//                    shebei = new JComboBox<>(strings1);
//                    shebei.setFont(new Font("",Font.BOLD,20));
//                    shebei.setBounds(230,240,200,40);
//                    jp.add(shebei);
////                    添加描述
//                    JLabel description = new JLabel("损坏描述");
//                    description.setBounds(100,310,100,40);
//                    description.setFont(new Font("",Font.BOLD,20));
//                    jp.add(description);
////                    添加输入框
//                    JTextArea jTextArea = new JTextArea();
//                    jTextArea.setFont(new Font("",Font.PLAIN,20) );
//                    jTextArea.setBounds(230,300,300,70);
//                    jp.add(jTextArea);
//                    System.out.println(jTextArea);
//
////                    显示提交按钮
//
////                    sumbitequemnt =;
//                    sumbitequemnt.setFont(new Font("",Font.BOLD,22));
//                    sumbitequemnt.setBounds(100,400,130,30);
//                    jp.add(sumbitequemnt);
////
//sumbitequemnt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String enameText = shebei.getSelectedItem().toString();;//设备名称
//                String decription = jTextArea.getText();//设备描述
//                String flwo = ca.getSelectedItem().toString();
//                String jiaoshibianhao = jiao.getSelectedItem().toString();
//                Integer status=1;
//                try {
//                    System.out.println(flwo);
//                    System.out.println(jiaoshibianhao);
//                    System.out.println(enameText);
//                    System.out.println(decription);
//                    Integer integer = new ServiceRequest().ServiceUpdateEqument(enameText, status, decription, flwo, jiaoshibianhao);
//                    System.out.println(integer);
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }
//        });
//
//                } catch (Exception ioException) {
//                    ioException.printStackTrace();
//                }
//
////
//
////
//
////                显示设备
//                setContentPane(jp);
//                setVisible(true);
//            }
//        });




//        JComboBox<String> etishi = new JComboBox<>();
//        ArrayList<Equipment> equipment = new ServiceRequest().ServiceEqument();



//


        return jp;
    }

    //增加选择按钮
    private void addSelect(){
//日期提示语
        JLabel date = new JLabel("日期");
        date.setBounds(40,100,50,40);
        date.setFont(new Font("",Font.BOLD,20));
        jPanel.add(date);
        //        定义输入框
        JTextField jTextField = new JTextField();
        jTextField.setBounds(90,110,120,30);
        jTextField.setFont(new Font(null,Font.BOLD,20));
        jPanel.add(jTextField);
//开始时间提示语
        JLabel starttime = new JLabel("开始时间");
        starttime.setBounds(210,100,120,40);
        starttime.setFont(new Font("",Font.BOLD,20));
        jPanel.add(starttime);
//        输入开始时间
        JTextField start = new JTextField();
        start.setBounds(300,110,120,30);
        start.setFont(new Font(null,Font.BOLD,20));
        jPanel.add(start);
//结束时间提示语
        JLabel end = new JLabel("结束时间");
        end.setBounds(430,100,120,40);
        end.setFont(new Font("",Font.BOLD,20));
        jPanel.add(end);
//
        JTextField enddd = new JTextField();
        enddd.setBounds(520,110,120,30);
        enddd.setFont(new Font(null,Font.BOLD,20));
        jPanel.add(enddd);
        JButton quern = new JButton("确认");
        quern.setBounds(530,160,100,25);
        quern.setFont(new Font(null,Font.BOLD,20));
        jPanel.add(quern);

        JLabel tishiyu = new JLabel("年月日：xxxx-xx-xx；时间:xx:xx");
        tishiyu.setFont(new Font(null,Font.PLAIN,25));
        tishiyu.setBounds(180,300,500,30);
        jPanel.add(tishiyu);
        quern.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String date = jTextField.getText();
        String starttime = start.getText();
        String endtime = enddd.getText();
        System.out.println(date+starttime+endtime);


        String daterage="^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
        String time="([0-1]?[0-9]|2[0-3]):([0-5][0-9])$";
        boolean matches = Pattern.matches(daterage, date);
        boolean matches1 = Pattern.matches(time, starttime);
        boolean matches2 = Pattern.matches(time, endtime);
        System.out.println(""+matches+matches1+matches2);
        try {
            if (matches && matches1 && matches2){
                addtable(date,starttime,endtime);
            }
            else {
                JOptionPane.showMessageDialog(null,"请确认您的日期/时间格式正确","消息",JOptionPane.OK_OPTION);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
});
//        quern.set
//        显示
//        setContentPane(jPanel);



    }

//    增加表格
    private void addtable(String date,String starttime,String endtime) throws IOException {
        remove(jPanel);
        JScrollPane jScrollPane=new JScrollPane();
        HashSet<Croom> timeclassroom = getTimeclassroom(date, starttime, endtime);
        String columnNames[]={"楼号","教室编号","最大容纳人数"};
         DefaultTableModel dm = // 重写表格
                new DefaultTableModel(columnNames,0); // 列名
        JTable jTable = new JTable(dm);
        jTable.setFont(new Font(null,Font.PLAIN,18));
        jTable.setRowHeight(25);
        JTableHeader tab_header =jTable.getTableHeader();					//获取表头
        tab_header.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        tab_header.setPreferredSize(new Dimension(tab_header.getWidth(), 30));
        for(Croom c:timeclassroom){
            Vector<Object> v= new Vector<>();
            v.add(c.getFoolnumber());
            v.add(c.getRoomnumber());
            v.add(c.getMaxperson());

        dm.addRow(v);
        }
        jScrollPane.setViewportView(jTable);

//         add(jScrollPane);
        setContentPane(jScrollPane);
//        jPanel.add(jScrollPane);
        setVisible(true);
//        setContentPane(jPanel);
    }
//得到数据
    private HashSet<Croom> getTimeclassroom(String date,String starttime,String endtime) throws IOException {
        HashSet<Croom> crooms = new ServiceUser().ServiceSelectspareclassroom(date, starttime, endtime);
        return crooms;
    }
    public static void main(String[] args) throws IOException {
//        Studentlogin studentlogin = new Studentlogin("1");

    }
}
