package com.team2.sa.gathering.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.board.model.BoardJoinDAOimpl;
import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.board.model.BoardJoinDAO;

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
		if(sPath.equals("/gatheringinfo.do")) {
			
			System.out.println(request.getParameter("gnum"));
			BoardJoinDAO dao = new BoardJoinDAOimpl();
			List<BoardJoinVO> vo2 = dao.selectAll(Integer.parseInt(request.getParameter("gnum")));
			
			
			BoardJoinVO vo1 = dao.selectNotice(Integer.parseInt(request.getParameter("gnum")));
			Object[] vos = {vo1, vo2};
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
