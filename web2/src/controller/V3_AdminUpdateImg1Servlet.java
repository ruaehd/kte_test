package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_ProductVO;



/**
 * Servlet implementation class V3_Admin_Update_ImgServlet
 */
@WebServlet("/v3_admin_update_img1.do")
public class V3_AdminUpdateImg1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_AdminUpdateImg1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//enctype="multipart/form-data인지 확인
			if(ServletFileUpload.isMultipartContent(request)) {
				ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> fileitem = sfu.parseRequest(request);
				
				V3_ProductVO vo =new V3_ProductVO(); 
				for(FileItem tmp : fileitem) {
					//input type name="code"인 경우
					if(tmp.getFieldName().equals("code")) {
						vo.setCode(tmp.getString());
					}
					//input type name="file"인 경우
					else if(tmp.getFieldName().equals("file")) {
						if(tmp.get().length> 0) {
							vo.setImg(tmp.get());
						}
						else {
							vo.setImg(null);
						}
					}
					else if(tmp.getFieldName().equals("file1")) {
						if(tmp.get().length> 0) {
							vo.setImg1(tmp.get());
						}
						else {
							vo.setImg1(null);
						}
					}
					else if(tmp.getFieldName().equals("file2")) {
						if(tmp.get().length> 0) {
							vo.setImg2(tmp.get());
						}
						else {
							vo.setImg2(null);
						}
					}
					else if(tmp.getFieldName().equals("file3")) {
						if(tmp.get().length> 0) {
							vo.setImg3(tmp.get());
						}
						else {
							vo.setImg3(null);
						}
					}
					else if(tmp.getFieldName().equals("file4")) {
						if(tmp.get().length> 0) {
							vo.setImg4(tmp.get());
						}
						else {
							vo.setImg4(null);
						}
					}
					
				}
				SqlSession sqlsession = SqlMapClient.getSession();
				sqlsession.update("V3_Product.updateImg1", vo);
				sqlsession.commit();
			}
			
			response.sendRedirect("v3_admin.do?menu=1&smenu=2");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
