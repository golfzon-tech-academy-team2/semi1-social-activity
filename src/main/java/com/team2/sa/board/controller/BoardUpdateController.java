package com.team2.sa.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.board.model.BoardDAO;
import com.team2.sa.board.model.BoardDAOimpl;
import com.team2.sa.board.model.BoardJoinDAO;
import com.team2.sa.board.model.BoardJoinDAOimpl;
import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.board.model.BoardVO;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet({ "/b_update.do", "/b_updateOK.do" })
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		System.out.println("doGet:" + sPath);
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		BoardJoinDAO dao = new BoardJoinDAOimpl();
		BoardJoinVO vo = new BoardJoinVO();
		vo = dao.selectOne(bNum);
		request.setAttribute("vo",vo);
		if(sPath.equals("/b_update.do")) {
			request.getRequestDispatcher("board/update.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		
		System.out.println("doPost:" + sPath);
		System.out.println(request.getParameter("bNum"));
		System.out.println(request.getParameter("gNum"));
		BoardVO vo = new BoardVO();
		int gNum = Integer.parseInt(request.getParameter("gNum"));
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		vo.setbNum(bNum);
		vo.setbContent(request.getParameter("bContent"));
		vo.setbTitle(request.getParameter("bTitle"));
		BoardDAO dao = new BoardDAOimpl();
		if (dao.update(vo) == 1) {
			response.sendRedirect("gatheringinfo.do?gnum="+gNum);
		} else {
			response.sendRedirect("b_update.do?bNum="+bNum);
		}
	}

}
