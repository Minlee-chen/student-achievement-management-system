package com.window;

import dao.EntryScoreDo;
import model.*;
import util.Myutil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.List;


import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import com.window.StudentsMainFrm;

public class TeacherMainFrm extends JFrame {

	private JPanel contentPane;
	private Object [][]data=null;


	private JTextField TNField;
	private JTextField TNOField;
	private JTextField SexField;
	private JTextField DeptField;
	private JTextField ProfField;
	private int row;
	private String r0;
	private String r1;
	private String r2;

	JPasswordField newpasswordField;
	JPasswordField againpasswordField;
	JPasswordField oldpasswordField;

	private JTable table;
	//private ChooseContentDo con=new ChooseContentDo();
	private EntryScoreDo con=new EntryScoreDo();

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			TeacherMainFrm frame = new TeacherMainFrm();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public TeacherMainFrm() {
		setTitle("学生成绩管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1305, 762);
		this.setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 90, 239, 637);
		desktopPane.setBackground(new Color(128, 128, 128));

		JPanel Mainpanel = new JPanel();
		Mainpanel.setBounds(253, 90, 1046, 637);

		JLabel label1 = new JLabel("个人信息");
		label1.setIcon(new ImageIcon("src\\img\\\u6559\u5E08.png"));
		label1.setFont(new Font("楷体", Font.PLAIN, 30));
		label1.setBackground(new Color(169, 169, 169));
		label1.setForeground(new Color(255, 255, 255));
		label1.setBounds(0, 49, 200, 57);
		desktopPane.add(label1);

		JButton button1 = new JButton("修改密码");
		button1.setBounds(25, 144, 185, 55);
		desktopPane.add(button1);
		button1.setForeground(new Color(255, 255, 255));
		button1.setBackground(new Color(169, 169, 169));
		button1.setIcon(new ImageIcon("src\\img\\\u4FEE\u6539\u4FE1\u606F.png"));
		button1.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel label2 = new JLabel("录入模块");
		label2.setFont(new Font("楷体", Font.PLAIN, 30));
		label2.setBackground(new Color(169, 169, 169));
		label2.setForeground(new Color(255, 255, 255));
		label2.setIcon(new ImageIcon("src\\img\\\u5F55\u5165.png"));
		label2.setBounds(0, 270, 185, 63);
		desktopPane.add(label2);

		JButton button2 = new JButton("录入成绩");
		button2.setBounds(25, 367, 185, 55);
		desktopPane.add(button2);
		button2.setForeground(new Color(255, 255, 255));
		button2.setBackground(new Color(169, 169, 169));
		button2.setIcon(new ImageIcon("src\\img\\\u6559\u5E08\u767B\u5F55\u6210\u7EE9.png"));
		button2.setFont(new Font("楷体", Font.PLAIN, 25));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(desktopPane);
		contentPane.add(Mainpanel);

		JLabel lblRachAndMai = new JLabel("Rach and Mai \u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF  ");
		lblRachAndMai.setForeground(new Color(169, 169, 169));
		lblRachAndMai.setFont(new Font("华文行楷", Font.PLAIN, 28));

		JLabel label = new JLabel("@ \u4E1C\u839E\u57CE\u5E02\u5B66\u9662");
		label.setFont(new Font("华文行楷", Font.PLAIN, 28));
		label.setForeground(new Color(169, 169, 169));

		JLabel label3 = new JLabel("");
		label3.setIcon(new ImageIcon("src\\img\\\u5206\u6790\u6570\u636E.png"));
		GroupLayout gl_Mainpanel = new GroupLayout(Mainpanel);
		gl_Mainpanel.setHorizontalGroup(
				gl_Mainpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Mainpanel.createSequentialGroup()
								.addGap(366)
								.addComponent(label)
								.addContainerGap(144, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_Mainpanel.createSequentialGroup()
								.addContainerGap(89, Short.MAX_VALUE)
								.addComponent(label3, GroupLayout.PREFERRED_SIZE, 878, GroupLayout.PREFERRED_SIZE)
								.addGap(79))
						.addGroup(gl_Mainpanel.createSequentialGroup()
								.addGap(272)
								.addComponent(lblRachAndMai)
								.addContainerGap(395, Short.MAX_VALUE))
		);
		gl_Mainpanel.setVerticalGroup(
				gl_Mainpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Mainpanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(label3, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblRachAndMai)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label)
								.addGap(68))
		);
		Mainpanel.setLayout(gl_Mainpanel);

		JButton btnNewButton = new JButton("我的");
		btnNewButton.setIcon(new ImageIcon("src\\img\\\u6211\u7684.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 23));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(786, 13, 101, 56);
		contentPane.add(btnNewButton);

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
				JOptionPane.showMessageDialog(null,"本界面是老师界面:\n" +
						"功能1、可以修改自己的密码 。\n" +
						"功能2、可以录入选课学生的成绩。");
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

		JLabel label4 = new JLabel("教师界面");
		label4.setFont(new Font("华文行楷", Font.PLAIN, 40));
		label4.setForeground(new Color(255, 255, 255));
		label4.setBounds(472, 31, 231, 46);
		contentPane.add(label4);
//修改密码界面设计

		JDesktopPane desktopPane1 = new JDesktopPane();
		desktopPane1.setBackground(new Color(255, 255, 255));
		//getContentPane().add(desktopPane1, BorderLayout.CENTER);

		JLabel label_1 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label_1.setBackground(new Color(169, 169, 169));
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel label_2 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 25));
		label_2.setBackground(new Color(240, 240, 240));

		JLabel label_3 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel label_4 = new JLabel("\u786E\u5B9A\u5BC6\u7801\uFF1A");
		label_4.setFont(new Font("楷体", Font.PLAIN, 25));

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
					String sql="update T set PW='"+newpasswordField.getText()+"'where TNO='"+studentsInfo.textField.getText()+"'and PW='"+oldpasswordField.getText()+"'";
					int rs=Myutil.get(sql);
					try{
						if(rs==1){
							if(oldpasswordField.getText().equals(studentsInfo.passwordField.getText())&&newpasswordField.getText().equals(againpasswordField.getText())&&!(newpasswordField.getText().isEmpty())&&!(againpasswordField.getText().isEmpty())&&!(oldpasswordField.getText().isEmpty())){
								JOptionPane.showMessageDialog(null,"修改密码成功！");
								oldpasswordField.setText("");
								newpasswordField.setText("");
								againpasswordField.setText("");
							}
						}else{
							JOptionPane.showMessageDialog(null,"出现错误");
							oldpasswordField.setText("");
							newpasswordField.setText("");
							againpasswordField.setText("");
						}
					}catch (Exception e1){
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
																.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
																.addComponent(buttonsave, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(againpasswordField))
												.addGroup(gl_desktopPane1.createSequentialGroup()
														.addGap(282)
														.addGroup(gl_desktopPane1.createParallelGroup(Alignment.TRAILING)
																.addComponent(label_2)
																.addComponent(label_3))
														.addGap(20)
														.addGroup(gl_desktopPane1.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(oldpasswordField)
																.addComponent(newpasswordField, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))))
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(251, Short.MAX_VALUE))
		);
		gl_desktopPane1.setVerticalGroup(
				gl_desktopPane1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane1.createSequentialGroup()
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING, gl_desktopPane1.createSequentialGroup()
												.addContainerGap(85, Short.MAX_VALUE)
												.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
														.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
														.addComponent(oldpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(55)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(newpasswordField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGap(66)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addComponent(againpasswordField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
								.addGroup(gl_desktopPane1.createParallelGroup(Alignment.BASELINE)
										.addComponent(buttonreset, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonsave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGap(73))
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


//录入学生成绩表格

		JPanel record = new JPanel();
		record.setBackground(Color.WHITE);
		record.setBounds(0, 0, 1036, 601);
		//getContentPane().add(record);

		JScrollPane scrollPane = new JScrollPane();

		JButton buttonsubmit = new JButton("\u63D0\u4EA4");
		buttonsubmit.setFont(new Font("楷体", Font.PLAIN, 28));

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("楷体", Font.PLAIN, 18));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
				queryData1(),
				new String[] {
						"\u6559\u5E08\u53F7", "\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6210\u7EE9"
				}
		) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);

		//鼠标点击表格获取单行数据
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row = table.rowAtPoint(e.getPoint());//选中行
				r0=String.valueOf(table.getValueAt(row,5));
				r1=String.valueOf(table.getValueAt(row,3));
				r2=String.valueOf(table.getValueAt(row,1));
			}
		});

		//“提交”按钮功能
		buttonsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float a=Float.parseFloat(r0);//字符串转化为float类型
				if(a>=0&&a<=100){
					String sql5="update SC set Score='"+r0+"' where SNO='"+r1+"' and CNO='"+r2+"'";
					int rs=Myutil.get(sql5);
					try{
						if(rs==1){
							JOptionPane.showMessageDialog(null,"录入成绩成功！");
						}else{
							JOptionPane.showMessageDialog(null,"录入成绩失败！");
						}
					}catch (Exception e2){
						e2.printStackTrace();
					}

				}else{
					JOptionPane.showMessageDialog(null,"输入成绩无效，请重新输入！");
				}


			}
		});


		JLabel lrlabel = new JLabel("\u5F55\u5165\u6210\u7EE9");
		lrlabel.setFont(new Font("楷体", Font.PLAIN, 25));
		GroupLayout gl_record = new GroupLayout(record);
		gl_record.setHorizontalGroup(
				gl_record.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_record.createSequentialGroup()
								.addGroup(gl_record.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_record.createSequentialGroup()
												.addContainerGap()
												.addComponent(lrlabel))
										.addGroup(Alignment.TRAILING, gl_record.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
										.addGroup(gl_record.createSequentialGroup()
												.addGap(440)
												.addComponent(buttonsubmit, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap())
		);
		gl_record.setVerticalGroup(
				gl_record.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_record.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lrlabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(buttonsubmit, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addGap(32))
		);
		record.setLayout(gl_record);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mainpanel.removeAll();
				Mainpanel.repaint();
				JPanel  Mainpanel1=new JPanel();
				Mainpanel1.setBounds(0, 0, 1046, 600);
				Mainpanel1.setBackground(new Color(255, 255, 255));
				Mainpanel1.add(record);
				Mainpanel.add(Mainpanel1);
				Mainpanel.validate();
			}
		});






