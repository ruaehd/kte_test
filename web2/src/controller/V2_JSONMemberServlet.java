package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import dao.Member1DAO;
import session.SqlMapClient;
import vo.Member1VO;
import vo.V2_CustomVO;

/**
 * Servlet implementation class JSONMemberServlet
 */
@WebServlet("/v2_jsonmember.do")
public class V2_JSONMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_JSONMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int cnt = 0;
			try {
				response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
				response.setHeader("Access-Control-Max-Age", "3600");
				response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
				response.setHeader("Access-Control-Allow-Origin", "*");
			
				//html이 아닌 json문서
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
			
			
				String id = request.getParameter("id");
				
				V2_CustomVO vo = new V2_CustomVO();
				vo.setId(id);
				
				SqlSession sqlsession = SqlMapClient.getSession();
				cnt = sqlsession.selectOne("selectIDCheck", vo);

			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				cnt = -1;
			}
			finally {
				//JSON 객체 생성
				JSONObject jobj = new JSONObject();
				//전달할 값을 넣음
				jobj.put("result", cnt);
							
				//전달하기 위한 객체 생성
				PrintWriter out = response.getWriter();
				//jodj를 String으로 변환 후 전달
				out.print(jobj.toString());
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
