package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.Member1DAO;
import vo.BoardVO;
import vo.Member1VO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String menu = request.getParameter("menu");
		
		if(menu==null) {
			response.sendRedirect("admin.do?menu=1");
		}else {
		
		if(Integer.parseInt(menu)==1) {
			//DAO 객체
			Member1DAO m1DAO= new Member1DAO();
			//메소드 호출 후 결과값 받음
			List<Member1VO> tmp = m1DAO.selectMemberList();
			//jsp로 값을 전달
			request.setAttribute("list", tmp);
			//jsp를  화면에 표시
		}
		else if(Integer.parseInt(menu)==2) {
			BoardDAO bDAO= new BoardDAO();
			//메소드 호출 후 결과값 받음
			List<BoardVO> tmp = bDAO.BoardList();
			//jsp로 값을 전달
			request.setAttribute("list", tmp);
			//jsp를  화면에 표시
		}
		
		request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
