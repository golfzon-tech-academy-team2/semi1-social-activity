package com.team2.sa.vote.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team2.sa.vote.model.VoteDAO;
import com.team2.sa.vote.model.VoteDAOimpl;
import com.team2.sa.vote.model.VoteVO;

/**
 * Servlet implementation class VoteController
 */
@WebServlet({ "/v_insert.do", "/v_insertOK.do","/v_selectOne.do", "/v_updateOK.do","/v_result.do" })
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		if (sPath.equals("/v_insert.do")) {
			request.getRequestDispatcher("vote/insert.jsp").forward(request, response);
		}else if(sPath.equals("/v_selectOne.do")) {
			VoteVO vo = new VoteVO();
			VoteDAO dao = new VoteDAOimpl();
			vo = dao.selectOne(Integer.parseInt(request.getParameter("vNum")));
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("vote/selectOne.jsp").forward(request, response);
		}else if(sPath.equals("/v_result.do")) {
			VoteVO vo = new VoteVO();
			VoteDAO dao = new VoteDAOimpl();
			vo = dao.selectOne(Integer.parseInt(request.getParameter("vNum")));
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("vote/result.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		System.out.println(sPath);
		request.setCharacterEncoding("UTF-8");
		if (sPath.equals("/v_insertOK.do")) {
			VoteVO vo = new VoteVO();
			vo.setgNum(Integer.parseInt(request.getParameter("gNum")));
			vo.setStartDate(Date.valueOf(request.getParameter("startDate")));
			vo.setEndDate(Date.valueOf(request.getParameter("endDate")));
			vo.setvList1(request.getParameter("vList1"));
			vo.setvList2(request.getParameter("vList2"));
			vo.setvList3(request.getParameter("vList3"));
			vo.setvTitle(request.getParameter("vTitle"));
			VoteDAO dao = new VoteDAOimpl();
			if (dao.insert(vo) == 1) {
				response.sendRedirect("gatheringinfo.do?gnum=" + request.getParameter("gNum"));
			} else {
				request.getRequestDispatcher("vote/insert.jsp").forward(request, response);
			}
		}else if(sPath.equals("/v_updateOK.do")) {
			
			VoteDAO dao = new VoteDAOimpl();
			if(dao.update(request.getParameter("vList"), Integer.parseInt(request.getParameter("vNum")))==1) {
				System.out.println("투표 완료");
				response.sendRedirect("v_result.do?vNum="+request.getParameter("vNum")+"&gNum="+request.getParameter("gNum"));
			}else {
				response.sendRedirect("v_updateOK.do?vNum="+request.getParameter("vNum"));
			}
		}
	}
}
