package com.lmx.Until;

import com.lmx.Pojo.Request;
import com.lmx.Pojo.RequestLog;
import com.lmx.Service.ServiceManger;
import com.lmx.Service.ServiceUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MyRecoverbutton extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {
    private static final long serialVersionUID = 1L;
    private  String id;
    private Integer flag;
    private JButton button =null;
    public  static ArrayList arrayList;
    private int row;
    private Integer colum;
    private DefaultTableModel dm;
    private String text;
    public MyRecoverbutton(){
        button = new JButton("按钮");
        button.addActionListener(this);
        button.setFont(new Font(null,Font.PLAIN,20));
    }
    public MyRecoverbutton(String text){
        button = new JButton(text);
        button.addActionListener(this);
        button.setFont(new Font(null,Font.PLAIN,20));

    }
//    学生的通过与否的按钮
    public MyRecoverbutton(String text, Integer flag, ArrayList arrayList1, DefaultTableModel dm, String id){
        this.id=id;
        this.dm=dm;
//        this.arrayList=arrayList1;
//        Request request = (Request) arrayList1.get(row);
//        Integer status = request.getStatus();

        this.flag=flag;
        button = new JButton(text);
        this.text=text;
        button.addActionListener(this);
        button.setFont(new Font(null,Font.PLAIN,20));
    }


    @Override
    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // TODO Auto-generated method stub
        return button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("点击当前行数是"+row);
        RequestLog request = (RequestLog) arrayList.get(row);
        String id=request.getId();
        Integer status = request.getStatus();
        try {

//            if (status==2 && text.equals("通过")){
//                JOptionPane.showMessageDialog(null,"无效操作，请不要重复点击","消息",JOptionPane.OK_OPTION);
//            }
//            else  if (status==3 && text.equals("驳回")){
//                JOptionPane.showMessageDialog(null,"无效操作，请不要重复点击","消息",JOptionPane.OK_OPTION);
//            }
//            else {
            System.out.println("通过或驳回的id值是"+id);
                Integer integer = new ServiceUser().ServiceInsertRequest(request);
                System.out.println("受影响的行数"+integer);
                System.out.println("通过还是驳回的状态值"+flag);
                if (integer!=0){
                    Object remove = MyRecoverbutton.arrayList.remove(row);
                    Integer integer1 = new ServiceUser().ServiceDelectRequestLog(id);
                    System.out.println("删除的行数是"+integer1);
                    dm.removeRow(row);
                }
//            }


//            if (integer==0){
//                JOptionPane.showMessageDialog(null,"无效操作，请不要重复点击","消息",JOptionPane.OK_OPTION);
//            }


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        // TODO Auto-generated method stub
//        JOptionPane.showMessageDialog(null, "渲染器学期", "消息", JOptionPane.OK_OPTION);

    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        // TODO Auto-generated method stub
        this.row=row;
        this.colum=column;
        return button;
    }
}
