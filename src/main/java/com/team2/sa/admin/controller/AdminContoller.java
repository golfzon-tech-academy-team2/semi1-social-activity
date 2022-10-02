package com.team2.sa.admin.controller;

import java.io.File;
import java.io.IOException;
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
			System.out.println(Integer.parseInt(request.getParameter("gNum")));
			PubGatheringDAO dao = new PubGatheringDAOimpl();
			GatheringUserInfoVO vo = new GatheringUserInfoVO();
			vo = dao.selectOne(Integer.parseInt(request.getParameter("gNum")));
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("admin/update.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPath = request.getServletPath();
		if(sPath.equals("/ad_updateOK.do")) {
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

						if (item.isFormField()) { // name,age 받기
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

						} else {// upFile받기

							System.out.println("파일의 키 : " + item.getFieldName());
							System.out.println("파일 파일명 : " + item.getName());
							System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
							System.out.println("파일 사이즈  : " + item.getSize());

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
			GatheringUserInfoVO vo = new GatheringUserInfoVO();
			AdminDAOimpl dao = new AdminDAOimpl();
			vo.setgNum(Integer.parseInt(request.getParameter("gNum")));
			vo.setgName(gName);
			vo.setgContent(gContent);
			vo.setLogo(logo);
			vo.setMaxAge(Integer.parseInt(maxAge));
			vo.setMinAge(Integer.parseInt(minAge));
			vo.setSex(sex);
			vo.setPermission(permission);
			vo.setLink("");
			if(dao.update(vo)==1) {
				System.out.println("success");
//				response.sendRedirect("gatheringinfo.do?gnum="+gNum);
			}else {
//				response.sendRedirect("gatheringinfo.do?gnum="+gNum);
			}
			
		}
	}
	}
}
