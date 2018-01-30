package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_MemberVO;

/**
 * Servlet implementation class V3_LoginServlet
 */
@WebServlet("/v3_login.do")
public class V3_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/v3_login.jsp").forward(request, response);
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
			String pw = request.getParameter("pw");
			
			V3_MemberVO vo = new V3_MemberVO();
			vo.setNo(no);
			vo.setPw(pw);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			V3_MemberVO rvo = sqlsession.selectOne("V3_Member.selectLogin", vo);
			HttpSession httpsession = request.getSession();
			
			if(rvo != null) {
				
				httpsession.setAttribute("_no", rvo.getNo());
				httpsession.setAttribute("_name", rvo.getName());
				
				String url = (String) httpsession.getAttribute("_url");
				response.sendRedirect(url);
				
			}
			else if (rvo == null) {
				response.sendRedirect("v3_login.do");
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
