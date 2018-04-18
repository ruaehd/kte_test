package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Member1DAO;
import vo.Member1VO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			//한글
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			//jsp에서 값을 받음
			String a = request.getParameter("id");
			String b = request.getParameter("pw");
			
			//vo생성 + setId, setPw를 동시에 수행
			Member1VO vo = new Member1VO(a,b); 
			
			//dao 객체 생성
			Member1DAO m1DAO = new Member1DAO();
			Member1VO rvo = m1DAO.selectMember(vo);
			
			if(rvo!=null) { //로그인 성공
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("_id", rvo.getId());
				httpsession.setAttribute("_name", rvo.getName());
				httpsession.setAttribute("_grade", rvo.getGrade());
				
				response.sendRedirect("index.do");
				
			}
			else {	//로그인 실패
								
				response.sendRedirect("login.do");
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
