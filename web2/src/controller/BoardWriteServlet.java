package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.Board1VO;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/boardw.do")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/boardw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String t = request.getParameter("title");
			String c = request.getParameter("content");
			String w = request.getParameter("writer");
			
			//SqlMapClient에서 객체 가져오기
			SqlSession sqlsession = SqlMapClient.getSession();
			
			//vo객체 생성
			Board1VO vo = new Board1VO();
			vo.setTitle(t);
			vo.setContent(c);
			vo.setWriter(w);
			
			//DAO메소드 호출하기
			int ret = sqlsession.insert("Board1.insertBoard", vo);
			sqlsession.commit();
			
			response.sendRedirect("board.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
