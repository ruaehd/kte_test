package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import vo.V3_BoardqnaVO;


/**
 * Servlet implementation class V3_JSONUpload
 */
@WebServlet("/v3_json_upload.do")
public class V3_JSONUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_JSONUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/v3_upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		JSONObject jarr = new JSONObject();
		try {
			
			String saveDirectory = request.getSession().getServletContext().getRealPath("/");
			
			MultipartRequest multi = new MultipartRequest(
				request, 
				saveDirectory+File.separator+"upload",	//저장위치 
				1024*1024*10, 	//첨부파일 용량설정 10M
				"UTF-8", 	//한글
				new DefaultFileRenamePolicy()	//동일파일이 있으면 파일명 변경
			); 
			jarr.put("ret", "y");
		}
		catch(Exception e) {
			jarr.put("ret", "n");
			System.out.println(e.getMessage());
		}
		finally {
			PrintWriter out = response.getWriter();
			out.print(jarr.toString());
		}
	}

}
