package exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import examvo.MemberVO;
import session.SqlMapClient;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			String id = request.getParameter("userID");
			
			MemberVO vo = new MemberVO();
			vo.setUserID(id);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			vo = sqlsession.selectOne("Exam.selectMemberOne", vo);
			
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("/WEB-INF/exam/update.jsp").forward(request, response);
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
			
			String id = request.getParameter("id");
			String na = request.getParameter("name");
			String bi = request.getParameter("birth");
			String ad = request.getParameter("addr");
			String t1 = request.getParameter("tel1");
			String t2 = request.getParameter("tel2");
			String he = request.getParameter("height");
			
			MemberVO vo = new MemberVO(id, na, Integer.parseInt(bi), ad, t1, t2, Integer.parseInt(he));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.update("Exam.updateMember", vo);
			sqlsession.commit();
			
			response.sendRedirect("main.do");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
