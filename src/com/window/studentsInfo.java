package com.window;

import util.Myutil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class studentsInfo extends JFrame {

    private JPanel contentPane;
    public static JTextField textField;
    public static JPasswordField passwordField;




    /**
     * Launch the application.
     */
    static studentsInfo frame=new studentsInfo();
    public static  void main(String arg[]){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }


    /**
     * Create the frame.
     */
    public studentsInfo() {
        setTitle("ѧ���ɼ�����ϵͳ");
        setBackground(Color.WHITE);
        setForeground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 350, 517, 392);
        this.setResizable(false);
        contentPane = new JPanel();

        contentPane.setBackground(Color.WHITE);
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("�˺�");
        label.setForeground(Color.BLACK);
        label.setBackground(Color.WHITE);
        label.setFont(new Font("????", Font.BOLD, 20));
        label.setBounds(64, 120, 113, 22);
        contentPane.add(label);

        JLabel label_1 = new JLabel("����");
        label_1.setFont(new Font("????", Font.BOLD, 20));
        label_1.setBounds(64, 167, 89, 31);
        contentPane.add(label_1);

        textField = new JTextField();
        textField.setFont(new Font("????", Font.PLAIN, 20));
        textField.setBounds(138, 118, 253, 30);
        contentPane.add(textField);
        textField.setColumns(16);

        JButton Button1 = new JButton("ѧ����¼");
        Button1.setFont(new Font("????", Font.PLAIN, 16));
        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        Button1.setBounds(45, 244, 119, 27);
        contentPane.add(Button1);

        JButton Button2 = new JButton("��ʦ��¼");
        Button2.setFont(new Font("????", Font.PLAIN, 16));
        Button2.setBounds(189, 244, 113, 27);
        contentPane.add(Button2);

        JButton Button3 = new JButton("����Ա��¼");
        Button3.setFont(new Font("????", Font.PLAIN, 16));
        Button3.setBounds(326, 244, 128, 27);
        contentPane.add(Button3);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordField.setColumns(20);
        passwordField.setBounds(138, 171, 253, 27);
        contentPane.add(passwordField);

        JLabel image = new JLabel("");
        image.setBackground(Color.LIGHT_GRAY);
        image.setIcon(new ImageIcon("src\\img\\book.jpg"));
        image.setBounds(200, 93, 505, 334);
        contentPane.add(image);

        JLabel label_2 = new JLabel("ѧ���ɼ�����ϵͳ");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setFont(new Font("????", Font.BOLD, 30));
        label_2.setBounds(33, 13, 398, 78);
        contentPane.add(label_2);

//ѧ����¼
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql="select * from S where SNO='"+textField.getText()+"'";
                ResultSet rs= Myutil.getRs(sql);
                try{
                    if(rs.next()){
                        if(rs.getString("PW").equals(passwordField.getText())){
                            JOptionPane.showMessageDialog(null,"��¼�ɹ���");
                            frame.setVisible(false);
                            frame.dispose();
                            new StudentsMainFrm().setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"�������");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"�û��������ڣ�");
                        textField.setText("");
                        passwordField.setText("");
                    }
                }catch(SQLException e1){
                    e1.printStackTrace();

                }
            }
        });

        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql="select * from A where ANO='"+textField.getText()+"'";
                ResultSet rs= Myutil.getRs(sql);
                try{
                    if(rs.next()){
                        if(rs.getString("APW").equals(passwordField.getText())){
                            JOptionPane.showMessageDialog(null,"��¼�ɹ���");
                            frame.setVisible(false);
                            frame.dispose();
                            new AdminMainFrm().setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"�������");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"�û��������ڣ�");
                        textField.setText("");
                        passwordField.setText("");
                    }
                }catch(SQLException e1){
                    e1.printStackTrace();

                }
            }
        });

        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql="select * from T where TNO='"+textField.getText()+"'";
                ResultSet rs= Myutil.getRs(sql);
                try{
                    if(rs.next()){
                        if(rs.getString("PW").equals(passwordField.getText())){
                            JOptionPane.showMessageDialog(null,"��¼�ɹ���");
                            frame.setVisible(false);
                            frame.dispose();
                            new TeacherMainFrm().setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"�������");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"�û��������ڣ�");
                        textField.setText("");
                        passwordField.setText("");
                    }
                }catch(SQLException e1){
                    e1.printStackTrace();

                }
            }
        });
    }


}
