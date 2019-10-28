package com.newer.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.newer.domain.User;
import com.newer.service.UserService;


@WebServlet("/sessionuser")
public class GlobalServlet extends HttpServlet {

     private UserService userService;

	@Override
	public void init() throws ServletException {
		userService=new UserService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();

		if(action==null){
			//获取session里面的用户
			User user=(User) session.getAttribute("loginer");
			if(user!=null){
			Gson gson=new Gson();
			out.print(gson.toJson(user));
			}else{
				out.print(0);
			}
		}else if("logout".equals(action)){
			//去除session里面的用户
		    session.invalidate();
			out.print(1);

		}
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
