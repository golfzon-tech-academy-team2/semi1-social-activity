package com.team2.sa.condition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.condition.model.ConditionDAO;
import com.team2.sa.condition.model.ConditionDAOimpl;

/**
 * Servlet implementation class ConditionController
 */
@WebServlet({ "/checkCondition.do" })
public class ConditionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		if(sPath.equals("/checkCondition.do")) {
			String gSex = request.getParameter("sex");
			int gMinAge = Integer.parseInt(request.getParameter("minAge"));
			int gMaxAge = Integer.parseInt(request.getParameter("maxAge"));
			HttpSession session = request.getSession();
			String signedid = (String) session.getAttribute("signedid");
			ConditionDAO dao = new ConditionDAOimpl();
			String sex = dao.findSex(signedid);
			int age = dao.findAge(signedid);
			if(gSex.equals("X")) {
				if(gMinAge<=age && age<=gMaxAge) {
					response.getWriter().append("{"+1+"}");
				}else {
					response.getWriter().append("{"+0+"}");
				}
			}else {
				if(gMinAge<=age && age<=gMaxAge && gSex.equals(sex)) {
					response.getWriter().append("{"+1+"}");
				}else {
					response.getWriter().append("{"+0+"}");
				}
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
