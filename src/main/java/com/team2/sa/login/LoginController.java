package com.team2.sa.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.notification.NotificationVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({"/login.do", "/loginOK.do", "/logout.do"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if (sPath.equals("/login.do")) {
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.removeAttribute("signedid");
			response.sendRedirect("index.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if (sPath.equals("/loginOK.do")) {
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pw"));
			
			SigninDAO dao = new SigninDAOimpl();
			int result = dao.signin(request.getParameter("id"), request.getParameter("pw"));
			
			if (result == 0) {
				response.sendRedirect("login.do");
			} else if (result == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("signedid", request.getParameter("id"));
				
				List<NotificationVO> vos = dao.getAlerts((String) session.getAttribute("signedid"));
				
				System.out.println(vos);
				session.setAttribute("notificationVos", vos);
				response.sendRedirect("index.do");
			}
		}
	}

}
