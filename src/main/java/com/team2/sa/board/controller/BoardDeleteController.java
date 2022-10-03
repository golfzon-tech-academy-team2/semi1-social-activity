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
import com.team2.sa.board.model.BoardVO;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet({ "/b_delete.do", "/b_deleteOK.do" })
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
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
		if(sPath.equals("/b_deleteOK.do")) {
				int bNum = Integer.parseInt(request.getParameter("bNum"));
				int gNum = Integer.parseInt(request.getParameter("gNum"));
				System.out.println(bNum);
				System.out.println(gNum);
				BoardDAO dao = new BoardDAOimpl();
				if (dao.delete(bNum) == 1) {
					System.out.println("success!!");
					response.sendRedirect("gatheringinfo.do?gnum="+gNum);//게더링인포로 이동
				} else {
					System.out.println("fail");
					response.sendRedirect("b_selectOne.do?bNum="+bNum+"&gNum="+gNum);//selectOne
				}

			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
