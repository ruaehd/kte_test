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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] title = {"아이디 : ", "이름 : ", "출생년도 : ", "지역 : ", "휴대폰 국번 : ", "휴대폰 전화번호 : ", "신장 : "};
		request.setAttribute("title", title);
		
		request.getRequestDispatcher("/WEB-INF/exam/insert.jsp").forward(request, response);
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
			
			/*String[] name = request.getParameterValues("name[]");
			MemberVO vo = new MemberVO();
			vo.setUserID(name[0]);
			vo.setName(name[1]);
			vo.setBirthYear(Integer.parseInt(name[2]));
			vo.setAddr(name[3]);
			vo.setMobile1(name[4]);
			vo.setMobile2(name[5]);
			vo.setHeight(Integer.parseInt(name[6]));*/
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("Exam.insertMember", vo);
			sqlsession.commit();
			
			response.sendRedirect("main.do");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
