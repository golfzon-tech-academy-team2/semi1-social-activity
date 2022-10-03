package com.team2.sa.gathering.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.gathering.model.GatheringUserInfoDAO;
import com.team2.sa.gathering.model.GatheringUserInfoDAOimpl;
import com.team2.sa.gathering.model.GatheringUserInfoVO;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;

/**
 * Servlet implementation class JoinGatheringController
 */
@WebServlet({ "/joinPubGathering.do", "/joinPriGathering.do", "/joinPubGatheringOK.do", "/joinPriGatheringOK.do" })
public class JoinGatheringController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinGatheringController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();

		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		
		String signedid = (String) session.getAttribute("signedid");
		if(signedid != null) {
		if (sPath.equals("/joinPubGathering.do")) {
			System.out.println(request.getParameter("gNum"));
			System.out.println(signedid);
			GatheringUserInfoDAO dao = new GatheringUserInfoDAOimpl();
			dao.insert(Integer.parseInt(request.getParameter("gNum")),"M",signedid);

		}
		}else {
			response.sendRedirect("login.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
