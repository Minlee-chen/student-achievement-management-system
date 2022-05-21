package com.window;

import dao.ChooseContentDo;
import dao.QueryScoreDo;
import model.*;
import model.Selection;
import dao.ChooseRecordDo;
import util.Myutil;
import com.window.studentsInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import java.sql.ResultSet;
import java.util.List;

import static java.lang.System.exit;



public class StudentsMainFrm extends JFrame {

    private JPanel contentPane;
    private JPanel contentPane1;
    private JTable table;
    private  String head[]=null;
    private Object [][]data=null;
    JScrollPane jScrollPane;
    private ChooseContentDo con=new ChooseContentDo();


    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton btnNewButton1;
    JButton btnNewButton2;
    JButton btnNewButton3;
    JButton buttonsubmit;

    JPasswordField newpasswordField;
    JPasswordField againpasswordField;
    JPasswordField oldpasswordField;


    JScrollPane jScrollPane1;
    private JTable table1;
    private Object [][]data1=null;
    private String head1[]=null;
    private ChooseRecordDo sel=new ChooseRecordDo();

    JScrollPane jScrollPane2;
    private JTable table2;
    private Object [][]data2=null;
    private String head2[]=null;
    private QueryScoreDo que=new QueryScoreDo();

    private JTextField SNField;
    private JTextField SNOField;
    private JTextField SexField;
    private JTextField GradeField;
    private JTextField ProField;
    private int row;
    private String t1;




    // JLabel lblNewLabel_2 = new JLabel("");

