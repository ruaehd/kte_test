package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member1DAO;
import vo.Member1VO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String a = request.getParameter("id");
			String b = request.getParameter("pw");
			String c = request.getParameter("name");
			String d = request.getParameter("tel1");
			String e = request.getParameter("tel2");
			String f = request.getParameter("tel3");
			String g = request.getParameter("postcode");
			String h = request.getParameter("addr1");
			String i = request.getParameter("addr2");
			String j = request.getParameter("email");
			
			Member1VO vo = new Member1VO();
			vo.setId(a);
			vo.setPw(b);
			vo.setName(c);
			vo.setTel(d+"-"+e+"-"+f);
			vo.setPostcode(g);
			vo.setAddr1(h);
			vo.setAddr2(i);
			vo.setEmail(j);
			
			//1.객체 생성
			Member1DAO m1DAO = new Member1DAO();
			
			//2. insertMember메소드 호출
			m1DAO.insertMember(vo);
			
			//3. index.do 페이지 이동
			response.sendRedirect("index.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

}
