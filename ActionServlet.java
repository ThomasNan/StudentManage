package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String uri = req.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println(action);
		
		if("/list".equals(action)){
			EmployeeDAO dao = new EmployeeDAO();
			try{
				List<Employee> list = dao.list();
				req.setAttribute("employees", list);
				RequestDispatcher rd = req.getRequestDispatcher("list_emp.jsp");
				rd.forward(req, res);
			}catch(Exception e){
				e.printStackTrace();
				out.println("系统繁忙");
			}
		}else if("/add".equals(action)){
			String name = req.getParameter("ename");
			String age = req.getParameter("age");
			String salary = req.getParameter("salary");
			
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			
			e.setName(name);
			e.setAge(Integer.parseInt(age));
			e.setSalary(Integer.parseInt(salary));
			try{
				dao.save(e);
				res.sendRedirect("list.do");
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("系统繁忙,请稍后重试");
			}
		}else if("/del".equals(action)){
			String id = req.getParameter("id");
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setId(Integer.parseInt(id));
			try{
				dao.delete(e);
				res.sendRedirect("list.do");
			}catch(Exception e1){
				e1.printStackTrace();
				out.println("busy");
			}
		}else if("/load".equals(action)){
			
		}
	}
}
