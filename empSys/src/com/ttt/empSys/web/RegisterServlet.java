package com.ttt.empSys.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttt.empSys.domain.Emp;
import com.ttt.empSys.service.IEmpSysService;
import com.ttt.empSys.service.impl.EmpSysService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取全局参数配置
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		//设置请求的编码格式
		request.setCharacterEncoding(encoding);
		//设置响应的编码格式
		response.setContentType(encoding);
		
		//获取请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String age1 = request.getParameter("age");
		String hirdate1 = request.getParameter("hirdate");
		String salary1 = request.getParameter("salary");
		String phone = request.getParameter("phone");
		String emali = request.getParameter("emali");
		
		Integer age = Integer.valueOf(age1.toString());
		java.sql.Date hirdate = java.sql.Date.valueOf(hirdate1);
		Double salary = Double.valueOf(salary1.toString());
		
		
		Emp emp = new Emp();
		emp.setName(name);
		emp.setPassword(password);
		emp.setGender(gender);
		emp.setAge(age);
		emp.setHirdate(hirdate);
		emp.setSalary(salary);
		emp.setPhone(phone);
		emp.setEmali(emali);
		
		
		IEmpSysService service = new EmpSysService();
		service.AddUser(emp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
