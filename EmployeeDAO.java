package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;
import util.DBUtil;

public class EmployeeDAO {
	//����һ��Ա��
	public void save(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into emp_thomas (ename,salary,age) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setDouble(2, e.getSalary());
			ps.setInt(3, e.getAge());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("���Ա��ʧ��",e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	//��������Ա��
	public List<Employee> list(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from emp_thomas";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt("ID"));
				e.setName(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
				list.add(e);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��",e);
		} finally {
			DBUtil.close(conn);
		}
	}
	//ɾ��Ա��
	public void delete(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from emp_thomas where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��",e1);
		} finally {
			DBUtil.close(conn);
		}
	}
	//����id����һ��Ա��
	public Employee findById(int id){
		Connection conn = null;
		Employee e = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from emp_thomas where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				e = new Employee();
				e.setId(id);
				e.setName(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAge(rs.getInt("age"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("����ʧ��",e1);
		} finally {
			DBUtil.close(conn);
		}
		return e;
	}
	//�޸�һ��Ա��
	public void update(Employee e){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql ="update emp_thomas set ename=?,age=?,salary=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setInt(2, e.getAge());
			ps.setDouble(3, e.getSalary());
			ps.setInt(4, e.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("�޸�ʧ��",e1);
		}
	}
}
