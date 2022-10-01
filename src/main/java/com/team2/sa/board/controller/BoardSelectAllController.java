package com.team2.sa.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.board.model.BoardJoinDAO;
import com.team2.sa.board.model.BoardJoinDAOimpl;
import com.team2.sa.board.model.BoardJoinVO;

/**
 * Servlet implementation class BoardSelectAllController
 */
@WebServlet("/b_selectAll.do")
public class BoardSelectAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//selectall notice
		String sPath = request.getServletPath();
		if(sPath.equals("/b_selectAll.do")) {
			BoardJoinDAO dao = new BoardJoinDAOimpl();
			List<BoardJoinVO> vos = dao.selectAllNotice(Integer.parseInt(request.getParameter("gNum")));
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("board/selectAllNotice.jsp").forward(request, response);
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
