package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_BoardqnaVO;
import vo.V3_SearchVO;

/**
 * Servlet implementation class V3_BoardQNAServlet
 */
@WebServlet("/v3_boardqna.do")
public class V3_BoardQNAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_BoardQNAServlet() {
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
			String page = request.getParameter("page");
			if(page==null) {
				page="1";
			}
			
			//검색과 페이지네이션을 위한 vo객체 생성
			V3_SearchVO vo = new V3_SearchVO();
			vo.setPage((Integer.parseInt(page)-1)*10);
			vo.setTxt(txt);
			

			SqlSession sqlsession = SqlMapClient.getSession();
			List<V3_BoardqnaVO> list = sqlsession.selectList("V3_Boardqna.selectBoardqnalist", vo);
			long tot = sqlsession.selectOne("V3_Boardqna.selectBoardqnaTot",vo);
			
			request.setAttribute("list", list);
			request.setAttribute("tot", (((tot-1)/10)+1));
			request.getRequestDispatcher("/WEB-INF/v3_boardqna.jsp").forward(request, response);
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