//“我的”界面的设计
		JPanel MyselfPane = new JPanel();
		MyselfPane.setBackground(Color.WHITE);


		JLabel Mylabel = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		Mylabel.setFont(new Font("楷体", Font.PLAIN, 26));

		JLabel SNlabel = new JLabel("\u59D3\u540D\uFF1A");
		SNlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		JLabel TNlabel = new JLabel("\u59D3\u540D\uFF1A");
		TNlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		TNField = new JTextField();
		TNField.setFont(new Font("楷体", Font.PLAIN, 25));
		TNField.setColumns(10);

		JLabel TNOlabel = new JLabel("\u6559\u5E08\u53F7\uFF1A");
		TNOlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		TNOField = new JTextField();
		TNOField.setFont(new Font("楷体", Font.PLAIN, 25));
		TNOField.setColumns(10);

		JLabel Sexlabel = new JLabel("\u6027\u522B\uFF1A");
		Sexlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		SexField = new JTextField();
		SexField.setFont(new Font("楷体", Font.PLAIN, 25));
		SexField.setColumns(10);

		JLabel Deptlabel = new JLabel("\u7CFB\u522B\uFF1A");
		Deptlabel.setFont(new Font("楷体", Font.PLAIN, 25));

		DeptField = new JTextField();
		DeptField.setFont(new Font("楷体", Font.PLAIN, 25));
		DeptField.setColumns(10);

		JLabel Proflabel = new JLabel("\u804C\u79F0\uFF1A");
		Proflabel.setFont(new Font("楷体", Font.PLAIN, 25));

		ProfField = new JTextField();
		ProfField.setFont(new Font("楷体", Font.PLAIN, 25));
		ProfField.setColumns(10);

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
																.addComponent(TNField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
														.addComponent(TNlabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
								.addGap(75)
								.addComponent(TNOlabel)
								.addGap(25)
								.addComponent(TNOField, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addGap(73)
								.addComponent(imgoneLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_MyselfPane.createSequentialGroup()
								.addGap(73)
								.addComponent(Sexlabel)
								.addGap(15)
								.addComponent(SexField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addGap(43)
								.addComponent(Deptlabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addGap(14)
								.addComponent(DeptField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(44)
								.addComponent(Proflabel)
								.addGap(46)
								.addComponent(ProfField, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
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
														.addComponent(TNField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
														.addComponent(TNlabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_MyselfPane.createSequentialGroup()
												.addGap(133)
												.addComponent(TNOlabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_MyselfPane.createSequentialGroup()
												.addGap(135)
												.addComponent(TNOField, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
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
												.addComponent(Deptlabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addComponent(DeptField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_MyselfPane.createSequentialGroup()
												.addGap(9)
												.addComponent(Proflabel))
										.addGroup(gl_MyselfPane.createSequentialGroup()
												.addGap(1)
												.addComponent(ProfField, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
								.addGap(8)
								.addComponent(imgtwolabel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
		);
		MyselfPane.setLayout(gl_MyselfPane);

//“我的”功能的呈现
		String sql="select * from T where TNO='"+studentsInfo.textField.getText()+"'";
		ResultSet rs= Myutil.getRs(sql);
		try{
			if(rs.next()){
				TNField.setText(rs.getString("TN"));
				TNOField.setText(rs.getString("TNO"));
				SexField.setText(rs.getString("Sex"));
				DeptField.setText(rs.getString("Dept"));
				ProfField.setText(rs.getString("Prof"));
				TNField.setEditable(false);
				TNOField.setEditable(false);
				SexField.setEditable(false);
				DeptField.setEditable(false);
				ProfField.setEditable(false);

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
		List<Grade> list=con.entryScore();
		data=new Object[list.size()][6];
		for(int i=0;i<list.size();i++){
			for(int j=0;j<6;j++){
				data[i][0]=list.get(i).getTNO();
				data[i][1]=list.get(i).getCNO();
				data[i][2]=list.get(i).getCN();
				data[i][3]=list.get(i).getSNO();
				data[i][4]=list.get(i).getSN();
				data[i][5]=list.get(i).getScore();
			}
		}
		return data;
	}

}
