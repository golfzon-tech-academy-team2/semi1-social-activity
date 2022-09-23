package com.team2.sa.gathering.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.gathering.model.GatheringVO;
import com.team2.sa.gathering.model.PubGatheringDAO;
import com.team2.sa.gathering.model.PubGatheringDAOimpl;

/**
 * Servlet implementation class SearchListGatheringController
 */
@WebServlet({"/g_searchList.do","/g_searchListOK.do"})
public class SearchListGatheringController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchListGatheringController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		if(sPath.equals("/g_searchList.do")) {
			request.getRequestDispatcher("gathering/searchList.jsp").forward(request, response);
		}else if(sPath.equals("/g_searchListOK.do")) {
			//logic
			PubGatheringDAO dao = new PubGatheringDAOimpl();
			String minAge = request.getParameter("minAge");
			String maxAge = request.getParameter("maxAge");
			String sex = request.getParameter("sex");
			
			List<GatheringVO> vos = dao.searchList(minAge, maxAge, sex);
			for(GatheringVO vo : vos) {
				System.out.println(vo);
			}
			request.setAttribute("vos",vos);
			request.getRequestDispatcher("gathering/selectAll.jsp").forward(request, response);
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
