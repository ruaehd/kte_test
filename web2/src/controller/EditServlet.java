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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit.do")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1. DAO 객체생성
		Member1DAO m1DAO= new Member1DAO();
		
		HttpSession httpSession = request.getSession();
		String id = (String)httpSession.getAttribute("_id");
		
		Member1VO vo = new Member1VO();
		vo.setId(id);
		
		//2. method 호출 후 회원정보 받기
		Member1VO vo1 = m1DAO.selectMemberOne(vo);
		
		String tmp = vo1.getTel();
		String[] a= tmp.split("-");
		
		vo1.setTel1(a[0]);
		vo1.setTel2(a[1]);
		vo1.setTel3(a[2]);
		
		//jsp로 값 전달
		request.setAttribute("vo", vo1);
		request.getRequestDispatcher("/WEB-INF/edit.jsp").forward(request, response);
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
			String name = request.getParameter("name");
			String tel1 = request.getParameter("tel1");
			String tel2 = request.getParameter("tel2");
			String tel3 = request.getParameter("tel3");
			String postcode = request.getParameter("postcode");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String email = request.getParameter("email");
			
			Member1VO vo = new Member1VO();
			vo.setId(id);
			vo.setName(name);
			vo.setTel(tel1+"-"+tel2+"-"+tel3);
			vo.setPostcode(postcode);
			vo.setAddr1(addr1);
			vo.setAddr2(addr2);
			vo.setEmail(email);
			
			Member1DAO m1DAO = new Member1DAO();
			int ret = m1DAO.updateMember(vo);
			if(ret == 1) {
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("_name", vo.getName());
			}
			
			
			
			response.sendRedirect("index.do");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
