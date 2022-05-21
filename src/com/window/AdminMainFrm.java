package com.window;

import dao.AddStudentsDo;
import dao.AddTeachersDo;
import dao.EntryScoreDo;
import model.Grade;
import model.Selection;
import model.Students;
import model.Teacher;
import util.Myutil;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

public class AdminMainFrm extends JFrame {

	private JPanel contentPane;

	private JPasswordField oldpasswordField;
	private JPasswordField newpasswordField;
	private JPasswordField againpasswordField;
	private JTextField SNOField;
	private DefaultTableModel tableModel=null;
	private DefaultTableModel tableModel1=null;

	private JTable table;

	private int row;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String a5;
	private String a6;

	private String b1;
	private String b2;
	private String b3;
	private String b4;
	private String b5;
	private String b6;

	private JPasswordField newpasswordField1;
	private JPasswordField againpasswordField1;
	private JPasswordField oldpasswordField1;
	private JTextField TNOField;
	private JButton addbutton;

	private Object [][]data=null;
	private AddStudentsDo addStu=new AddStudentsDo();

	private Object [][]data1=null;
	private AddTeachersDo addTea=new AddTeachersDo();

	private JTable Teachertable;



	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			AdminMainFrm frame = new AdminMainFrm();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminMainFrm() {
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
		Mainpanel.setBackground(Color.WHITE);
		Mainpanel.setBounds(253, 90, 1046, 637);

		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel.setBackground(new Color(105, 105, 105));
		lblNewLabel.setIcon(new ImageIcon("src\\img\\\u5B66\u751F.png"));
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 13, 225, 81);
		desktopPane.add(lblNewLabel);

		JButton button1 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button1.setBounds(28, 85, 185, 54);
		desktopPane.add(button1);
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(169, 169, 169));
		button1.setIcon(new ImageIcon("src\\img\\\u4FEE\u6539\u4FE1\u606F.png"));
		button1.setFont(new Font("楷体", Font.PLAIN, 25));

		JButton button2 = new JButton("学生管理");
		button2.setBounds(28, 185, 185, 49);
		desktopPane.add(button2);
		button2.setForeground(new Color(255, 255, 255));
		button2.setBackground(new Color(169, 169, 169));
		button2.setIcon(new ImageIcon("src\\img\\\u6DFB\u52A0.png"));
		button2.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel_1.setBackground(new Color(105, 105, 105));
		lblNewLabel_1.setIcon(new ImageIcon("src\\img\\\u6559\u5E08.png"));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(0, 257, 225, 81);
		desktopPane.add(lblNewLabel_1);

		JButton button3 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button3.setIcon(new ImageIcon("src\\img\\\u4FEE\u6539\u4FE1\u606F.png"));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button3.setForeground(Color.WHITE);
		button3.setFont(new Font("楷体", Font.PLAIN, 25));
		button3.setBackground(new Color(169, 169, 169));
		button3.setBounds(28, 351, 194, 49);
		desktopPane.add(button3);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(desktopPane);

		JButton button = new JButton("教师管理");
		button.setIcon(new ImageIcon("src\\img\\\u6DFB\u52A0.png"));
		button.setFont(new Font("楷体", Font.PLAIN, 25));
		button.setBackground(new Color(169, 169, 169));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(28, 444, 197, 54);
		desktopPane.add(button);
		contentPane.add(Mainpanel);

		JLabel lblRachAndMai = new JLabel("Rach and Mai \u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF  ");
		lblRachAndMai.setForeground(new Color(169, 169, 169));
		lblRachAndMai.setFont(new Font("华文行楷", Font.PLAIN, 28));

		JLabel label = new JLabel("@ \u4E1C\u839E\u57CE\u5E02\u5B66\u9662");
		label.setFont(new Font("华文行楷", Font.PLAIN, 28));
		label.setForeground(new Color(169, 169, 169));

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("src\\img\\城院.jpg"));
		GroupLayout gl_Mainpanel = new GroupLayout(Mainpanel);
		gl_Mainpanel.setHorizontalGroup(
				gl_Mainpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Mainpanel.createSequentialGroup()
								.addGroup(gl_Mainpanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Mainpanel.createSequentialGroup()
												.addGap(368)
												.addComponent(label))
										.addGroup(gl_Mainpanel.createSequentialGroup()
												.addGap(283)
												.addComponent(lblRachAndMai))
										.addGroup(gl_Mainpanel.createSequentialGroup()
												.addGap(59)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 947, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_Mainpanel.setVerticalGroup(
				gl_Mainpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_Mainpanel.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 557, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblRachAndMai)
								.addGap(2)
								.addComponent(label)
								.addGap(928))
		);
		Mainpanel.setLayout(gl_Mainpanel);

		JButton btnNewButton1 = new JButton("帮助");
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
				JOptionPane.showMessageDialog(null,"本界面是管理员界面,\n" +
						"功能1、可以为学生老师修改密码,\n" +
						"功能2、可以添加学生、老师信息。");
			}
		});

		JButton btnNewButton2 = new JButton("关于");
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

		JButton btnNewButton3 = new JButton("退出");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton3.setIcon(new ImageIcon("src\\img\\\u9000\u51FA.png"));
		btnNewButton3.setForeground(Color.WHITE);
		btnNewButton3.setFont(new Font("楷体", Font.PLAIN, 23));
		btnNewButton3.setBorder(null);
		btnNewButton3.setBackground(new Color(135, 206, 250));
		btnNewButton3.setBounds(1154, 13, 101, 56);
		contentPane.add(btnNewButton3);
		btnNewButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
