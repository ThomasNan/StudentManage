package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDAO;
import entity.Stu;

public class FindStuServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String id = req.getParameter("id");
		StuDAO dao = new StuDAO();
		Stu s = dao.findById(Integer.parseInt(id));
		out.println("<form action='update' method='post'>");
		out.println("<p>"+id+"</p>");
		out.println("姓名<input name='sname' value='"+s.getName()+"'/><br>");
		out.println("班级<input name='sclass' value='"+s.getSclass()+"'/><br>");
		out.println("学校<input name='school' value='"+s.getSchool()+"'/><br>");
		out.println("电话<input name='tel' value='"+s.getTel()+"'/><br>");
		out.println("QQ<input name='qq' value='"+s.getQq()+"'/><br>");
		out.println("<input type='hidden' name='id' value='"+id+"'/>");
		out.println("<input type='submit'>");
		out.println("</form>");
	}
}
