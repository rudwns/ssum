package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.webDAO;


@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		try{
			webDAO dao = new webDAO();
			int a = dao.login(id,pw);

			if(a==1) {

				HttpSession session = request.getSession();

				session.setAttribute("id", id);
				//로그인 상태유지를 하기 위해
				//session 영역에 email 값 저장
				response.sendRedirect("index.html");
			}else{
				response.setContentType("text/html;charset = euc-kr");
				PrintWriter out = response.getWriter();
				out.print("비밀번호랑 아이디 다시확인하쇼");
			}
		}catch(Exception e) {


		}
	}

}
