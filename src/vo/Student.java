package vo;

/**
 * ��Ŀ���ƣ���Ա����ϵͳ
 * �����ƣ�Student
 * �������������ݿ�������ݷŵ�java��չʾ����һ�����������ݿ������Ϣһһ��Ӧ�����Ϳ��Ժ����׵Ĳ��������ݿ����һ���ж�Ӧ������һ�����ԡ�
 * @author zongyue
 *����ʱ�䣺2020��4��7�� ����5:05:50   
 * @version
 * 
 */
public class Student {
	private String vipid;                      
    private String stuname;                                      
    private String sex;
    private String college;
    private String grade;
    private String stuid;
    private String tele;
    private String qq;
    private String note;
    
    
    
	public Student(String vipid,String stuname,String sex,String college,String grade,String stuid,String tele,String qq,String note) {
		super();
		this.vipid = vipid;
		this.stuname = stuname;
		this.sex = sex;
		this.college = college;
		this.grade = grade;
		this.stuid = stuid;
		this.tele = tele;
		this.qq = qq;
		this.note = note;
	}
	
	
	public Student() {
		super();
	}
	
	public String getVipid() {
		return vipid;
	}
	public void setVipid(String vipid) {
		this.vipid = vipid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
    
	
    
    
}