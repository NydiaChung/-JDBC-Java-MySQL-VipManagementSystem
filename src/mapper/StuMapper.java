package mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Student;

public class StuMapper implements IMapper{
	
	 public ArrayList map(ResultSet rst) {
	 ArrayList<Student> list=new ArrayList<Student>();//��һ�����ϣ�������Student�������Ϣ��
	 try {
		 while(rst.next()){//
			 Student stu=new Student();
			 stu.setVipid(rst.getString("VIPID"));
			 stu.setStuname(rst.getString("STUNAME"));
			 stu.setCollege(rst.getString("COLLEGE"));
			 stu.setGrade(rst.getString("GRADE"));
			 stu.setNote(rst.getString("NOTE"));
			 stu.setQq(rst.getString("QQ"));
			 stu.setSex(rst.getString("SEX"));
			 stu.setStuid(rst.getString("STUID"));
			 stu.setTele(rst.getString("TELE"));
			 list.add(stu);//
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	 return list;
	 }
}
