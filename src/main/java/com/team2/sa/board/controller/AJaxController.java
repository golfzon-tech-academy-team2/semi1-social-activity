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

/**
 * Servlet implementation class IsLeaderController
 */
@WebServlet({"/isOL.do","/isSameWriter.do"})
public class AJaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AJaxController() {
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
		String signedid = (String) session.getAttribute("signedid");
		
		if(sPath.equals("/isOL.do")) {
			int gNum = Integer.parseInt(request.getParameter("gNum"));
			System.out.println("gNum"+gNum);
			BoardDAO dao = new BoardDAOimpl();
			System.out.println(dao.isOL(signedid, gNum));
			response.getWriter().append("{"+dao.isOL(signedid, gNum)+"}");
		} else if(sPath.equals("/isSameWriter.do")) {
			System.out.println(request.getParameter("id"));
			if(signedid.equals(request.getParameter("id"))) {
				response.getWriter().append("{t}");
			}else {
				response.getWriter().append("{f}");
			}
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
