package utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;



import mapper.IMapper;

/**
 * 项目名称：会员管理系统
 * 类名称：DBManager
 * 类描述：用JDBC连接数据库的，固定写法。
 * @author zongyue
 *创建时间：2020年4月7日 下午3:44:32   
 * @version
 * 
 */
public class DBManager {
	/*
	 * 工具类中的构造方法都是私有的
	 * 因为工具类中的方法都是静态的，不需要new对象，直接采用类名调用
	 * */
	public DBManager(){}
	
	//静态代码块在类加载时执行并且只执行一次
	static{
		//第一步：注册驱动（作用：告诉Java程序，即将要连接的是哪个品牌的数据库）
		//通过得到字节码对象的方式加载静态代码块，从而注册驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static Connection getConnection() throws SQLException{

//		第二步：获取连接（表示JVM的进程和数据库进程之间的通道打开了，这属于进程之间的通信，重量级的，使用完之后一定要关闭通道。）
		String url = "jdbc:mysql://localhost:3306/STUDENT?useUnicode=true&characterEncoding=utf8&nullCatalogMeansCurrent=true&useSSL=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";//如果是本机，也可以将localhost:3306省掉 
	    String user = "root"; 
	    String password = "trybest6@mysql"; 
	    Connection conn = (Connection)DriverManager.getConnection(url, user, password); 
	
		return conn;
	}
	
//	第三步：获取数据库操作对象（专门执行sql语句的对象）
//
//	第四步：执行SQL语句（DQL DML....）
//
//	第五步：处理查询结果集（只有当第四步执行的是select语句的时候，才有这第五步处理查询结果集。）
//
	
	//增删改结果集。因为sql语句是变化的，所以设为参数比较方便。params是占位符的，没学的可以忽略。
	 public int executeUpdate(String sql,Object[] params){
		 Connection conn=null;
		 PreparedStatement pst=null;
		 try {
			 conn=getConnection();//连接
			 pst=conn.prepareStatement(sql);//通道
			 if(params != null){//占位符的应用。
				 for(int i=0;i<params.length;i++){
					 pst.setObject(i+1,params[i]);//往通道里放数据，占位符下标从1开始。
				 }
			 }
			 return pst.executeUpdate();
		  
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return -1;
	 }
	//查询结果集。比增删改要复杂一些，慢慢看。
	//这里的IMapper是将所有可能的用到的类都放进去，方便以后继承使用。
	//用接口是因为接口多继承，方便维护升级
	 public ArrayList executeQuery(String sql,IMapper mapper,Object []params){
		 Connection conn=null;
		 PreparedStatement pst=null;
		 ResultSet rst=null;//查询结果集
		 ArrayList list= new ArrayList();//用一个集合存放Student信息
		 try {
			 conn=getConnection();
			 pst=conn.prepareStatement(sql);
			 if(params != null){
				 for(int i=0;i<params.length;i++){
					 pst.setObject(i+1,params[i]);
				 }
			 }
			 rst=pst.executeQuery();//把通道里的数据放入结果集
			 list=mapper.map(rst);//IMapper里有个map接口，里面存着结果集数据。把结果集的数据放入list集合
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return list;
	 }
	 
	 
//	第六步：释放资源（使用完资源之后一定要关闭资源。Java和数据库属于进程间的通信，开启之后一定要关闭。）
	/*
	 * conn:连接对象
	 * st：数据库操作对象
	 * rs：结果集
	 * */
	public static void close(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}