package com.lmx.View.Request;

import com.lmx.Service.ServiceManger;

import javax.swing.*;
import java.awt.*;

public class StudentRequest extends JFrame {
    private JPanel jPanel=new JPanel();
    public StudentRequest() throws HeadlessException {
//        初始化窗体程序
        this.init();
    }
    private void init(){
        this.setTitle("教室信息管理系统");
        this.setSize(700,700);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.setjpanel();
        this.setVisible(true);
    }
    private void setjpanel(){
        jPanel.setLayout(null);
        JLabel jLabel = new JLabel("教室信息管理系统---学生端");
        jLabel.setBounds(160,30,400,40);
        jLabel.setFont(new Font("",Font.BOLD,30));
        jPanel.add(jLabel);


    }

//    public static void main(String[] args) {
////        new ServiceManger().ServiceUpdateTracherRqquestStudent(13)
//    }
}
