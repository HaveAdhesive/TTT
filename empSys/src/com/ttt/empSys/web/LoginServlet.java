package com.ttt.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ttt.empSys.domain.Emp;
import com.ttt.empSys.service.IEmpSysService;
import com.ttt.empSys.service.impl.EmpSysService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setContentType("text/html;charset=" + encoding);
		
		//获取请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//获取用户输入的验证码
		String validate = request.getParameter("validate");
		
		//获取session中的验证码
		String val_in_session = (String) request.getSession().getAttribute("validate");
		
		//比较两个验证码是否正确，正确继续向下执行，不正确提示用户重新输入
		if(!val_in_session.equalsIgnoreCase(validate)) {
			request.setAttribute("val_msg", "验证码输入有误，请重新输入");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			return;
		}
		
		//调用service中的方法进行登录
		IEmpSysService service = new EmpSysService();
		//登录验证，通过姓名和密码来查找用户
		Emp emp = service.findEmpByNameAndPassword(name, password);
		
		if(emp != null) {
			//把登录用户存入到session中，表示开启了一次会话
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);
			
			//格式化日期时间
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
			String lastTime = simpleDateFormat.format(new Date());
			
			//获取请求中的cookies
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null) {
				Cookie c = null;
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					//System.out.println(cookie.getName());
					if("lastTime".equals(cookieName)) {
						c = cookie;
						break;
					}
				}
				
				if(c != null) {
					String value = c.getValue();
					request.setAttribute("lastTime", value);
					c.setValue(lastTime);
					response.addCookie(c);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				} else {
					c = new Cookie("lastTime", lastTime);
					//设置cookie
					c.setPath("/");
					c.setMaxAge(60 * 60 * 24 * 365);
					
					request.setAttribute("lastTime", lastTime);
					response.addCookie(c);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			} else {
				Cookie c = new Cookie("lastTime", lastTime);
				//设置cookie
				c.setPath("/");
				c.setMaxAge(60 * 60 * 24 * 365);
				
				request.setAttribute("lastTime", lastTime);
				response.addCookie(c);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
			response.getWriter().write("登录成功，3s后回到主页...");
			response.setHeader("refresh","3;URL=" + context.getContextPath() + "/index.jsp");
			
//			response.sendRedirect(context.getContextPath() + "/index.jsp");
			return;
		} else {
			
			request.setAttribute("error_msg", "姓名或密码有误，请检查后重试登录！！！");
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			return;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
