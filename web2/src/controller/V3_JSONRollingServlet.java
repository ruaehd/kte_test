package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;

import session.SqlMapClient;
import vo.V3_BoardqnaVO;

/**
 * Servlet implementation class V3_JSONRollingServlet
 */
@WebServlet("/v3_json_rolling.do")
public class V3_JSONRollingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_JSONRollingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V3_BoardqnaVO> list = sqlsession.selectList("V3_Boardqna.selectHitTop");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			
			JSONArray jarr = new JSONArray(); 
			for(V3_BoardqnaVO tmp : list) {
				JSONObject jobj = new JSONObject();
				jobj.put("title", tmp.getTitle());
				jarr.put(jobj);	//[{},{},{}]
			}
			PrintWriter out = response.getWriter();
			out.print(jarr.toString());
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
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
