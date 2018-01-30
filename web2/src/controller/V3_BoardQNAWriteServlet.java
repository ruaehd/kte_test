package controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_BoardqnaVO;

/**
 * Servlet implementation class V3_BoardQNAWriteServlet
 */
@WebServlet("/v3_boardqnawrite.do")
public class V3_BoardQNAWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_BoardQNAWriteServlet() {
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
			V3_BoardqnaVO vo = sqlsession.selectOne("V3_Boardqna.selectBoardqnaLastNo");
			
			request.setAttribute("lastno", vo.getNo());
			request.getRequestDispatcher("/WEB-INF/v3_boardqnawrite.jsp").forward(request, response);
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
			String writer = request.getParameter("writer");
			String pw = request.getParameter("pw");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			V3_BoardqnaVO vo = new V3_BoardqnaVO();
			vo.setNo(new BigInteger(no));
			vo.setWriter(writer);
			vo.setPassword(pw);
			vo.setTitle(title);
			vo.setContent(content);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("V3_Boardqna.insertBoardqna", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_boardqna.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
