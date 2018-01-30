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
 * Servlet implementation class BoardEditSevlet
 */
@WebServlet("/boarde.do")
public class BoardEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String no = request.getParameter("no");
			
			Board1VO vo = new Board1VO();
			vo.setNo(Integer.parseInt(no));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			vo = sqlsession.selectOne("Board1.selectBoardOne", vo);

			request.setAttribute("vo", vo);
			request.getRequestDispatcher("/WEB-INF/boarde.jsp").forward(request, response);
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
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String no = request.getParameter("no");
			String t = request.getParameter("title");
			String c = request.getParameter("content");
			String w = request.getParameter("writer");
			
			//vo객체 생성
			Board1VO vo = new Board1VO();
			vo.setNo(Integer.parseInt(no));
			vo.setTitle(t);
			vo.setContent(c);
			vo.setWriter(w);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			
			//DAO메소드 호출하기
			sqlsession.update("Board1.updateBoard", vo);
			sqlsession.commit();
			
			response.sendRedirect("boarde_ok.do");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
