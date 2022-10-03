package com.team2.sa.album.controller;

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

import com.team2.sa.album.model.AlbumDAO;
import com.team2.sa.album.model.AlbumDAOimpl;
import com.team2.sa.album.model.AlbumVO;

/**
 * Servlet implementation class AlbumController
 */
@WebServlet({ "/ab_selectOne.do", "/ab_selectAll.do", "/ab_insert.do", "/ab_insertOK.do", "/ab_delete.do", "/ab_deleteOK.do" })
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlbumController() {
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
		if (sPath.equals("/ab_insert.do")) {
			System.out.println(request.getParameter("gNum"));
			request.getRequestDispatcher("album/insert.jsp").forward(request, response);
		}if (sPath.equals("/ab_selectAll.do")) {
			int gNum = Integer.parseInt(request.getParameter("gNum"));
			AlbumDAO dao = new AlbumDAOimpl();
			List<AlbumVO> vos = dao.selectAll(gNum);
			request.setAttribute("vos", vos);
			request.getRequestDispatcher("album/selectAll.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String sPath = request.getServletPath();
		if (sPath.equals("/ab_insertOK.do")) {
			String dir_path = request.getServletContext().getRealPath("/gallery");
			System.out.println(dir_path);
			int fileSizeMax = 1024 * 1024 * 1024;
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if (isMultipartContent) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(fileSizeMax);
				ServletFileUpload sfu = new ServletFileUpload(factory);
				sfu.setFileSizeMax(fileSizeMax);

				String gNum = "";
				String fileName = "";
				String uNum = "";
				String uName = "";
				String type = "";
				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						System.out.println(item);
					}
					for (FileItem item : items) {

						if (item.isFormField()) {

						} else {// upFile받기

							System.out.println("파일의 키 : " + item.getFieldName());
							System.out.println("파일 파일명 : " + item.getName());
							System.out.println("파일 컨텐츠 타입 : " + item.getContentType());
							System.out.println("파일 사이즈  : " + item.getSize());
							if(item.getContentType().equals("video/mp4")) {
								type = "video";
							}else {
								type = "image";
							}
							fileName = FilenameUtils.getName(item.getName());

							File saveFile = new File(dir_path, fileName);

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
				AlbumDAO dao = new AlbumDAOimpl();
				AlbumVO vo = new AlbumVO();

				HttpSession session = request.getSession();
				String signedid = (String) session.getAttribute("signedid");
				vo.setFileName(fileName);
				vo.setgNum(Integer.parseInt(request.getParameter("gNum")));
				vo.setuName(dao.findName(signedid));
				vo.setuNum(dao.findUnum(signedid));
				vo.setType(type);
				if (dao.insert(vo) == 1) {
					System.out.println("됨");
					response.sendRedirect("ab_selectAll.do?gNum="+request.getParameter("gNum"));
				} else {
					System.out.println("안됨");
					response.sendRedirect("ab_insert.do?gNum="+request.getParameter("gNum"));
				}

			}
		}
	}
}