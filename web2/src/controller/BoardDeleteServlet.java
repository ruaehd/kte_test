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
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/boardd.do")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
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
			
			SqlSession sqlsession= SqlMapClient.getSession();
			int ret = sqlsession.delete("Board1.deleteBoardOne", vo);
			sqlsession.commit();
			
			if(ret ==1) {
				request.getRequestDispatcher("/WEB-INF/boardd_ok.jsp").forward(request, response);
			}
			
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
		
	}

}
