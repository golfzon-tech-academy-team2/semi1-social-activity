package com.team2.sa.signup;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

/**
 * Servlet implementation class SignupController
 */
@WebServlet({ "/signup.do", "/signupOK.do", "/idCheck.do"})
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.equals("/signup.do")) {
			request.getRequestDispatcher("signup/signup.jsp").forward(request, response);
		} else if (sPath.equals("/idCheck.do")) {
			String id = request.getParameter("user_id");
			SignupDAO dao = new SignupDAOimpl();
			System.out.println(id);
			int result = dao.idCheck(id);
			
			HttpSession session = request.getSession();
	        session.setAttribute("result", result);
	        
	        request.getRequestDispatcher("signup/dbCheckid.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);

		if (sPath.equals("/signupOK.do")) {
			request.setCharacterEncoding("UTF-8");
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pw"));
			System.out.println(request.getParameter("sex"));
			System.out.println(request.getParameter("addr"));
			System.out.println(request.getParameter("tel"));
			System.out.println(request.getParameter("bday"));

			UserinfoVO vo = new UserinfoVO();
			vo.setUname(request.getParameter("uname"));
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			if (request.getParameter("sex").equals("남자")) {
				vo.setSex("M");
			} else {
				vo.setSex("F");
			}
			vo.setAddr(request.getParameter("addr"));
			vo.setTel(request.getParameter("tel"));
			vo.setBday(Date.valueOf(request.getParameter("bday")));
			SignupDAO dao = new SignupDAOimpl();
			int result = dao.insert(vo);
			
			if (result == 1) {
				response.sendRedirect("login.do");
			}
		}

	}

}