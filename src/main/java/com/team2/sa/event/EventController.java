package com.team2.sa.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;

/**
 * Servlet implementation class EventController
 */
@WebServlet({"/createEvent.do", "/createEventOK.do", "/deleteEvent.do"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		
		if (sPath.equals("/createEvent.do")) {
			request.setAttribute("aNum", Integer.parseInt(request.getParameter("aNum")));
			request.getRequestDispatcher("event/createEvent.jsp").forward(request, response);
		} else if (sPath.equals("/deleteEvent.do")) {
			EventDAO dao = new EventDAOimpl();
			System.out.println(request.getParameter("eNum"));
			dao.deleteEvent(Integer.parseInt(request.getParameter("eNum")));
			
			System.out.println(request.getParameter("aNum"));
			response.sendRedirect("activityInfo.do?aNum=" + (String) (request.getParameter("aNum")));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		if (sPath.equals("/createEventOK.do")) {
			
			System.out.println(request.getParameter("eTitle"));
			System.out.println(request.getParameter("eContent"));
			System.out.println(request.getParameter("gift"));
			System.out.println(request.getParameter("aNum"));
			
			EventVO vo = new EventVO();
			vo.seteTitle(request.getParameter("eTitle"));
			vo.seteContent(request.getParameter("eContent"));
			vo.setGift(request.getParameter("gift"));
			vo.setaNum(Integer.parseInt(request.getParameter("aNum")));
			EventDAO dao = new EventDAOimpl();
			dao.insert(vo);
			
			request.getRequestDispatcher("event/createEventOK.jsp").forward(request, response);
		}
	}

}
