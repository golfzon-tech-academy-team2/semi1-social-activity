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
 * Servlet implementation class SelectAllGatheringController
 */
@WebServlet("/g_selectAll.do")
public class SelectAllGatheringController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllGatheringController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		if (sPath.equals("/g_selectAll.do")) {
			PubGatheringDAO dao = new PubGatheringDAOimpl();
			List<GatheringVO> vos = dao.selectAll();
			System.out.println("student vos.size() :"+vos.size());
			for(GatheringVO vo : vos ) {
				System.out.println(vo.getgName());
			}
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("gathering/selectAll.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
