package com.team2.sa.gathering.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.activity.ActivityDAO;
import com.team2.sa.activity.ActivityDAOimpl;
import com.team2.sa.activity.ActivityVO;
import com.team2.sa.board.model.BoardJoinDAO;
import com.team2.sa.board.model.BoardJoinDAOimpl;
import com.team2.sa.board.model.BoardJoinVO;

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
			Date date = new Date(System.currentTimeMillis());
			request.setAttribute("today", date);
			
			System.out.println(request.getParameter("gnum"));
			BoardJoinDAO dao = new BoardJoinDAOimpl();
			List<BoardJoinVO> vo2 = dao.selectAll(Integer.parseInt(request.getParameter("gnum")));
			
			
			BoardJoinVO vo1 = dao.selectNotice(Integer.parseInt(request.getParameter("gnum")));
			
			ActivityDAO dao2 = new ActivityDAOimpl();
			List<ActivityVO> vo3 = dao2.selectAllActivity(Integer.parseInt(request.getParameter("gnum")));
			Object[] vos = {vo1, vo2, vo3};
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
