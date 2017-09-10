package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Stu;
import util.DBUtil;

public class StuDAO {
	//���һ��ѧ��
	public void save(Stu s){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into students_thomas "
					+ "values(students_seq_thomas.nextval,"
					+ "?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getSclass());
			ps.setString(3, s.getSchool());
			ps.setInt(4, s.getTel());
			ps.setInt(5, s.getQq());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���ʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//����ȫ����ѧ��
	public List<Stu> findAll(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from students_thomas";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Stu> list = new ArrayList<Stu>();
			while(rs.next()){
				Stu s = new Stu();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("sname"));
				s.setSclass(rs.getString("sclass"));
				s.setSchool(rs.getString("school"));
				s.setTel(rs.getInt("tel"));
				s.setQq(rs.getInt("qq"));
				list.add(s);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��",e);
		} finally{
			DBUtil.close(conn);
		}	
	}
	
	//ɾ��
	public void delete(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from students_thomas where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��ʧ��",e);
		} finally{
			DBUtil.close(conn);
		}
	}
	//����һ��ѧ��
	public Stu findById(int id){
		Stu s = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from students_thomas where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				s = new Stu();
				s.setId(id);
				s.setName(rs.getString("sname"));
				s.setSclass(rs.getString("sclass"));
				s.setSchool(rs.getString("school"));
				s.setTel(rs.getInt("tel"));
				s.setQq(rs.getInt("qq"));
			}
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	//�޸�ѧ��
	public void update(Stu s){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update students_thomas set "
					+ "sname=?,"
					+ "sclass=?,"
					+ "school=?,"
					+ "tel=?,"
					+ "qq=? "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getSclass());
			ps.setString(3, s.getSchool());
			ps.setInt(4, s.getTel());
			ps.setInt(5, s.getQq());
			ps.setInt(6, s.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�޸�ʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
	}
}
