package com.team2.sa.gathering.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.board.model.BoardDAO;
import com.team2.sa.board.model.BoardDAOimpl;
import com.team2.sa.board.model.BoardVO;

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
		if(sPath.equals("/gatheringinfo.do")) {//selectAll추가
			System.out.println(request.getParameter("gnum"));
			BoardDAO dao = new BoardDAOimpl();
			List<BoardVO> vos = dao.selectAll(Integer.parseInt(request.getParameter("gnum")));
			System.out.println("사이즈:"+vos.size());
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