// 设置文本显示效果
				UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
				JOptionPane optionPane=new JOptionPane();
				if(JOptionPane.showConfirmDialog(null, "确定退出吗")==JOptionPane.OK_OPTION) {//判断是否退出
					dispose();

				}
			}
		});

		JLabel lblRachWithMai = new JLabel("Rach and Mai");
		lblRachWithMai.setBounds(24, 0, 494, 99);
		contentPane.add(lblRachWithMai);
		lblRachWithMai.setForeground(Color.WHITE);
		lblRachWithMai.setFont(new Font("Segoe Script", Font.BOLD, 45));

		JLabel lbldo = new JLabel("\u7BA1\u7406\u5458:\u4E1C\u839E\u57CE\u5E02\u5B66\u9662");
		lbldo.setFont(new Font("华文行楷", Font.PLAIN, 40));
		lbldo.setForeground(new Color(255, 255, 255));
		lbldo.setBounds(451, 13, 482, 64);
		contentPane.add(lbldo);



//修改学生密码
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
				SNOField.setText("");
				newpasswordField.setText("");
				oldpasswordField.setText("");
				againpasswordField.setText("");
			}
		});

//修改学生密码，“提交”按钮
		JButton buttonsave = new JButton("\u4FDD\u5B58");
		buttonsave.setFont(new Font("楷体", Font.PLAIN, 25));
		buttonsave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (newpasswordField.getText().isEmpty() || againpasswordField.getText().isEmpty() || !(newpasswordField.getText().equals(againpasswordField.getText()))) {
					JOptionPane.showMessageDialog(null, "新密码与确认密码内容不匹配或内容为空！");
					oldpasswordField.setText("");
					newpasswordField.setText("");
					againpasswordField.setText("");
				} else {
					int c=0;
					String sql1 = "select * from S where SNO='" + SNOField + "'";
					ResultSet r0 = Myutil.getRs(sql1);
					try {
						while (r0.next()) {
							if (r0.getString("PW").equals(oldpasswordField)) {
								c=0;
								break;
							}else{
								c=1;
								break;
							}
						}
						if(c==0){
							String sql = "update S set PW='" + newpasswordField.getText() + "'where SNO ='" + SNOField.getText() + "'and PW='" + oldpasswordField.getText() + "'";
							int rs = Myutil.get(sql);
							if(rs==1){
								if (newpasswordField.getText().equals(againpasswordField.getText()) && !(newpasswordField.getText().isEmpty()) && !(againpasswordField.getText().isEmpty()) && !(oldpasswordField.getText().isEmpty())) {
									JOptionPane.showMessageDialog(null, "修改密码成功！");
									oldpasswordField.setText("");
									newpasswordField.setText("");
									againpasswordField.setText("");
								}else{
									JOptionPane.showMessageDialog(null, "修改密码失败！");
									oldpasswordField.setText("");
									newpasswordField.setText("");
									againpasswordField.setText("");
								}
							}else {
								JOptionPane.showMessageDialog(null,"出现错误！");
								oldpasswordField.setText("");
								newpasswordField.setText("");
								againpasswordField.setText("");
							}
						}else{
							JOptionPane.showMessageDialog(null,"找不到该账号！");
							oldpasswordField.setText("");
							newpasswordField.setText("");
							againpasswordField.setText("");
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		JLabel SNOlabel = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		SNOlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		SNOField = new JTextField();
		SNOField.setColumns(10);
		SNOField.setFont(new Font("楷体",Font.PLAIN,25));
		GroupLayout gl_desktopPane1 = new GroupLayout(desktopPane1);
		gl_desktopPane1.setHorizontalGroup(
				gl_desktopPane1.createParallelGroup(Alignment.LEADING)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 1030, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_desktopPane1.createSequentialGroup()
								.addGap(234)
								.addComponent(buttonsave, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGap(292)
								.addComponent(buttonreset, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane1.createSequentialGroup()
								.addGap(272)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING)
										.addComponent(SNOlabel)
										.addComponent(label2)
										.addComponent(label3)
										.addComponent(label4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
								.addGap(25)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING)
										.addComponent(againpasswordField, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING, false)
												.addComponent(newpasswordField)
												.addComponent(oldpasswordField)
												.addComponent(SNOField, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
		);
		gl_desktopPane1.setVerticalGroup(
				gl_desktopPane1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane1.createSequentialGroup()
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(SNOlabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addComponent(SNOField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGap(35)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(oldpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGap(37)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(newpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(label3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGap(51)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addComponent(againpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGap(88)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING)
										.addComponent(buttonsave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonreset, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
		);
		desktopPane1.setLayout(gl_desktopPane1);


		button1.addActionListener(new ActionListener() {
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
//添加学生消息的面板
		JPanel record = new JPanel();
		record.setBackground(Color.WHITE);
		record.setBounds(0, 0, 1028, 590);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);

		//“提交”按钮
		JButton buttonsubmit = new JButton("提交");
		buttonsubmit.setFont(new Font("楷体", Font.PLAIN, 25));


		//删除学生信息
		JButton deletebutton = new JButton("删除学生信息");
		deletebutton.setFont(new Font("楷体", Font.PLAIN, 25));



		tableModel=new DefaultTableModel(
				queryData1(),
				new String[] {
						"\u5B66\u53F7", "\u59D3\u540D", "\u4E13\u4E1A", "\u6027\u522B", "\u5BC6\u7801", "\u5E74\u7EA7"
				}
		);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("楷体", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);

		addbutton = new JButton("添加行");
		addbutton.setFont(new Font("楷体", Font.PLAIN, 25));



		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.rowAtPoint(e.getPoint());//选中行
				a1=String.valueOf(table.getValueAt(row,0));
				a2=String.valueOf(table.getValueAt(row,1));
				a3=String.valueOf(table.getValueAt(row,2));
				a4=String.valueOf(table.getValueAt(row,3));
				a5=String.valueOf(table.getValueAt(row,4));
				a6=String.valueOf(table.getValueAt(row,5));




				//System.out.println(a1+"\t"+a2+"\t"+a3);
				//table.getValueAt(row,0).toString();
			}
		});

//“删除学生信息”按钮
		deletebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql4="delete from S where SNO='"+a1+"'";
				int rs=Myutil.get(sql4);
				if(rs==1){
					JOptionPane.showMessageDialog(null,"学生信息删除成功！");
				}
				tableModel.removeRow(row);
				table.updateUI();
			}
		});

//学生信息“提交”按钮
		buttonsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=3;
				if(!(a1==null&&a2==null&&a3==null&&a4==null&&a5==null&&a6==null)){
					if(a1!=null&&a2!=null&&a3!=null&&a4!=null&&a5!=null&&a6!=null){
						count=0;
					}else {
						count=3;
					}

				}else if(a1==null&&a2==null&&a3==null&&a4==null&&a5==null&&a6==null){//无选择时，与输入数据为空时
					count=1;
				}else{
					count=2;
				}

				String sql2="select SNO from S";
				ResultSet rs2=Myutil.getRs(sql2);
				try{
					int i=1;
					//int x=1;
					while(rs2.next()){
						if(!(rs2.getString("SNO").equals(a1))&&count==0){
							i=2;
						}else {
							i=1;
							break;
						}

					}

					if(i==2){
						String sql3="insert into S values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"')";
						int rs3=Myutil.get(sql3);
						if(rs3==1){
							JOptionPane.showMessageDialog(null,"学生信息添加成功！");
						}
					}
					if(i==1||count==2||count==3){
						JOptionPane.showMessageDialog(null,"添加的学生信息重复或空！");
//                                                        tableModel.removeRow(row);
//                                                        table.updateUI();
					}
//                                        }
				}catch (Exception e2){
					e2.printStackTrace();
				}
			}
		});

//学生信息“添加行”按钮功能实现
		addbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableModel.addRow(new Object[] {});
			}
		});


		GroupLayout gl_record = new GroupLayout(record);
		gl_record.setHorizontalGroup(
				gl_record.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_record.createSequentialGroup()
								.addGroup(gl_record.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_record.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
										.addGroup(gl_record.createSequentialGroup()
												.addGap(172)
												.addComponent(addbutton)
												.addGap(142)
												.addComponent(buttonsubmit, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
												.addGap(155)
												.addComponent(deletebutton)))
								.addContainerGap())
		);
		gl_record.setVerticalGroup(
				gl_record.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_record.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_record.createParallelGroup(Alignment.BASELINE)
										.addComponent(deletebutton)
										.addComponent(addbutton)
										.addComponent(buttonsubmit))
								.addGap(17))
		);
		record.setLayout(gl_record);

		button2.addActionListener(new ActionListener() {
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



//修改老师密码界面
		JPanel Changepwd = new JPanel();
		Changepwd.setBackground(new Color(255, 255, 255));

		JLabel label_1_1 = new JLabel("\u4FEE\u6539\u6559\u5E08\u5BC6\u7801");
		label_1_1.setBackground(new Color(169, 169, 169));
		label_1_1.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel label_2_2 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		label_2_2.setFont(new Font("楷体", Font.PLAIN, 25));
		label_2_2.setBackground(new Color(240, 240, 240));

		JLabel label_3_3 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_3_3.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel label_4_4 = new JLabel("\u786E\u5B9A\u5BC6\u7801\uFF1A");
		label_4_4.setFont(new Font("楷体", Font.PLAIN, 25));

		oldpasswordField1 = new JPasswordField();
		oldpasswordField1.setFont(new Font("仿宋", Font.PLAIN, 20));

		newpasswordField1 = new JPasswordField();
		newpasswordField1.setFont(new Font("仿宋", Font.PLAIN, 20));

		againpasswordField1 = new JPasswordField();
		againpasswordField1.setFont(new Font("仿宋", Font.PLAIN, 20));

		JButton buttonreset1 = new JButton("\u91CD\u7F6E");
		buttonreset1.setFont(new Font("楷体", Font.PLAIN, 25));
		buttonreset1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TNOField.setText("");
				newpasswordField1.setText("");
				oldpasswordField1.setText("");
				againpasswordField1.setText("");
			}
		});


