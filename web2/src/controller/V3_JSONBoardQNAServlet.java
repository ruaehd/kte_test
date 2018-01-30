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
import vo.V3_SearchVO;

/**
 * Servlet implementation class V3_JSONBoardServlet
 */
@WebServlet("/v3_json_boardqna.do")
public class V3_JSONBoardQNAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_JSONBoardQNAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String page = request.getParameter("page");
			String txt = request.getParameter("txt");
			
			if(page==null) page="1";
			if(txt==null) txt="";
			
			V3_SearchVO vo = new V3_SearchVO();
			vo.setPage((Integer.parseInt(page)-1)*10);
			vo.setTxt(txt);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V3_BoardqnaVO> list = sqlsession.selectList("V3_Boardqna.selectBoardqnalist", vo);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			
			JSONArray jarr = new JSONArray(); 
			for(V3_BoardqnaVO tmp : list) {
				//{"no":1, "title":"제목", "writer":"작성자", "hit":1, "date1":2018-01-01}
				JSONObject jobj = new JSONObject();
				jobj.put("no", tmp.getNo());
				jobj.put("title", tmp.getTitle());
				jobj.put("writer", tmp.getWriter());
				jobj.put("hit", tmp.getHit());
				jobj.put("date1", tmp.getDate1());
				
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
