package dao;

import java.util.ArrayList;

import mapper.IMapper;
import mapper.StuMapper;
import utils.DBManager;
import vo.Student;

/**
 * 项目名称：会员管理系统
 * 类名称：StuDao
 * 类描述：放着增删改查分页等功能
 * @author zongyue
 *创建时间：2020年4月7日 下午6:43:18   
 * @version
 * 
 */
public class StuDAO {
	 public ArrayList<Student> check(){//查看
		 String sql="select * from STUDENT";//sql语句
		 DBManager db=new DBManager();
		 IMapper mapper=new StuMapper();//实现StuMapper
		 ArrayList<Student> list=db.executeQuery(sql, mapper,null);//null是指占位符为null,因为查看的是所有信息
		 return list;
	 }
	 
	public boolean add(Student stu){//添加
		 String sql="insert into STUDENT values(?,?,?,?,?,?,?,?,?)";
		 Object[] params={stu.getVipid(),stu.getStuname(),stu.getSex(),stu.getCollege(),stu.getGrade(),stu.getStuid(),stu.getTele(),stu.getQq(),stu.getNote()};
		 DBManager db=new DBManager();
		 int i=db.executeUpdate(sql, params);//返回值代表受到影响的行数
		 if(i>=0){
			 System.out.println("添加成功");
			 return true;
		 }else{
			 System.out.println("添加失败");
			 return false;
		 }
		 
	}
	
	public boolean update(Student stu){//修改
		 String sql="update student set vipid=?,stuname=?,sex=?,college=?,grade=?,tele=?,qq=?,note=? where stuid=?";
		 Object params[]={stu.getVipid(),stu.getStuname(),stu.getSex(),stu.getCollege(),stu.getGrade(),stu.getTele(),stu.getQq(),stu.getNote(),stu.getStuid()};
		 DBManager db=new DBManager();
		 int i=db.executeUpdate(sql, params);
		 if(i>=0){
			 System.out.println("修改成功");
			 return true;
		 }else{
			 System.out.println("修改失败");
			 return false;
		 }
		 
	}
	
	public boolean delete(Student stu){//删除
		 String sql="delete from student where stuid=?";
		 Object params[]={stu.getStuid()};
		 DBManager db=new DBManager();
		 int i=db.executeUpdate(sql, params);
		 System.out.println(i);
		 if(i>=0){
			 System.out.println("删除成功");
			 return true;
		 }else{
			 System.out.println("删除失败");
			 return false;
		 }
		 
	}
	


}
