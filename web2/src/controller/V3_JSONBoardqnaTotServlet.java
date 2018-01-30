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
import org.json.JSONObject;

import session.SqlMapClient;
import vo.V3_BoardqnaVO;
import vo.V3_SearchVO;

/**
 * Servlet implementation class V3_JSONBoardqnaTotServlet
 */
@WebServlet("/v3_json_boardqnatot.do")
public class V3_JSONBoardqnaTotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_JSONBoardqnaTotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String txt = request.getParameter("txt");
			if(txt==null) {
				txt="";
			}

			V3_SearchVO vo = new V3_SearchVO();
			vo.setTxt(txt);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			
			long tot = sqlsession.selectOne("V3_Boardqna.selectBoardqnaTot",vo);
			JSONObject jobj = new JSONObject();
			jobj.put("tot", (((tot-1)/10)+1));
			
			PrintWriter out = response.getWriter();
			out.print(jobj.toString());
			
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
