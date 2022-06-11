package com.lmx.Until;

import com.lmx.Pojo.Equipment;
import com.lmx.Service.ServiceManger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MyEquipmentbutton extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {
    private static final long serialVersionUID = 1L;
    private  DefaultTableModel dm;
    private JButton button =null;
    public static   ArrayList arrayList;
    private int row;

    public MyEquipmentbutton(){
        button = new JButton("按钮");
        button.addActionListener(this);
        button.setFont(new Font(null,Font.PLAIN,20));
    }
    public MyEquipmentbutton(String text, ArrayList arrayList, DefaultTableModel dm){
        this.dm=dm;
//        this.arrayList=arrayList;
        button = new JButton(text);
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
        // TODO Auto-generated method stub
        Equipment equipment = (Equipment) arrayList.get(row);
        String id = equipment.getId();
        try {
            Integer integer = new ServiceManger().ServiceUpdateEquipmentGood(id);
            if (integer!=0){
                Object remove = MyEquipmentbutton.arrayList.remove(row);
                dm.removeRow(row);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        // TODO Auto-generated method stub
        this.row=row;
        return button;
    }

    public static void main(String[] args) {

    }
}