    /**
     * Launch the application.
     */
    static StudentsMainFrm frame = new StudentsMainFrm();
    public void run() {
        try {

            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    JPanel Mainpanel = new JPanel();

    /**
     * Create the frame.
     */


    public StudentsMainFrm() {
        setTitle("学生成绩管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 150, 1305, 762);
        this.setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 82, 239, 645);
        desktopPane.setBackground(new Color(128, 128, 128));

        JPanel Mainpanel = new JPanel();
        Mainpanel.setBounds(253, 90, 1046, 637);//背景

        JLabel lblNewLabel = new JLabel("选课模块");
        lblNewLabel.setBackground(new Color(105, 105, 105));
        lblNewLabel.setIcon(new ImageIcon("src\\img\\\u9009\u8BFE.png"));
        lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(0, 156, 225, 81);
        desktopPane.add(lblNewLabel);

        button1 = new JButton("选课内容");
        button1.setBounds(40, 249, 185, 54);
        desktopPane.add(button1);
        button1.setForeground(new Color(255, 255, 255));
        button1.setBackground(new Color(169, 169, 169));
        button1.setIcon(new ImageIcon("src\\img\\\u9009\u62E9.png"));
        button1.setFont(new Font("楷体", Font.PLAIN, 25));

        button2 = new JButton("选课记录");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button2.setBounds(40, 341, 185, 49);
        desktopPane.add(button2);
        button2.setForeground(new Color(255, 255, 255));
        button2.setBackground(new Color(169, 169, 169));
        button2.setIcon(new ImageIcon("src\\img\\\u8BB0\u5F55.png"));
        button2.setFont(new Font("楷体", Font.PLAIN, 25));

        JLabel lblNewLabel_1 = new JLabel("成绩查询");
        lblNewLabel_1.setBackground(new Color(105, 105, 105));
        lblNewLabel_1.setIcon(new ImageIcon("src\\img\\\u6210\u7EE9\u5355.png"));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(0, 403, 225, 81);
        desktopPane.add(lblNewLabel_1);

        button3 = new JButton("查询成绩");
        button3.setIcon(new ImageIcon("src\\img\\\u67E5\u8BE2.png"));
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button3.setForeground(Color.WHITE);
        button3.setFont(new Font("楷体", Font.PLAIN, 25));
        button3.setBackground(new Color(169, 169, 169));
        button3.setBounds(40, 497, 185, 49);
        desktopPane.add(button3);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.setLayout(null);
        contentPane.add(desktopPane);

        JLabel lblNewLabel_2 = new JLabel("个人信息");
        lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 30));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setIcon(new ImageIcon("src\\img\\\u5B66\u751F.png"));
        lblNewLabel_2.setBounds(0, 28, 164, 49);
        desktopPane.add(lblNewLabel_2);

        button4 = new JButton("修改密码");
        button4.setIcon(new ImageIcon("src\\img\\\u4FEE\u6539\u4FE1\u606F.png"));
        button4.setFont(new Font("楷体", Font.PLAIN, 25));
        button4.setBackground(new Color(169, 169, 169));
        button4.setForeground(new Color(255, 255, 255));
        button4.setBounds(40, 100, 185, 54);
        desktopPane.add(button4);
        GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
        gl_desktopPane.setHorizontalGroup(
                gl_desktopPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblNewLabel_2)
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addGap(40)
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addGap(40)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addGap(40)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addGap(40)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
        );
        gl_desktopPane.setVerticalGroup(
                gl_desktopPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_desktopPane.createSequentialGroup()
                                .addGap(28)
                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(23)
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(2)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(38)
                                .addComponent(button2)
                                .addGap(13)
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addGap(13)
                                .addComponent(button3))
        );
        desktopPane.setLayout(gl_desktopPane);
        contentPane.add(Mainpanel);

        //修改密码面板


        JPanel desktopPane1 = new JPanel();
        desktopPane1.setBackground(new Color(255, 255, 255));

        JLabel label1 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
        label1.setBackground(new Color(169, 169, 169));
        label1.setFont(new Font("楷体", Font.PLAIN, 25));

        JLabel label2 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
        label2.setFont(new Font("楷体", Font.PLAIN, 25));
        label2.setBackground(new Color(240, 240, 240));

        JLabel label3 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
        label3.setFont(new Font("楷体", Font.PLAIN, 25));

        JLabel label4 = new JLabel("\u786E\u5B9A\u5BC6\u7801\uFF1A");
        label4.setFont(new Font("楷体", Font.PLAIN, 25));

        oldpasswordField = new JPasswordField();
        oldpasswordField.setFont(new Font("仿宋", Font.PLAIN, 20));

        newpasswordField = new JPasswordField();
        newpasswordField.setFont(new Font("仿宋", Font.PLAIN, 20));

        againpasswordField = new JPasswordField();
        againpasswordField.setFont(new Font("仿宋", Font.PLAIN, 20));

        JButton buttonreset = new JButton("\u91CD\u7F6E");
        buttonreset.setFont(new Font("楷体", Font.PLAIN, 25));
        buttonreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newpasswordField.setText("");
                oldpasswordField.setText("");
                againpasswordField.setText("");
            }
        });

        JButton buttonsave = new JButton("\u4FDD\u5B58");
        buttonsave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(newpasswordField.getText().isEmpty()||againpasswordField.getText().isEmpty()||!(newpasswordField.getText().equals(againpasswordField.getText()))){
                    JOptionPane.showMessageDialog(null,"新密码与确认密码内容不匹配！");
                    oldpasswordField.setText("");
                    newpasswordField.setText("");
                    againpasswordField.setText("");
                }else{
                    String sql="update S set PW='"+newpasswordField.getText()+"'where SNO ='"+studentsInfo.textField.getText()+"'and PW='"+oldpasswordField.getText()+"'";
                    int rs= Myutil.get(sql);
                    try{
                        if(rs==1){
                            if(oldpasswordField.getText().equals(studentsInfo.passwordField.getText())&&newpasswordField.getText().equals(againpasswordField.getText())&&!(newpasswordField.getText().isEmpty())&&!(againpasswordField.getText().isEmpty())&&!(oldpasswordField.getText().isEmpty())){
                                JOptionPane.showMessageDialog(null,"修改密码成功！");
                                oldpasswordField.setText("");
                                newpasswordField.setText("");
                                againpasswordField.setText("");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null,"出现错误");
                            oldpasswordField.setText("");
                            newpasswordField.setText("");
                            againpasswordField.setText("");
                        }
                    }catch(Exception e1){
                        e1.printStackTrace();

                    }
                }

            }
        });
        buttonsave.setFont(new Font("楷体", Font.PLAIN, 25));
        GroupLayout gl_desktopPane1 = new GroupLayout(desktopPane1);
        gl_desktopPane1.setHorizontalGroup(
                gl_desktopPane1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_desktopPane1.createSequentialGroup()
                                .addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_desktopPane1.createSequentialGroup()
                                                .addGap(637)
                                                .addComponent(buttonreset, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING, false)
                                                .addGroup(gl_desktopPane1.createSequentialGroup()
                                                        .addGap(264)
                                                        .addGroup(gl_desktopPane1.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(buttonsave, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(againpasswordField))
                                                .addGroup(gl_desktopPane1.createSequentialGroup()
                                                        .addGap(282)
                                                        .addGroup(gl_desktopPane1.createParallelGroup(Alignment.TRAILING)
                                                                .addComponent(label2)
                                                                .addComponent(label3))
                                                        .addGap(20)
                                                        .addGroup(gl_desktopPane1.createParallelGroup(Alignment.TRAILING, false)
                                                                .addComponent(oldpasswordField)
                                                                .addComponent(newpasswordField, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))))
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(251, Short.MAX_VALUE))
        );
        gl_desktopPane1.setVerticalGroup(
                gl_desktopPane1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_desktopPane1.createSequentialGroup()
                                .addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(Alignment.TRAILING, gl_desktopPane1.createSequentialGroup()
                                                .addContainerGap(85, Short.MAX_VALUE)
                                                .addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(oldpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                .addGap(55)
                                .addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(66)
                                .addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(againpasswordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(buttonreset, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonsave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(73))
        );
        desktopPane1.setLayout(gl_desktopPane1);

//*********************

        JLabel lblRachAndMai = new JLabel("Rach and Mai 学生成绩管理系统  ");
        lblRachAndMai.setForeground(new Color(169, 169, 169));
        lblRachAndMai.setFont(new Font("华文行楷", Font.PLAIN, 28));

        JLabel label = new JLabel("@ 东莞城市学院");
        label.setFont(new Font("华文行楷", Font.PLAIN, 28));
        label.setForeground(new Color(169, 169, 169));

        JLabel label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon("src\\img\\\u7535\u8111\u573A\u666F.png"));
        GroupLayout gl_Mainpanel = new GroupLayout(Mainpanel);//布局容器（背景）
        gl_Mainpanel.setHorizontalGroup(
                gl_Mainpanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_Mainpanel.createSequentialGroup()
                                .addContainerGap(339, Short.MAX_VALUE)
                                .addComponent(lblRachAndMai)
                                .addGap(328))
                        .addGroup(gl_Mainpanel.createSequentialGroup()
                                .addGap(417)
                                .addComponent(label)
                                .addContainerGap(426, Short.MAX_VALUE))
                        .addGroup(gl_Mainpanel.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 1023, GroupLayout.PREFERRED_SIZE))
        );
        gl_Mainpanel.setVerticalGroup(
                gl_Mainpanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_Mainpanel.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRachAndMai)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        Mainpanel.setLayout(gl_Mainpanel);//背景

        JButton btnNewButton = new JButton("我的");
        btnNewButton.setIcon(new ImageIcon("src\\img\\\u6211\u7684.png"));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("楷体", Font.PLAIN, 23));
        btnNewButton.setBorder(null);
        btnNewButton.setBackground(new Color(135, 206, 250));
        btnNewButton.setBounds(786, 13, 101, 56);
        contentPane.add(btnNewButton);


        btnNewButton1 = new JButton("帮助");
        btnNewButton1.setIcon(new ImageIcon("src\\img\\\u5E2E\u52A9.png"));
        btnNewButton1.setForeground(Color.WHITE);
        btnNewButton1.setFont(new Font("楷体", Font.PLAIN, 23));
        btnNewButton1.setBorder(null);
        btnNewButton1.setBackground(new Color(135, 206, 250));
        btnNewButton1.setBounds(917, 13, 101, 56);
        contentPane.add(btnNewButton1);
        btnNewButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
