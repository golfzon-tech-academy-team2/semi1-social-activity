package com.team2.sa.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.board.model.BoardJoinDAO;
import com.team2.sa.board.model.BoardJoinDAOimpl;
import com.team2.sa.board.model.BoardJoinVO;

/**
 * Servlet implementation class BoardSelectOneController
 */
@WebServlet("/b_selectOne.do")
public class BoardSelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectOneController() {
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
		System.out.println(request.getParameter("gNum"));
		System.out.println(request.getParameter("bNum"));
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		BoardJoinDAO dao = new BoardJoinDAOimpl();
		BoardJoinVO vo = new BoardJoinVO();
		vo = dao.selectOne(bNum);
		request.setAttribute("vo",vo);
		request.getRequestDispatcher("board/selectOne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