//教师修改密码功能
		JButton buttonsave1 = new JButton("提交");
		buttonsave1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (newpasswordField1.getText().isEmpty() || againpasswordField1.getText().isEmpty() || !(newpasswordField1.getText().equals(againpasswordField1.getText()))) {
					JOptionPane.showMessageDialog(null, "新密码与确认密码内容不匹配或内容为空！");
					oldpasswordField1.setText("");
					newpasswordField1.setText("");
					againpasswordField1.setText("");
				} else {
					int t=0;
					String sql2 = "select * from T where TNO='" + TNOField + "'";
					ResultSet r1 = Myutil.getRs(sql2);

					try {
						while (r1.next()) {
							if (r1.getString("PW").equals(oldpasswordField1)) {
								t=0;
								break;
							}else{
								t=1;
								break;
							}
						}
						if(t==0){
							String sql = "update T set PW='" + newpasswordField1.getText() + "'where TNO ='" + TNOField.getText() + "'and PW='" + oldpasswordField1.getText() + "'";
							int rs0 = Myutil.get(sql);
							if(rs0==1){
								if (newpasswordField1.getText().equals(againpasswordField1.getText()) && !(newpasswordField1.getText().isEmpty()) && !(againpasswordField1.getText().isEmpty()) && !(oldpasswordField1.getText().isEmpty())) {
									JOptionPane.showMessageDialog(null, "修改密码成功！");
									oldpasswordField1.setText("");
									newpasswordField1.setText("");
									againpasswordField1.setText("");
								}else{
									JOptionPane.showMessageDialog(null, "修改密码失败！");
									oldpasswordField1.setText("");
									newpasswordField1.setText("");
									againpasswordField1.setText("");
								}
							}else {
								JOptionPane.showMessageDialog(null,"出现错误！");
								oldpasswordField1.setText("");
								newpasswordField1.setText("");
								againpasswordField1.setText("");
							}
						}else{
							JOptionPane.showMessageDialog(null,"找不到该账号！");
							oldpasswordField1.setText("");
							newpasswordField1.setText("");
							againpasswordField1.setText("");
						}

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}
		});


		buttonsave1.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel TNOlabel = new JLabel("\u6559\u5E08\u53F7\uFF1A");
		TNOlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		TNOField = new JTextField();
		TNOField.setFont(new Font("楷体", Font.PLAIN, 25));
		TNOField.setColumns(10);
		GroupLayout gl_Changepwd = new GroupLayout(Changepwd);
		gl_Changepwd.setHorizontalGroup(
				gl_Changepwd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Changepwd.createSequentialGroup()
								.addGroup(gl_Changepwd.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Changepwd.createSequentialGroup()
												.addGap(637)
												.addComponent(buttonreset1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_Changepwd.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_Changepwd.createSequentialGroup()
														.addGap(264)
														.addGroup(gl_Changepwd.createParallelGroup(Alignment.TRAILING)
																.addComponent(buttonsave1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
																.addComponent(label_4_4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(againpasswordField1))
												.addGroup(gl_Changepwd.createSequentialGroup()
														.addGroup(gl_Changepwd.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_Changepwd.createSequentialGroup()
																		.addGap(282)
																		.addGroup(gl_Changepwd.createParallelGroup(Alignment.TRAILING)
																				.addComponent(label_3_3)
																				.addComponent(label_2_2)
																				.addComponent(TNOlabel)))
																.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_Changepwd.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_Changepwd.createSequentialGroup()
																		.addGap(18)
																		.addGroup(gl_Changepwd.createParallelGroup(Alignment.LEADING)
																				.addComponent(TNOField, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
																				.addComponent(oldpasswordField1)))
																.addGroup(gl_Changepwd.createSequentialGroup()
																		.addGap(20)
																		.addComponent(newpasswordField1, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))))))
								.addGap(251))
		);
		gl_Changepwd.setVerticalGroup(
				gl_Changepwd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Changepwd.createSequentialGroup()
								.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_Changepwd.createParallelGroup(Alignment.LEADING)
										.addComponent(TNOlabel)
										.addComponent(TNOField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_Changepwd.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_2_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(oldpasswordField1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGap(45)
								.addGroup(gl_Changepwd.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_3_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(newpasswordField1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGap(34)
								.addGroup(gl_Changepwd.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addComponent(againpasswordField1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
								.addGroup(gl_Changepwd.createParallelGroup(Alignment.BASELINE)
										.addComponent(buttonreset1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonsave1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGap(73))
		);
		Changepwd.setLayout(gl_Changepwd);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mainpanel.removeAll();
				Mainpanel.repaint();
				JPanel  Mainpanel1=new JPanel();
				Mainpanel1.setBounds(0, 0, 1046, 700);
				Mainpanel1.setBackground(new Color(255, 255, 255));
				Mainpanel1.add(Changepwd);
				Mainpanel.add(Mainpanel1);
				Mainpanel.validate();
			}
		});


//添加教师信息
		JPanel addTeacher = new JPanel();
		addTeacher.setBackground(Color.WHITE);
		addTeacher.setBounds(0, 0, 1028, 590);

		JScrollPane scrollPane1 = new JScrollPane();

		JButton buttonsubmit1 = new JButton("\u63D0\u4EA4");
		buttonsubmit1.setFont(new Font("楷体", Font.PLAIN, 25));







		tableModel1=new DefaultTableModel(
				queryData2(),
				new String[] {
						"\u6559\u5E08\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5BC6\u7801", "\u7CFB\u522B", "\u804C\u79F0"
				}
		);
// {
////			boolean[] columnEditables = new boolean[] {
////					false, false, false, false, false, false
////			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		};
		Teachertable = new JTable(tableModel1);
		Teachertable.setBackground(Color.WHITE);
		Teachertable.setFont(new Font("楷体", Font.PLAIN, 18));
		Teachertable.setRowHeight(30);
		Teachertable.getTableHeader().setReorderingAllowed(false);
		Teachertable.getColumnModel().getColumn(0).setResizable(false);
		Teachertable.getColumnModel().getColumn(1).setResizable(false);
		Teachertable.getColumnModel().getColumn(2).setResizable(false);
		Teachertable.getColumnModel().getColumn(3).setResizable(false);
		Teachertable.getColumnModel().getColumn(4).setResizable(false);
		Teachertable.getColumnModel().getColumn(5).setResizable(false);
		scrollPane1.setViewportView(Teachertable);



		JButton dropbutton = new JButton("\u5220\u9664\u6559\u5E08\u4FE1\u606F");
		dropbutton.setFont(new Font("楷体", Font.PLAIN, 25));



		JButton addbutton1 = new JButton("\u6DFB\u52A0\u884C");
		addbutton1.setFont(new Font("楷体", Font.PLAIN, 25));
		//添加教师信息
		Teachertable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = Teachertable.rowAtPoint(e.getPoint());//选中行
				b1=String.valueOf(Teachertable.getValueAt(row,0));
				b2=String.valueOf(Teachertable.getValueAt(row,1));
				b3=String.valueOf(Teachertable.getValueAt(row,2));
				b4=String.valueOf(Teachertable.getValueAt(row,3));
				b5=String.valueOf(Teachertable.getValueAt(row,4));
				b6=String.valueOf(Teachertable.getValueAt(row,5));




				//System.out.println(a1+"\t"+a2+"\t"+a3);
				//table.getValueAt(row,0).toString();
			}
		});

		//删除教师信息
		dropbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql5="delete from T where TNO='"+b1+"'";
				int rs=Myutil.get(sql5);
				if(rs==1){
					JOptionPane.showMessageDialog(null,"教师信息删除成功！");
				}
				tableModel1.removeRow(row);
				Teachertable.updateUI();
			}
		});

		buttonsubmit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=3;
				if(!(b1==null&&b2==null&&b3==null&&b4==null&&b5==null&&b6==null)){
					if(b1!=null&&b2!=null&&b3!=null&&b4!=null&&b5!=null&&b6!=null){
						count=0;
					}else {
						count=3;
					}

				}else if(b1==null&&b2==null&&b3==null&&b4==null&&b5==null&&b6==null){//无选择时，与输入数据为空时
					count=1;
				}else{
					count=2;
				}

				String sql2="select TNO from T";
				ResultSet rs2=Myutil.getRs(sql2);
				try{
					int i=1;
					//int x=1;
					while(rs2.next()){
						if(!(rs2.getString("TNO").equals(b1))&&count==0){
							i=2;
						}else {
							i=1;
							break;
						}

					}

					if(i==2){
						String sql3="insert into T values('"+b1+"','"+b2+"','"+b3+"','"+b4+"','"+b5+"','"+b6+"')";
						int rs3=Myutil.get(sql3);
						if(rs3==1){
							JOptionPane.showMessageDialog(null,"教师信息添加成功！");
						}
					}
					if(i==1||count==2||count==3){
						JOptionPane.showMessageDialog(null,"添加的教师信息重复或空！");
//                                                        tableModel.removeRow(row);
//                                                        table.updateUI();
					}
//                                        }
				}catch (Exception e2){
					e2.printStackTrace();
				}

			}
		});


		//“添加行”按钮
		addbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableModel1.addRow(new Object[] {});
			}
		});

		GroupLayout gl_addTeacher = new GroupLayout(addTeacher);
		gl_addTeacher.setHorizontalGroup(
				gl_addTeacher.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addTeacher.createSequentialGroup()
								.addGroup(gl_addTeacher.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_addTeacher.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
										.addGroup(gl_addTeacher.createSequentialGroup()
												.addGap(139)
												.addComponent(addbutton1)
												.addGap(164)
												.addComponent(buttonsubmit1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
												.addGap(140)
												.addComponent(dropbutton)))
								.addContainerGap())
		);
		gl_addTeacher.setVerticalGroup(
				gl_addTeacher.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addTeacher.createSequentialGroup()
								.addContainerGap()
								.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_addTeacher.createParallelGroup(Alignment.BASELINE)
										.addComponent(addbutton1)
										.addComponent(buttonsubmit1)
										.addComponent(dropbutton))
								.addGap(17))
		);
		addTeacher.setLayout(gl_addTeacher);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mainpanel.removeAll();
				Mainpanel.repaint();
				JPanel  Mainpanel1=new JPanel();
				Mainpanel1.setBounds(0, 0, 1046, 700);
				Mainpanel1.setBackground(new Color(255, 255, 255));
				Mainpanel1.add(addTeacher);
				Mainpanel.add(Mainpanel1);
				Mainpanel.validate();

			}
		});



	}//类的结尾
	public Object[][] queryData1(){
		List<Students> list=addStu.addStudents();
		data=new Object[list.size()][6];
		for(int i=0;i<list.size();i++){
			for(int j=0;j<6;j++){
				data[i][0]=list.get(i).getSNO();
				data[i][1]=list.get(i).getSN();
				data[i][2]=list.get(i).getPro();
				data[i][3]=list.get(i).getSex();
				data[i][4]=list.get(i).getSPW();
				data[i][5]=list.get(i).getGrade();
			}
		}
		return data;
	}
	public Object[][] queryData2(){
		List<Teacher> list=addTea.addTeachers();
		data1=new Object[list.size()][6];
		for(int i=0;i<list.size();i++){
			for(int j=0;j<6;j++){
				data1[i][0]=list.get(i).getTNO();
				data1[i][1]=list.get(i).getTN();
				data1[i][2]=list.get(i).getSex();
				data1[i][3]=list.get(i).getTPW();
				data1[i][4]=list.get(i).getDept();
				data1[i][5]=list.get(i).getProf();
			}
		}
		return data1;
	}
}