// 设置文本显示效果
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                JOptionPane.showMessageDialog(null,"本界面是学生界面\n" +
                        "功能1、学生可以修改自己的密码、\n" +
                        "功能2、学生可以选不超过三门的课程、\n" +
                        "功能3、学生学习完课程之后可查询成绩。");

            }
        });

        btnNewButton2 = new JButton("关于");
        btnNewButton2.setIcon(new ImageIcon("src\\img\\\u5173\u4E8E.png"));
        btnNewButton2.setForeground(Color.WHITE);
        btnNewButton2.setFont(new Font("楷体", Font.PLAIN, 23));
        btnNewButton2.setBorder(null);
        btnNewButton2.setBackground(new Color(135, 206, 250));
        btnNewButton2.setBounds(1032, 13, 101, 56);
        contentPane.add(btnNewButton2);
        btnNewButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
// 设置文本显示效果
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                JOptionPane.showMessageDialog(null,"‘Rach and Mai’学生成绩管理系统作者：305陈秋纯、329麦颖琪");

            }
        });

        btnNewButton3 = new JButton("退出");
        btnNewButton3.setIcon(new ImageIcon("src\\img\\\u9000\u51FA.png"));
        btnNewButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO 自动生成的方法存根
                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
// 设置文本显示效果
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                JOptionPane optionPane=new JOptionPane();
                if(JOptionPane.showConfirmDialog(null, "确定退出吗")==JOptionPane.OK_OPTION) {//判断是否退出
                    dispose();
                }
            }
        });
        btnNewButton3.setForeground(Color.WHITE);
        btnNewButton3.setFont(new Font("楷体", Font.PLAIN, 23));
        btnNewButton3.setBorder(null);
        btnNewButton3.setBackground(new Color(135, 206, 250));
        btnNewButton3.setBounds(1154, 13, 101, 56);
        contentPane.add(btnNewButton3);

        JLabel lblRachWithMai = new JLabel("Rach and Mai");
        lblRachWithMai.setBounds(24, 0, 494, 99);
        contentPane.add(lblRachWithMai);
        lblRachWithMai.setForeground(Color.WHITE);
        lblRachWithMai.setFont(new Font("Segoe Script", Font.BOLD, 45));

        JLabel label_1 = new JLabel("学生界面");
        label_1.setForeground(new Color(255, 255, 255));
        label_1.setFont(new Font("华文行楷", Font.PLAIN, 40));
        label_1.setBounds(501, 36, 165, 41);
        contentPane.add(label_1);

        //修改密码
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpanel.removeAll();
                Mainpanel.repaint();
                JPanel  Mainpanel1=new JPanel();
                Mainpanel1.setBounds(0, 0, 1046, 700);
                Mainpanel1.setBackground(new Color(255, 255, 255));
                Mainpanel1.add(desktopPane1);
                Mainpanel.add(Mainpanel1);
                Mainpanel.validate();
            }
        });


        //选课内容表格呈现
        JPanel record = new JPanel();
        record.setBackground(Color.WHITE);
        record.setBounds(0, 0, 1028, 650);

        JScrollPane scrollPane = new JScrollPane();

        JButton buttonsubmit = new JButton("提交");
        buttonsubmit.setFont(new Font("楷体", Font.PLAIN, 28));
        buttonsubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        table = new JTable();

        table.setBackground(Color.WHITE);
        table.setFont(new Font("楷体", Font.PLAIN, 25));
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        table.setModel(new DefaultTableModel(
                queryData1(),
                new String[] {
                        "课程号", "课程名", "授课老师","教师号"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class, String.class, String.class,String.class
            };
            public Class getColumnClass(int columnIndex) {//得到表格中每一列的数据类型
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                    false, false, false,false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        scrollPane.setViewportView(table);



        //选课功能，“提交”按钮
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = table.rowAtPoint(e.getPoint());//选中行
                //System.out.println(table.getValueAt(row,0)+"\t"+table.getValueAt(row,1)+"\t"+table.getValueAt(row,2));
                t1=table.getValueAt(row,0).toString();
            }
        });

        buttonsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int check=2;
                    int i=0;
                    String sql0 = "select CNO from SC where SNO='" + studentsInfo.textField.getText() + "'";
                    ResultSet rs0 = Myutil.getRs(sql0);
                    while(rs0.next()){
                        if(!(rs0.getString("CNO").equals(t1))){
                            i++;
                            check=0;
                        }else{
                            check=1;
                            break;
                        }

                    }


                    if(check==0||check==2){

                        try{
                            if(i>=3){
                                JOptionPane.showMessageDialog(null,"选课数量大于等于3门");

                            }else{
                                String sql1 = "insert into SC values('" + studentsInfo.textField.getText() + "','" + table.getValueAt(row,0).toString() + "'," + null + ")";
                                int rs1 = Myutil.get(sql1);
                                if(rs1==1){
                                    JOptionPane.showMessageDialog(null,"课程号："+table.getValueAt(row,0).toString()+"\n"+"课程名："+table.getValueAt(row,1).toString()+"\n"+"授课教师："+table.getValueAt(row,2).toString());
                                }
                            }

                        }catch (Exception e2){
                            e2.printStackTrace();
                        }
                    }
                    if(check==1){
                        JOptionPane.showMessageDialog(null,"选课重复或选课内容为空！");
                    }

                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });


        //JButton buttonreset1 = new JButton("重置");
        //buttonreset1.setFont(new Font("楷体", Font.PLAIN, 28));
        GroupLayout gl_record = new GroupLayout(record);
        gl_record.setHorizontalGroup(
                gl_record.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_record.createSequentialGroup()
                                .addGroup(gl_record.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_record.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
                                        .addGroup(gl_record.createSequentialGroup()
                                                .addGap(407)
                                                .addComponent(buttonsubmit, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        gl_record.setVerticalGroup(
                gl_record.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_record.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(buttonsubmit, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addGap(17))
        );
        record.setLayout(gl_record);

        /*JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(253, 90, 1046, 600);
        table=new JTable();
        // table.setBorder(new LineBorder(new Color(0,0,0)));
        head=new String[]{"课程号","课程名"};
        DefaultTableModel tableModel=new DefaultTableModel(queryData1(),head){
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        table=new JTable(tableModel);
        // table.setModel(tableModel);
        table.setBackground(new Color(0xF6F7FF));
        table.setFont(new Font("????",Font.PLAIN,18));
        table.setRowHeight(30);//调整行宽
        table.getTableHeader().setReorderingAllowed(false);//表格不可拖动
        table.setPreferredScrollableViewportSize(new Dimension(1046,600));//设置表格大小
        table.setFillsViewportHeight(true);
        jScrollPane=new JScrollPane(table);*/
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpanel.removeAll();
                Mainpanel.repaint();
                JPanel  Mainpanel1=new JPanel();
                Mainpanel1.setBounds(0, 0, 1046, 700);
                Mainpanel1.setBackground(new Color(255, 255, 255));
                Mainpanel1.add(record);
                Mainpanel.add(Mainpanel1);
                Mainpanel.validate();
            }
        });


        //选课记录表格呈现
        JScrollPane scrollPane1=new JScrollPane();
        scrollPane1.setBounds(253, 90, 1046, 600);
        table1=new JTable();
        // table.setBorder(new LineBorder(new Color(0,0,0)));
        head1=new String[]{"学号","课程号","课程名"};
        DefaultTableModel tableModel1=new DefaultTableModel(queryData2(),head1){
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        table1=new JTable(tableModel1);
        // table.setModel(tableModel);
        table1.setBackground(new Color(255, 255, 255));
        table1.setFont(new Font("????",Font.PLAIN,18));
        table1.setRowHeight(30);//调整行宽
        table1.getTableHeader().setReorderingAllowed(false);//表格不可拖动
        table1.setPreferredScrollableViewportSize(new Dimension(1046,600));//设置表格大小
        table1.setFillsViewportHeight(true);
        jScrollPane1=new JScrollPane(table1);

        //jScrollPane.setViewportView(table);
        //Mainpanel.add(contentPane);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpanel.removeAll();
                Mainpanel.repaint();
                JPanel  Mainpanel1=new JPanel();
                Mainpanel1.setBounds(0, 0, 1046, 600);
                Mainpanel1.setBackground(new Color(0xF6F7FF));
                Mainpanel1.add(jScrollPane1);
                Mainpanel.add(Mainpanel1);
                Mainpanel.validate();
            }
        });

 //查询成绩模块
        //查询成绩表格呈现
        JScrollPane scrollPane2=new JScrollPane();
        scrollPane2.setBounds(253, 90, 1046, 600);
        table2=new JTable();
        // table.setBorder(new LineBorder(new Color(0,0,0)));
        head2=new String[]{"姓名","学号","课程号","课程名","成绩"};
        DefaultTableModel tableMode2=new DefaultTableModel(queryData3(),head2){ //引用下面queryData3()的方法。
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        table2=new JTable(tableMode2);
        // table.setModel(tableModel);
        table2.setBackground(new Color(255, 255, 255));
        table2.setFont(new Font("????",Font.PLAIN,18));
        table2.setRowHeight(30);//调整行宽
        table2.getTableHeader().setReorderingAllowed(false);//表格不可拖动
        table2.setPreferredScrollableViewportSize(new Dimension(1046,600));//设置表格大小
        table2.setFillsViewportHeight(true);
        jScrollPane2=new JScrollPane(table2);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpanel.removeAll();
                Mainpanel.repaint();
                JPanel  Mainpanel1=new JPanel();
                Mainpanel1.setBounds(0, 0, 1046, 600);
                Mainpanel1.setBackground(new Color(0xF6F7FF));
                Mainpanel1.add(jScrollPane2);
                Mainpanel.add(Mainpanel1);
                Mainpanel.validate();
            }
        });

