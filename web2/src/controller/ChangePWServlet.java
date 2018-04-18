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
 * Servlet implementation class ChangePWServlet
 */
@WebServlet("/changepw.do")
public class ChangePWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePWServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/changepw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("_id");
		
		String pw = request.getParameter("pw");
		String pw1 = request.getParameter("pw1");
		
		
		Member1VO vo = new Member1VO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setPw1(pw1);
		
		Member1DAO m1DAO = new Member1DAO();
		
		//2. insertMember메소드 호출
		int ret = m1DAO.updateMemberPW(vo);
		if(ret==1) {
			response.sendRedirect("index.do");
		}
		else {
			response.sendRedirect("changepw.do");
		}
		
		
		//3. index.do 페이지 이동
		
	}

}
