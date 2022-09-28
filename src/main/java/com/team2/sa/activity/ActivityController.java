package com.team2.sa.activity;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.event.EventDAO;
import com.team2.sa.event.EventDAOimpl;
import com.team2.sa.event.EventVO;
import com.team2.sa.gathering.model.GatheringVO;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet({"/createActivity.do", "/creActOK.do", "/activityInfo.do"})
public class ActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		
		if(sPath.equals("/createActivity.do")) {
			String gNum = request.getParameter("gNum");
			ActivityDAO dao = new ActivityDAOimpl();
			GatheringVO vo = dao.getGname(Integer.parseInt(gNum));
			System.out.println(vo);
			
			request.setAttribute("vo", vo);
			Date date = new Date(System.currentTimeMillis());

			request.setAttribute("today", date);
			
			request.getRequestDispatcher("activity/createActivity.jsp").forward(request, response);
		} else if(sPath.equals("/activityInfo.do")) {
			ActivityDAO dao = new ActivityDAOimpl();
			ActivityVO vo = dao.selectOne(Integer.parseInt(request.getParameter("aNum")));
			
			request.setAttribute("vo", vo);
			Date date = new Date(System.currentTimeMillis());

			request.setAttribute("today", date);
			
			ActivityDAO eDao = new ActivityDAOimpl();
			List<EventVO> eventVos = eDao.selectAll(Integer.parseInt(request.getParameter("aNum")));
					
			request.setAttribute("vos", eventVos);
			
			request.getRequestDispatcher("activity/activityInfo.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		ActivityDAO dao = new ActivityDAOimpl();
		
		if(sPath.equals("/creActOK.do")) {
			request.setCharacterEncoding("UTF-8");
			ActivityInhereted vo = new ActivityInhereted();
			
			vo.setgNum(Integer.parseInt(request.getParameter("gNum")));
			vo.setaName(request.getParameter("aName"));
			vo.setaContent(request.getParameter("aContent"));
			vo.setaStartDay(Date.valueOf(request.getParameter("aStartDay")));
			vo.setaEndDay(Date.valueOf(request.getParameter("aEndDay")));
			vo.setLocation(request.getParameter("location"));
			vo.setStartDate(Date.valueOf(request.getParameter("startDate")));
			vo.setEndDate(Date.valueOf(request.getParameter("endDate")));
			vo.setMinAge(Integer.parseInt(request.getParameter("minAge")));
			vo.setMaxAge(Integer.parseInt(request.getParameter("maxAge")));
			if (request.getParameter("sex").equals("남자")) {
				vo.setSex("M");
			} else if (request.getParameter("sex").equals("여자")) {
				vo.setSex("F");
			} else if (request.getParameter("sex").equals("상관없음")) {
				vo.setSex("X");
			}
			vo.setMaxPerson(Integer.parseInt(request.getParameter("maxPerson")));

			HttpSession session = request.getSession();
			dao.insert(vo, (String) session.getAttribute("signedid"));
			
			response.sendRedirect("gatheringinfo.do?gnum=" + request.getParameter("gNum"));
		}
	}

}
