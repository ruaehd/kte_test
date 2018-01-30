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
 * Servlet implementation class PasswordCheckServlet
 */
@WebServlet("/pwcheck.do")
public class PWCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PWCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/pwcheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated me
		
		try {
			
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			HttpSession httpSession = request.getSession();
			String id = (String)httpSession.getAttribute("_id");
			
			String pw = request.getParameter("pw");
			
			Member1VO vo = new Member1VO();
			vo.setId(id);
			vo.setPw(pw);
			
			Member1DAO m1DAO = new Member1DAO();
			Member1VO cVO = m1DAO.passwordCheck(vo);
			
			if(cVO!=null) {
				response.sendRedirect("edit.do");
			}
			else {				
				response.sendRedirect("pwcheck.do");
			}
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
