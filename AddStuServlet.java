package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDAO;
import entity.Stu;

public class AddStuServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		StuDAO dao = new StuDAO();
		Stu s = new Stu();
		s.setName(req.getParameter("sname"));
		s.setSclass(req.getParameter("sclass"));
		s.setSchool(req.getParameter("school"));
		s.setTel(Integer.parseInt(req.getParameter("tel")));
		s.setQq(Integer.parseInt(req.getParameter("qq")));
		try{
			dao.save(s);
			res.sendRedirect("list");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("ц╕ведь",e);
		}
	}
}
