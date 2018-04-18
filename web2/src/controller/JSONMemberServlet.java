package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.Member1DAO;
import vo.Member1VO;

/**
 * Servlet implementation class JSONMemberServlet
 */
@WebServlet("/jsonmember.do")
public class JSONMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
			response.setHeader("Access-Control-Allow-Origin", "*");
		
			//html이 아닌 json문서
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
		
		
			String id = request.getParameter("id");
			
			Member1VO vo = new Member1VO();
			vo.setId(id);
			
			Member1DAO m1DAO = new Member1DAO();
			int ret = m1DAO.selectIDCheck(vo);
			
			//JSON라이브러리 사용
			JSONObject jobj = new JSONObject();
			//JSON문서로 만듬
			jobj.put("result", ret);
						
			//호출한 곳으로 결과값 json문서 리턴
			PrintWriter out = response.getWriter();
			out.print(jobj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
