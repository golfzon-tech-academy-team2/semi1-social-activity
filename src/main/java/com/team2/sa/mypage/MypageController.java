package com.team2.sa.mypage;

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

import com.team2.sa.activity.ActivityInhereted;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;
import com.team2.sa.signup.UserinfoVO;

/**
 * Servlet implementation class MypageController
 */
@WebServlet({"/pw_check.do", "/mypage.do", 
	"/mod_name.do", "/mod_pw.do", "/mod_addr.do", "/mod_tel.do",
	"/mod_nameOK.do", "/mod_pwOK.do", "/mod_addrOK.do", "/mod_telOK.do", "/signout.do",
	})
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
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
		
		//비밀번호 확인 페이지
		if (sPath.equals("/pw_check.do")) {
			request.getRequestDispatcher("mypage/pw_check.jsp").forward(request, response);
		}
		//마이페이지 이름 수정
		else if (sPath.equals("/mod_name.do")) {
			request.getRequestDispatcher("mypage/mod_name.jsp").forward(request, response);
		}
		//마이페이지 비밀번호 수정
		else if (sPath.equals("/mod_pw.do")) {
			request.getRequestDispatcher("mypage/mod_pw.jsp").forward(request, response);
		}
		//마이페이지 주소 수정
		else if (sPath.equals("/mod_addr.do")) {
			request.getRequestDispatcher("mypage/mod_addr.jsp").forward(request, response);
		}
		//마이페이지 전화번호 수정
		else if (sPath.equals("/mod_tel.do")) {
			request.getRequestDispatcher("mypage/mod_tel.jsp").forward(request, response);
		}
		//마이페이지 회원 탈퇴
		else if (sPath.equals("/signout.do")) {
			MypageDAO dao = new MypageDAOimpl();
			dao.signout((String) session.getAttribute("signedid"));
			session.removeAttribute("signedid");
			response.sendRedirect("index.do");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println(sPath);
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		MypageDAO dao = new MypageDAOimpl();
		//마이페이지 화면 이동
		if (sPath.equals("/mypage.do")) {
			String result = dao.pwcheck((String) session.getAttribute("signedid"));
			System.out.println(result);
			
			if (result.equals(request.getParameter("pw"))) {
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
				
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 틀렸습니다');");
				out.println("location='pw_check.do';");
				out.println("</script>");
				out.close();
				
			}
		}
		//이름 수정 후
		else if (sPath.equals("/mod_nameOK.do")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			dao.modname((String) session.getAttribute("signedid"), request.getParameter("uname"));
			out.println("<script>");
			out.println("alert('이름 정보가 수정되었습니다');");
			out.println("location='index.do';");
			out.println("</script>");
			out.close();
		}
		//비밀번호 수정 후
		else if (sPath.equals("/mod_pwOK.do")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			dao.modpw((String) session.getAttribute("signedid"), request.getParameter("pw"));
			out.println("<script>");
			out.println("alert('비밀번호 정보가 수정되었습니다');");
			out.println("location='index.do';");
			out.println("</script>");
			out.close();
		}
		//비밀번호 수정 후
		else if (sPath.equals("/mod_addrOK.do")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			dao.modaddr((String) session.getAttribute("signedid"), request.getParameter("addr"));
			out.println("<script>");
			out.println("alert('주소 정보가 수정되었습니다');");
			out.println("location='index.do';");
			out.println("</script>");
			out.close();
		}
		//전화번호 수정 후
		else if (sPath.equals("/mod_telOK.do")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			dao.modtel((String) session.getAttribute("signedid"), request.getParameter("tel"));
			out.println("<script>");
			out.println("alert('전화번호 정보가 수정되었습니다');");
			out.println("location='index.do';");
			out.println("</script>");
			out.close();
		}
	}

}
