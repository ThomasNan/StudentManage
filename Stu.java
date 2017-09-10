package entity;

public class Stu {
	private int id;
	private String name;
	private String school;
	private String sclass;
	private int tel;
	private int qq;
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", school=" + school + ", sclass=" + sclass + ", tel=" + tel
				+ ", qq=" + qq + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	
}
