package com.team2.sa.gathering.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.team2.sa.gathering.model.GatheringUserInfoDAO;
import com.team2.sa.gathering.model.GatheringUserInfoDAOimpl;
import com.team2.sa.gathering.model.GatheringVO;
import com.team2.sa.gathering.model.PriGatheringDAO;
import com.team2.sa.gathering.model.PriGatheringDAOimpl;
import com.team2.sa.gathering.model.PubGatheringDAO;
import com.team2.sa.gathering.model.PubGatheringDAOimpl;
import com.team2.sa.login.SigninDAO;
import com.team2.sa.login.SigninDAOimpl;
import com.team2.sa.notification.NotificationVO;

/**
 * Servlet implementation class InsertGatheringController
 */
@WebServlet({ "/create_gathering.do", "/insert_pubGathering.do", "/insert_priGathering.do", "/insert_pubGOK.do",
		"/insert_priGOK.do" })
public class InsertGatheringController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertGatheringController() {
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
		// add restrict access
		HttpSession session = request.getSession();
		SigninDAO signDAO = new SigninDAOimpl();
		List<NotificationVO> notificationVos = signDAO.getAlerts((String) session.getAttribute("signedid"));
		session.setAttribute("notificationVos", notificationVos);
		String signedid = (String) session.getAttribute("signedid");
		if (signedid != null) {
			if (sPath.equals("/create_gathering.do")) {// ????????????????????? ?????? ???????????? ???????????? ????????? ?????? ??????
				request.getRequestDispatcher("gathering/pubInsert.jsp").forward(request, response);
			} else if (sPath.equals("/insert_pubGathering.do")) {// ????????? ?????? ?????? ?????? ????????? ????????? ?????? ??????
				System.out.println("?????????");
				request.getRequestDispatcher("gathering/pubInsert.jsp").forward(request, response);
			} else if (sPath.equals("/insert_priGathering.do")) {// ???????????? ?????? ?????? ?????? ????????? ???????????? ?????? ??????
				System.out.println("????????????");
				request.getRequestDispatcher("gathering/priInsert.jsp").forward(request, response);
			}

		} else {
			response.sendRedirect("login.do");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("post:...");
		System.out.println(sPath);
		//????????? ?????? ?????? ??? ??????
		if (sPath.equals("/insert_pubGOK.do")) {
			String dir_path = request.getServletContext().getRealPath("/gEmblem");
			System.out.println(dir_path);
			int fileSizeMax = 1024 * 1024 * 100;
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if (isMultipartContent) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);

				String gName = "";
				String gContent = "";
				String logo = "";
				String minAge = "";
				String maxAge = "";
				String sex = "";
				String permission = "";
				String isPublic = "";
				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						System.out.println(item);
					}
					for (FileItem item : items) {

						if (item.isFormField()) { // name,age ??????
							if (item.getFieldName().equals("gName")) {
								gName = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("gContent")) {
								gContent = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("minAge")) {
								minAge = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("maxAge")) {
								maxAge = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("sex")) {
								sex = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("permission")) {
								permission = item.getString("UTF-8");
							}

						} else {// upFile??????

							System.out.println("????????? ??? : " + item.getFieldName());
							System.out.println("?????? ????????? : " + item.getName());
							System.out.println("?????? ????????? ?????? : " + item.getContentType());
							System.out.println("?????? ?????????  : " + item.getSize());

							logo = FilenameUtils.getName(item.getName());

							File saveFile = new File(dir_path, logo);

							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				PubGatheringDAO dao = new PubGatheringDAOimpl();
				GatheringVO vo = new GatheringVO();
				vo.setgName(gName);
				vo.setgContent(gContent);
				vo.setLogo(logo);
				vo.setMaxAge(Integer.parseInt(maxAge));
				vo.setMinAge(Integer.parseInt(minAge));
				vo.setSex(sex);
				vo.setPermission(permission);
				vo.setLink("");
				vo.setIsPublic("T");

				GatheringUserInfoDAO dao2 = new GatheringUserInfoDAOimpl();
				HttpSession session = request.getSession();
				String signedid = (String) session.getAttribute("signedid");
				if (dao.insert(vo) == 1) {
//			  			response.sendRedirect("s_selectAll_join.do");
					System.out.println("success");
					int gnum = dao2.getGnum();
					System.out.println("2?????? ??????~"+gnum);
					if(dao2.insert(gnum, "O", signedid)==1) {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter writer = response.getWriter();
						writer.println("<script>alert('????????? ?????????????????????.');location.href='g_selectAll.do';</script>");
						writer.close();
						// response.sendRedirect("g_selectAll.do");
					}else {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter writer = response.getWriter();
						writer.println("<script>alert('?????? ????????? ?????????????????????.');</script>");
						writer.close();
					}
					

				} else {
					System.out.println("??????");
					response.sendRedirect("insert_pubGathering.do");
				}

			}
		}
		//???????????? ?????? ?????? ??? ??????
		else if (sPath.equals("/insert_priGOK.do")) {
			String dir_path = request.getServletContext().getRealPath("/gEmblem");
			System.out.println(dir_path);
			int fileSizeMax = 1024 * 1024 * 100;
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if (isMultipartContent) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);

				String gName = "";
				String gContent = "";
				String logo = "";
				String minAge = "";
				String maxAge = "";
				String sex = "";
				String permission = "";
				String isPublic = "";
				String link = "";
				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						System.out.println(item);
					}
					for (FileItem item : items) {

						if (item.isFormField()) { // name,age ??????
							if (item.getFieldName().equals("gName")) {
								gName = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("gContent")) {
								gContent = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("minAge")) {
								minAge = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("maxAge")) {
								maxAge = item.getString("UTF-8");
							}
							if (item.getFieldName().equals("sex")) {
								sex = item.getString("UTF-8");
							}
//							if (item.getFieldName().equals("link")) {
//								link = item.getString("UTF-8");
//							}

						} else {// upFile??????

							System.out.println("????????? ??? : " + item.getFieldName());
							System.out.println("?????? ????????? : " + item.getName());
							System.out.println("?????? ????????? ?????? : " + item.getContentType());
							System.out.println("?????? ?????????  : " + item.getSize());

							logo = FilenameUtils.getName(item.getName());

							File saveFile = new File(dir_path, logo);

							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				PriGatheringDAO dao = new PriGatheringDAOimpl();
				GatheringVO vo = new GatheringVO();
				vo.setgName(gName);
				vo.setgContent(gContent);
				vo.setLogo(logo);
				vo.setMaxAge(Integer.parseInt(maxAge));
				vo.setMinAge(Integer.parseInt(minAge));
				vo.setSex(sex);
				vo.setPermission("");
				vo.setLink("");
				vo.setIsPublic("F");
				GatheringUserInfoDAO dao2 = new GatheringUserInfoDAOimpl();
				HttpSession session = request.getSession();
				String signedid = (String) session.getAttribute("signedid");
				if (dao.insert(vo) == 1) {
					System.out.println("success");
					int gnum = dao2.getGnum();
					dao2.insert(gnum, "O", signedid);
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('????????? ????????? ?????????????????????.');location.href='index.do';</script>");
					writer.close();
				} else {
					System.out.println("??????");
					response.sendRedirect("insert_priGathering.do");

				}

			}
		}

	}

}
