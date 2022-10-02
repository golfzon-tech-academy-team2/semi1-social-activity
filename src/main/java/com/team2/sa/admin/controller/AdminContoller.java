package com.team2.sa.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.admin.model.AdminDAO;
import com.team2.sa.admin.model.AdminDAOimpl;
import com.team2.sa.gathering.model.GatheringUserInfo;
import com.team2.sa.gathering.model.GatheringUserInfoVO;
import com.team2.sa.gathering.model.PubGatheringDAO;
import com.team2.sa.gathering.model.PubGatheringDAOimpl;

/**
 * Servlet implementation class AdminContoller
 */
@WebServlet({ "/admin.do","/ad_selectAll.do", "/ad_selectOne.do", "/ad_delete.do", "/ad_deleteOK.do", "/ad_update.do", "/ad_updateOK.do" })
public class AdminContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		HttpSession session = request.getSession();
		String signedid = (String) session.getAttribute("signedid");
		if(sPath.equals("/admin.do")) {
			GatheringUserInfoVO vo = new GatheringUserInfoVO();
			AdminDAO dao = new AdminDAOimpl();
			int uNum = dao.searchUnum(signedid);
			List<GatheringUserInfoVO> vos = dao.selectAllGathering(uNum);
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
		}else if(sPath.equals("/ad_selectOne.do")) {
			System.out.println(Integer.parseInt(request.getParameter("gNum")));
			PubGatheringDAO dao = new PubGatheringDAOimpl();
			GatheringUserInfoVO vo = new GatheringUserInfoVO();
			vo = dao.selectOne(Integer.parseInt(request.getParameter("gNum")));
			System.out.println(vo.getgContent());
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("admin/selectOne.jsp").forward(request, response);
		}else if(sPath.equals("/ad_update.do")) {
			request.getRequestDispatcher("admin/update.jsp").forward(request, response);
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
