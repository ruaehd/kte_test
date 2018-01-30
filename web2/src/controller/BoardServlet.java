package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.Board1VO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board.do")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		try {
			//SqlMapClient에서 객체 가져오기
			SqlSession sqlsession = SqlMapClient.getSession();
			
			List<Board1VO> list = sqlsession.selectList("Board1.selectBoardList");			
			sqlsession.commit();
			
			int tot = sqlsession.selectOne("getBoardTotal");
			request.setAttribute("tot", (tot-1)/10+1);

			//세션에 객체 얻기
			HttpSession httpSession = request.getSession();
			//세션에 숫자 1을 넣음
			httpSession.setAttribute("_hit", 1);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/board.jsp").forward(request, response);
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
