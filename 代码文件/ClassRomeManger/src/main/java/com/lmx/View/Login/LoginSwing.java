package com.lmx.View.Login;

import com.lmx.Pojo.Student;
import com.lmx.Service.ServiceManger;
import com.lmx.Until.LoginUntil;
    import com.lmx.View.Person.ManangerLogin;
    import com.lmx.View.Person.Studentlogin;
    import com.lmx.View.Person.Teacherlogin;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.IOException;
    import java.text.SimpleDateFormat;
    import java.util.Date;

public class LoginSwing extends JFrame {
    private JPanel jPanel;
    public LoginSwing() throws HeadlessException {
//        初始化窗体程序
        this.init();
    }

    protected void init() {
//        设置大小与位置
    this.setTitle("教室信息管理系统");
    this.setSize(700,700);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    this.setResizable(false);

    this.setlogin();
        this.setVisible(true);
    }

    private void setlogin() {
        //    设置用户角色
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        JLabel jLabel = new JLabel("欢迎来到教室信息管理系统");
        jLabel.setBounds(160,30,400,40);
        jLabel.setFont(new Font("",Font.BOLD,30));
        jPanel.add(jLabel);
//        用户角色
        JLabel userLabel = new JLabel("角色:");
        userLabel.setBounds(150,200,80,25);
        userLabel.setFont(new Font("",Font.BOLD,25));
        jPanel.add(userLabel);
//定义下拉菜单
        JComboBox<String> box = new JComboBox<>();
        box.addItem("管理员");
        box.addItem("教师");
        box.addItem("学生");
        box.setBounds(230,200,300,30);
        box.setFont(new Font("",Font.BOLD,23));
        jPanel.add(box);
//        用户角色
        JLabel username = new JLabel("姓名:");
        username.setBounds(150,240,80,25);
        username.setFont(new Font("",Font.BOLD,25));
        jPanel.add(username);
//        定义输入框
        JTextField jTextField = new JTextField();
        jTextField.setBounds(230,240,300,30);
        jTextField.setFont(new Font(null,Font.BOLD,25));
        jPanel.add(jTextField);
        //        用户角色
        JLabel passname = new JLabel("密码:");
        passname.setBounds(150,280,80,25);
        passname.setFont(new Font("",Font.BOLD,25));
        jPanel.add(passname);
//        定义密码框
        JPasswordField password = new JPasswordField();
        password.setBounds(230,280,300,30);
        password.setFont(new Font(null,Font.BOLD,25));
        jPanel.add(password);
//        定义确认按钮
        JButton queren = new JButton("确定");
        queren.setBounds(150,400,100,30);
        queren.setFont(new Font(null,Font.BOLD,25));
        jPanel.add(queren);
//        定义取消按钮
        JButton quxiao=new JButton("取消");
        quxiao.setBounds(450,400,100,30);
        quxiao.setFont(new Font(null,Font.BOLD,25));
//        确认键的监听事件
        queren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mananger = box.getSelectedItem().toString();//管理员
                String username = jTextField.getText();
                String ps=new String(password.getPassword());
                System.out.println(mananger);
                System.out.println(username);
                System.out.println(ps);
                try {
                    String success = LoginUntil.success(mananger, username, ps);
                    if (success!=null){
                        System.out.println("成功");
                        quren(success,mananger);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"用户名或密码错误","消息",JOptionPane.OK_OPTION);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
//        取消键的监听事件
        quxiao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destiry();

            }
        });
        jPanel.add(quxiao);
//        添加面板到框架
this.setContentPane(jPanel);

    }
//销毁

    private void destiry(){
    System.exit(0);
}
// 确认键
    private void quren(String id,String manager){
//
    if (manager.equals("学生")){
        dispose();
        Studentlogin studentlogin = new Studentlogin(id);
    }
    else if (manager.equals("教师")){
        dispose();
        Teacherlogin teacherlogin = new Teacherlogin(id);
    }
    else {
        //管理员的界面
        dispose();
        ManangerLogin manangerLogin = new ManangerLogin(id);
    }

}
    public static void main(String[] args) throws IOException {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        String format = df.format(day);
        String format1 = time.format(day);



        System.out.println(format);
        System.out.println(format1);
        int integer = new ServiceManger().ServiceDelectRequestmoretime(format,format1);
        System.out.println(integer);
        LoginSwing loginSwing = new LoginSwing();
    }
}


