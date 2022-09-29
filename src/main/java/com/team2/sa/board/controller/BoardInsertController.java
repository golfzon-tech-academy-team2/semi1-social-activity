package com.team2.sa.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.board.model.BoardDAO;
import com.team2.sa.board.model.BoardDAOimpl;
import com.team2.sa.board.model.BoardVO;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet({ "/b_insert.do", "/b_insertOK.do" })
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
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
		String user_id = (String) session.getAttribute("signedid");
		System.out.println("signedid: "+user_id);
		if(user_id != null) {
			request.getRequestDispatcher("board/insert.jsp").forward(request, response);;
		}else {
			response.sendRedirect("login.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doPost:" + sPath);
		BoardDAO dao = new BoardDAOimpl();
		BoardVO vo = new BoardVO();
		HttpSession session = request.getSession();
		String signedid = (String) session.getAttribute("signedid");
		int uNum = dao.findUnum(signedid);
		int gNum = Integer.parseInt(request.getParameter("gNum"));
		
		
		System.out.println("bTitle: "+request.getParameter("bTitle"));
		System.out.println("bContent: "+request.getParameter("bContent"));
		System.out.println("gNum: "+request.getParameter("gNum"));
		System.out.println(signedid);
		System.out.println(uNum);
		
		vo.setuNum(uNum);
		vo.setbContent(request.getParameter("bContent"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setgNum(gNum);

		if(dao.insert(vo)==1) {
			response.sendRedirect("gatheringinfo.do?gnum="+gNum);
		}else {
			response.sendRedirect("b_insert.do?gNum="+gNum);
		}
	}

}