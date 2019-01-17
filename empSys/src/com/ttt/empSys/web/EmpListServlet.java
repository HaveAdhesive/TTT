package com.ttt.empSys.web;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class EmpListServlet
 */

/**
 * 显示所有员工信息的servlet
 */
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取全局参数配置
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		//设置请求编码格式
		request.setCharacterEncoding(encoding);
		//设置响应格式
		response.setContentType("text/html;charset=" + encoding);
		
		//通过service获取所有员工信息
		IEmpSysService service = new EmpSysService();
		List<Emp> list = service.findAll();
		
		//把所有员工信息存入到请求域中
		request.setAttribute("list", list);
		
		// 请求转发
		request.getRequestDispatcher("/empList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