// “我的”按钮 界面呈现
        JPanel MyselfPane = new JPanel();
        MyselfPane.setBackground(Color.WHITE);


        JLabel Mylabel = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
        Mylabel.setFont(new Font("楷体", Font.PLAIN, 26));

        JLabel SNlabel = new JLabel("\u59D3\u540D\uFF1A");
        SNlabel.setFont(new Font("楷体", Font.PLAIN, 25));

        SNField = new JTextField();
        SNField.setFont(new Font("楷体", Font.PLAIN, 25));
        SNField.setColumns(10);

        JLabel SNOlabel = new JLabel("\u5B66\u53F7\uFF1A");
        SNOlabel.setFont(new Font("楷体", Font.PLAIN, 25));

        SNOField = new JTextField();
        SNOField.setFont(new Font("楷体", Font.PLAIN, 25));
        SNOField.setColumns(10);

        JLabel Sexlabel = new JLabel("\u6027\u522B\uFF1A");
        Sexlabel.setFont(new Font("楷体", Font.PLAIN, 25));

        SexField = new JTextField();
        SexField.setFont(new Font("楷体", Font.PLAIN, 25));
        SexField.setColumns(10);

        JLabel Gradelabel = new JLabel("\u5E74\u7EA7\uFF1A");
        Gradelabel.setFont(new Font("楷体", Font.PLAIN, 25));

        GradeField = new JTextField();
        GradeField.setFont(new Font("楷体", Font.PLAIN, 25));
        GradeField.setColumns(10);

        JLabel Prolabel = new JLabel("\u4E13\u4E1A\uFF1A");
        Prolabel.setFont(new Font("楷体", Font.PLAIN, 25));

        ProField = new JTextField();
        ProField.setFont(new Font("楷体", Font.PLAIN, 25));
        ProField.setColumns(10);

        JLabel imgoneLabel = new JLabel("");
        imgoneLabel.setIcon(new ImageIcon("src\\img\\\u8D44\u6E90 15.png"));

        JLabel imgtwolabel = new JLabel("");
        imgtwolabel.setIcon(new ImageIcon("src\\img\\\u56E2\u961F.png"));
        GroupLayout gl_MyselfPane = new GroupLayout(MyselfPane);
        gl_MyselfPane.setHorizontalGroup(
                gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                .addGap(14)
                                .addGroup(gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(Mylabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(59)
                                                .addGroup(gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                                .addGap(90)
                                                                .addComponent(SNField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(SNlabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
                                .addGap(75)
                                .addComponent(SNOlabel)
                                .addGap(25)
                                .addComponent(SNOField, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addGap(73)
                                .addComponent(imgoneLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                .addGap(73)
                                .addComponent(Sexlabel)
                                .addGap(15)
                                .addComponent(SexField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                .addGap(43)
                                .addComponent(Gradelabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(14)
                                .addComponent(GradeField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addGap(44)
                                .addComponent(Prolabel)
                                .addGap(46)
                                .addComponent(ProField, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                .addGap(173)
                                .addComponent(imgtwolabel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE))
        );
        gl_MyselfPane.setVerticalGroup(
                gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                .addGap(13)
                                .addGroup(gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(8)
                                                .addComponent(Mylabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addGap(78)
                                                .addGroup(gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(SNField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SNlabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(133)
                                                .addComponent(SNOlabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(135)
                                                .addComponent(SNOField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(imgoneLabel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
                                .addGap(20)
                                .addGroup(gl_MyselfPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(9)
                                                .addComponent(Sexlabel))
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(SexField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(2)
                                                .addComponent(Gradelabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(GradeField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(9)
                                                .addComponent(Prolabel))
                                        .addGroup(gl_MyselfPane.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(ProField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                                .addGap(8)
                                .addComponent(imgtwolabel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
        );
        MyselfPane.setLayout(gl_MyselfPane);

//实现“我的”功能
        String sql="select * from S where SNO='"+studentsInfo.textField.getText()+"'";
        ResultSet rs= Myutil.getRs(sql);
        try{
            if(rs.next()){
                SNField.setText(rs.getString("SN"));
                SNOField.setText(rs.getString("SNO"));
                SexField.setText(rs.getString("Sex"));
                GradeField.setText(rs.getString("Grade"));
                ProField.setText(rs.getString("Pro"));
                SNField.setEditable(false);
                SNOField.setEditable(false);
                SexField.setEditable(false);
                GradeField.setEditable(false);
                ProField.setEditable(false);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //按钮触发
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mainpanel.removeAll();
                Mainpanel.repaint();
                JPanel  Mainpanel1=new JPanel();
                Mainpanel1.setBounds(0, 0, 1046, 700);
                Mainpanel1.setBackground(new Color(255, 255, 255));
                Mainpanel1.add(MyselfPane);
                Mainpanel.add(Mainpanel1);
                Mainpanel.validate();
            }
        });



    }//类的结尾

    public Object[][] queryData1(){
        List<Course> list=con.queryChooseContent();
        data=new Object[list.size()][4];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<4;j++){
                data[i][0]=list.get(i).getCNO();
                data[i][1]=list.get(i).getCN();
                data[i][2]=list.get(i).getTN();
                data[i][3]=list.get(i).getTNO();
            }
        }
        return data;
    }

    public Object[][] queryData2(){
        List<Selection> list=sel.queryChooseRecord();
        data1=new Object[list.size()][head1.length];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<head1.length;j++){
                data1[i][0]=list.get(i).getSNO();
                data1[i][1]=list.get(i).getCNO();
                data1[i][2]=list.get(i).getCN();
            }
        }
        return data1;
    }

    public Object[][] queryData3(){
        List<QueryScore> list=que.queryScore();
        data2=new Object[list.size()][head2.length];
        for(int i=0;i<list.size();i++){
            for(int j=0;j<head2.length;j++){
                data2[i][0]=list.get(i).getSN();
                data2[i][1]=list.get(i).getSNO();
                data2[i][2]=list.get(i).getCNO();
                data2[i][3]=list.get(i).getCN();
                data2[i][4]=list.get(i).getScore();
            }
        }
        return data2;
    }

}












