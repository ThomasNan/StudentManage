package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDAO;
import entity.Stu;

public class ListStuServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		StuDAO dao = new StuDAO();
		Stu s = new Stu();
		try{
			List<Stu> list = dao.findAll(); 
			out.println("<form action='' method='post'>");
			out.println("<table border='1px solid'>");
			out.println("<tr><td>id</td><td>姓名</td><td>班级</td><td>学校</td><td>tel</td><td>qq</td></tr>");
			for (int i = 0; i < list.size(); i++) {
				s = list.get(i);
				out.println("<tr>"
							+ "<td>"+s.getId()+"</td>"
							+ "<td>"+s.getName()+"</td>"
							+ "<td>"+s.getSclass()+"</td>"
							+ "<td>"+s.getSchool()+"</td>"
							+ "<td>"+s.getTel()+"</td>"
							+ "<td>"+s.getQq()+"</td>"
							+ "<td><a href='del?id="+s.getId()+"'>删除</a><a href='find?id="+s.getId()+"'>修改</a></td>"
							+ "</tr>");
			}
			out.println("</table>");
			out.println("</form>");
			out.println("<a href='add_student.html'>增加员工</a>");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("忙着呢",e);
		}
		
	}
}
