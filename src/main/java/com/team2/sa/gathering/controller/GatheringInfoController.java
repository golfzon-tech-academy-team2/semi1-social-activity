package com.team2.sa.gathering.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.activity.ActivityDAO;
import com.team2.sa.activity.ActivityDAOimpl;
import com.team2.sa.activity.ActivityVO;
import com.team2.sa.board.model.BoardJoinDAO;
import com.team2.sa.board.model.BoardJoinDAOimpl;
import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;
import com.team2.sa.userinfo.member.UserInfoDAO;
import com.team2.sa.userinfo.member.UserInfoDAOimpl;
import com.team2.sa.userinfo.member.UserInfoJoinVO;
import com.team2.sa.vote.model.VoteDAO;
import com.team2.sa.vote.model.VoteDAOimpl;
import com.team2.sa.vote.model.VoteVO;

/**
 * Servlet implementation class GatheringInfoController
 */
@WebServlet("/gatheringinfo.do")
public class GatheringInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GatheringInfoController() {
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
		//모임 상세보기 페이지
		if(sPath.equals("/gatheringinfo.do")) {
			Date date = new Date(System.currentTimeMillis());
			request.setAttribute("today", date);
			
			System.out.println(request.getParameter("gnum"));
			BoardJoinDAO dao = new BoardJoinDAOimpl();
			List<BoardJoinVO> vo2 = dao.selectAll(Integer.parseInt(request.getParameter("gnum")));
			
			
			BoardJoinVO vo1 = dao.selectNotice(Integer.parseInt(request.getParameter("gnum")));
			
			ActivityDAO dao2 = new ActivityDAOimpl();
			List<ActivityVO> vo3 = dao2.selectAllActivity(Integer.parseInt(request.getParameter("gnum")));
			
			UserInfoDAO dao3 = new UserInfoDAOimpl();
			List<UserInfoJoinVO> vo4 = dao3.selectAll(Integer.parseInt(request.getParameter("gnum")));
			
			VoteDAO dao4 = new VoteDAOimpl();
			List<VoteVO> vo5 = dao4.selectAll(Integer.parseInt(request.getParameter("gnum")));
			Object[] vos = {vo1, vo2, vo3, vo4,vo5};
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("gathering/gatheringinfo.jsp").forward(request, response);
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
