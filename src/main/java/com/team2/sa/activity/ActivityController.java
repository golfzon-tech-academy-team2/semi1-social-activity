package com.team2.sa.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team2.sa.event.EventVO;
import com.team2.sa.gathering.model.GatheringVO;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.mypage.MyGatheringInherited;
import com.team2.sa.mypage.MypageDAO;
import com.team2.sa.mypage.MypageDAOimpl;
import com.team2.sa.notification.NotificationVO;
import com.team2.sa.signup.UserinfoVO;
import com.team2.sa.userinfo.member.UserInfoVO;

/**
 * Servlet implementation class ActivityController
 */
@WebServlet({"/createActivity.do", "/creActOK.do", "/activityInfo.do",
		"/a_searchList.do", "/a_searchListOK.do", "/deleteActivity.do", "/joinActivity.do", "/modifyActivity.do", "/modActOK.do",
		"/signOutActivity.do"})
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
		
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		
		//액티비티 생성
		if(sPath.equals("/createActivity.do")) {
			String gNum = request.getParameter("gNum");
			ActivityDAO dao = new ActivityDAOimpl();
			GatheringVO vo = dao.getGname(Integer.parseInt(gNum));
			System.out.println(vo);
			
			request.setAttribute("vo", vo);
			Date date = new Date(System.currentTimeMillis());
			
			request.setAttribute("today", date);
			
			int gatheringUserNum = dao.getGatheringUserNum(Integer.parseInt(gNum));
			
			request.setAttribute("gatheringUserNum", gatheringUserNum);
			
			request.getRequestDispatcher("activity/createActivity.jsp").forward(request, response);
		}
		//액티비티 상세정보
		else if(sPath.equals("/activityInfo.do")) {
			ActivityDAO dao = new ActivityDAOimpl();
			ActivityVO vo = dao.selectOne(Integer.parseInt(request.getParameter("aNum")));
			
			request.setAttribute("vo", vo);
			
			int checkActivity = dao.checkActivity(Integer.parseInt(request.getParameter("aNum")), (String) session.getAttribute("signedid"));
			
			request.setAttribute("checkActivity", checkActivity);
//			
			int checkLeader = dao.checkLeader(Integer.parseInt(request.getParameter("aNum")), (String) session.getAttribute("signedid"));
			
			request.setAttribute("checkLeader", checkLeader);
			
			Date date = new Date(System.currentTimeMillis());

			request.setAttribute("today", date);
			
			ActivityDAO eDao = new ActivityDAOimpl();
			List<EventVO> eventVos = eDao.selectAll(Integer.parseInt(request.getParameter("aNum")));
					
			request.setAttribute("vos", eventVos);
			
			List<UserInfoVO> memberVos = dao.activityMember(Integer.parseInt(request.getParameter("aNum")));
			
			request.setAttribute("activityMember", memberVos);
			
			request.getRequestDispatcher("activity/activityInfo.jsp").forward(request, response);
		} 
		//액티비티 검색
		else if (sPath.equals("/a_searchList.do")) {
			request.getRequestDispatcher("activity/a_searchList.jsp").forward(request, response);
		} else if (sPath.equals("/deleteActivity.do")) {
			ActivityDAO dao = new ActivityDAOimpl();
			dao.deleteActivity(Integer.parseInt(request.getParameter("aNum")));
			session.getAttribute("signedid");
			MypageDAO dao2 = new MypageDAOimpl();
			request.setAttribute("pw", dao2.pwcheck((String) session.getAttribute("signedid")));
			UserinfoVO vo = dao2.getMyInfo((String) session.getAttribute("signedid"));
			
			System.out.println(vo);
			request.setAttribute("vo", vo);

			List<MyGatheringInherited> vos = dao2.mygathering((String) session.getAttribute("signedid"));
			request.setAttribute("mygathering", vos);
			
			List<ActivityInhereted> vosAct = dao2.myactivity((String) session.getAttribute("signedid"));
			request.setAttribute("myactivity", vosAct);
			Date date = new Date(System.currentTimeMillis());
			
			request.setAttribute("today", date);
			request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
		}
		//액티비티 가입
		else if (sPath.equals("/joinActivity.do")) {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			ActivityDAO dao = new ActivityDAOimpl();
			int checkGathering = dao.checkGathering(Integer.parseInt(request.getParameter("aNum")), (String) session.getAttribute("signedid"));
			if (checkGathering == 0) {
				int gNum = dao.getGnum(Integer.parseInt(request.getParameter("aNum")));
				out.println("<script>");
				out.println("alert('모임에 먼저 가입해야합니다');");
				out.println("location='g_selectOne.do?gNum=" + gNum + "';");
				out.println("</script>");
				out.close();
			} else {
				int checkActivity = dao.checkActivity(Integer.parseInt(request.getParameter("aNum")), (String) session.getAttribute("signedid"));
				if (checkActivity == 0) { //가입 안되어있으면
					dao.signUpActivity(Integer.parseInt(request.getParameter("aNum")), (String) session.getAttribute("signedid"));
					out.println("<script>");
					out.println("alert('액티비티 가입을 완료하였습니다');");
					out.println("location='activityInfo.do?aNum=" + request.getParameter("aNum") + "';");
					out.println("</script>");
					out.close();
				}
			}
		}
		//액티비티 수정
		else if (sPath.equals("/modifyActivity.do")) {
			ActivityDAO dao = new ActivityDAOimpl();
			ActivityVO vo = dao.selectOne(Integer.parseInt(request.getParameter("aNum")));
			request.setAttribute("vo", vo);
			Date date = new Date(System.currentTimeMillis());

			request.setAttribute("today", date);
			
			int gatheringUserNum = dao.getGatheringUserNum(dao.getGnum(Integer.parseInt(request.getParameter("aNum"))));
			request.setAttribute("gatheringUserNum", gatheringUserNum);
			
			request.getRequestDispatcher("activity/modifyActivity.jsp").forward(request, response);
		}
		//액티비티 탈퇴
		else if (sPath.equals("/signOutActivity.do")) {
			Integer.parseInt(request.getParameter("aNum"));
			MypageDAO dao = new MypageDAOimpl();
			
			dao.signOutActivity(Integer.parseInt(request.getParameter("aNum")), (String) session.getAttribute("signedid"));
			
			UserinfoVO vo = dao.getMyInfo((String) session.getAttribute("signedid"));
			
			System.out.println(vo);
			request.setAttribute("vo", vo);

			List<MyGatheringInherited> vos = dao.mygathering((String) session.getAttribute("signedid"));
			request.setAttribute("mygathering", vos);
			
			List<ActivityInhereted> vosAct = dao.myactivity((String) session.getAttribute("signedid"));
			request.setAttribute("myactivity", vosAct);
			Date date = new Date(System.currentTimeMillis());

			request.setAttribute("today", date);
			
			request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		ActivityDAO dao = new ActivityDAOimpl();
		
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		
		//액티비티 생성 완료 후 데이터베이스에 저장
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

			System.out.println("hmm");
			dao.insert(vo, (String) session.getAttribute("signedid"));
			
			response.sendRedirect("gatheringinfo.do?gnum=" + request.getParameter("gNum"));
		}
		//액티비티 검색 후 동작
		else if(sPath.equals("/a_searchListOK.do")) {
			request.setCharacterEncoding("UTF-8");
			ActivityVO vo = new ActivityVO();
			vo.setSex((String) request.getParameter("sex"));
			vo.setLocation((String) request.getParameter("location"));
			vo.setMinAge(Integer.parseInt(request.getParameter("age")));
			
			List<ActivityVO> vos = dao.searchList(vo);
			Date date = new Date(System.currentTimeMillis());
			
			request.setAttribute("vos", vos);
			request.setAttribute("today", date);
			
			request.getRequestDispatcher("activity/a_searchListOK.jsp").forward(request, response);
		}
		//액티비티 수정 후 동작
		else if (sPath.equals("/modActOK.do")) {
			request.setCharacterEncoding("UTF-8");
			ActivityVO vo = new ActivityVO();
			vo.setaNum(Integer.parseInt(request.getParameter("aNum")));
			vo.setaName(request.getParameter("aName"));
			vo.setaContent(request.getParameter("aContent"));
			vo.setaStartDay(Date.valueOf(request.getParameter("aStartDay")));
			vo.setaEndDay(Date.valueOf(request.getParameter("aEndDay")));
			vo.setLocation(request.getParameter("location"));
			vo.setStartDate(Date.valueOf(request.getParameter("startDate")));
			vo.setEndDate(Date.valueOf(request.getParameter("endDate")));
			vo.setMinAge(Integer.parseInt(request.getParameter("minAge")));
			vo.setMaxAge(Integer.parseInt(request.getParameter("maxAge")));
			vo.setSex(request.getParameter("sex"));
			vo.setMaxPerson(Integer.parseInt(request.getParameter("maxPerson")));
			
			dao.update(vo);
			
			response.sendRedirect("activityInfo.do?aNum=" + request.getParameter("aNum"));
		}
	}

}
