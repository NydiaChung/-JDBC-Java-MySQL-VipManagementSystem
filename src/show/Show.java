package show;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.StuDAO;
import vo.Student;

/**   
* Copyright: Copyright (c) 2020 
*
* Date         Author          Version           ClassName 
*---------------------------------------------------------*
* 2020年4月9日     zongyue           v1.0.0           Show.java    
*
* @Description: 显示
*/
public class Show extends JFrame{
	

	/**   
	* @Function: Show.java
	* @Description: 
	*
	* @param:
	* @author: zongyue
	* @date: 2020年4月9日 下午10:04:00 
	*/
	/**   
	* @Function: Show.java
	* @Description: 
	*
	* @param:
	* @author: zongyue
	* @date: 2020年4月9日 下午10:43:32 
	*/
	/**   
	* @Function: Show.java
	* @Description: 
	*
	* @param:
	* @author: zongyue
	* @date: 2020年4月9日 下午10:43:38 
	*/
	/**   
	* @Function: Show.java
	* @Description: 
	*
	* @param:
	* @author: zongyue
	* @date: 2020年4月9日 下午10:43:43 
	*/
	public Show() {
		// TODO Auto-generated constructor stub
		 setSize(600,600);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(false);
		 setLocationRelativeTo(null);
		 setLayout(null);
		 setTitle("创业实践中心会员管理系统");
		 Font f = new Font("楷体",Font.BOLD,18); 
		 
		 
		 JLabel j0=new JLabel("查看信息");
		 j0.setBounds(260,20,80,30);
		 j0.setFont(f);
		 add(j0);
		  
		 JLabel j1=new JLabel("会员号：");
		 j1.setBounds(20,70,60,30);
		 add(j1);
		 final JTextField jt1=new JTextField();
		 jt1.setBounds(100,70,130,30);
		 add(jt1);
		  		 
		 JLabel j2=new JLabel("姓名：");
		 j2.setBounds(30,120,50,30);
		 add(j2);
		  
		 final JTextField jt2=new JTextField();
		 jt2.setBounds(100,120,130,30);
		 add(jt2);
		  
		 JLabel j3=new JLabel("性别：");
		 j3.setBounds(30,170,50,30);
		 add(j3);
		  
		 final JTextField jt3=new JTextField();
		 jt3.setBounds(100,170,130,30);
		 add(jt3);
		  
		 JLabel j4=new JLabel("院系：");
		 j4.setBounds(30,220,50,30);
		 add(j4);
		  
		 final JTextField jt4=new JTextField();
		 jt4.setBounds(100,220,130,30);
		 add(jt4);
		  
		 
		 
		 JLabel j5=new JLabel("年级：");
		 j5.setBounds(330,70,50,30);
		 add(j5);
		  
		 final JTextField jt5=new JTextField();
		 jt5.setBounds(400,70,130,30);
		 add(jt5);
		 
		 JLabel j6=new JLabel("学号：");
		 j6.setBounds(330,120,50,30);
		 add(j6);
		  
		 final JTextField jt6=new JTextField();
		 jt6.setBounds(400,120,130,30);
		 add(jt6);
		 
		 JLabel j7=new JLabel("手机：");
		 j7.setBounds(330,170,50,30);
		 add(j7);
		  
		 final JTextField jt7=new JTextField();
		 jt7.setBounds(400,170,130,30);
		 add(jt7);
		 
		 JLabel j8=new JLabel("QQ：");
		 j8.setBounds(330,220,50,30);
		 add(j8);
		  
		 final JTextField jt8=new JTextField();
		 jt8.setBounds(400,220,130,30);
		 add(jt8);
		 
		 
		 JLabel j9=new JLabel("备注：");
		 j9.setBounds(30,270,50,30);
		 add(j9);
		  
		 final JTextField jt9=new JTextField();
		 jt9.setBounds(100,270,430,200);
		 add(jt9);
		 
		 
		 
		 JButton jb1 = new JButton("查找");
		 jb1.setBounds(50, 500, 80, 30);
		 add(jb1);
		 JButton jb2 = new JButton("修改");
		 jb2.setBounds(150, 500, 80, 30);
		 add(jb2);
		 JButton jb3 = new JButton("添加");
		 jb3.setBounds(250, 500, 80, 30);
		 add(jb3);
		 JButton jb4 = new JButton("删除");
		 jb4.setBounds(350, 500, 80, 30);
		 add(jb4);
		 JButton jb5 = new JButton("返回");
		 jb5.setBounds(450, 500, 80, 30);
		 add(jb5);
		 
		 
		 repaint();//刷新
			
		
		 
		 
		 jb1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				//根据输入的学号进行查询
				 StuDAO dao=new StuDAO();
				 ArrayList<Student> list=dao.check();
				 Student stu=new Student();
				 String id = jt6.getText();
				 boolean found = false;
				 for(int i=0;i<list.size();i++){
					 stu=list.get(i);
					 if(stu.getStuid().equals(id)){
						 found = true;
						 break;//找到该学生后跳出遍历
					 }
					 
				 }
				if(found){
					//显示原来的对应信息
					 jt1.setText(stu.getVipid());
					 jt2.setText(stu.getStuname());
					 jt3.setText(stu.getSex());
					 jt4.setText(stu.getCollege());
					 jt5.setText(stu.getGrade());
					 jt6.setText(stu.getStuid());
					 jt7.setText(stu.getTele());
					 jt8.setText(stu.getQq());
					 jt9.setText(stu.getNote());
				}else{
					JOptionPane.showMessageDialog(null,"系统未录入");
					 Show show = new Show();
					 show.setVisible(true);
					 setVisible(false);
				}
				
			
			 }
			 
		 });
		 
		 //修改
		 jb2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				 Student stu=new Student();
				 StuDAO dao=new StuDAO();
				 stu.setStuid(jt6.getText());
				 
				 int confirm =JOptionPane.showConfirmDialog(null, "您确定要修改信息吗？", "修改信息", JOptionPane.YES_NO_OPTION); 
				 if (confirm==JOptionPane.YES_OPTION) {
					 //学号不能修改
					 stu.setVipid(jt1.getText());
					 stu.setStuname(jt2.getText());
					 stu.setSex(jt3.getText());
					 stu.setCollege(jt4.getText());
					 stu.setGrade(jt5.getText());
					 stu.setTele(jt7.getText());
					 stu.setQq(jt8.getText());
					 stu.setNote(jt9.getText());
					 
					 boolean db = dao.update(stu);
					 if(db){
						 JOptionPane.showMessageDialog(null,"修改成功");
						 Show show = new Show();
						 show.setVisible(true);
						 setVisible(false);
					 }else{
						 JOptionPane.showMessageDialog(null,"修改失败");
					 }
				}else{
					Show show = new Show();
					 show.setVisible(true);
					 setVisible(false);
				}
			 				
			 }
		 });
		 
		 
		 //添加
		 jb3.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				 String a=jt1.getText();//获取输入的信息
				 String b=jt2.getText();
				 String c=jt3.getText();
				 String d=jt4.getText();
				 String e=jt5.getText();
				 String f=jt6.getText();
				 String g=jt7.getText();
				 String h=jt8.getText();
				 String i=jt9.getText();
				 
				 Student stu=new Student(a,b,c,d,e,f,g,h,i);
				 StuDAO dao=new StuDAO();
				 ArrayList<Student> list=dao.check();//调用StuDAO里面的check()方法
				 for(Student st:list){//遍历集合
					 if(st.getStuid().equals(f)){
						 JOptionPane.showMessageDialog(null,"该账号存在");
						 return;
					 }
				 }
				 boolean ab = dao.add(stu);
				 if(ab){
					 JOptionPane.showMessageDialog(null,"添加成功");
					 Show show = new Show();
					 show.setVisible(true);
					 setVisible(false);
				 }else{
					 JOptionPane.showMessageDialog(null,"添加失败");
					 
				 }
				 
			 }
		 });
		 
		 
		 
		 
		 //删除
		 jb4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				//根据学号确定学生，再删除该学生
				 StuDAO dao=new StuDAO();
				 Student stu=new Student();
				 stu.setStuid(jt6.getText());
				 int confirm =JOptionPane.showConfirmDialog(null, "您确定要删除信息吗？", "删除信息", JOptionPane.YES_NO_OPTION); 
				 if (confirm==JOptionPane.YES_OPTION) {
					 boolean db = dao.delete(stu);
					 if(db){
						 JOptionPane.showMessageDialog(null,"删除成功");
						 Show show = new Show();
						 show.setVisible(true);
						 setVisible(false);
					 }else{
						 JOptionPane.showMessageDialog(null,"删除失败");
					 }
				}else{
					Show show = new Show();
					 show.setVisible(true);
					 setVisible(false);
				}
			 }
		 });
		 
		 jb5.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				 Show show= new Show();
				 show.setVisible(true);
				 setVisible(false);
			 }
		 });

	 }

}