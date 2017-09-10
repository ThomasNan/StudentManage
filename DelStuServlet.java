package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDAO;
import entity.Stu;

public class DelStuServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		String id = req.getParameter("id");
		StuDAO dao = new StuDAO();
		Stu s = new Stu();
		try{
			dao.delete(Integer.parseInt(id));
			res.sendRedirect("list");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("ÕýÔÚÃ¦",e);
		}
	}
}
