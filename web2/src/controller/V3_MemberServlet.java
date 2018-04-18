package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class V3_MemberServlet
 */
@WebServlet("/v3_member.do")
public class V3_MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_MemberServlet() {
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
			
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("_url", "v3_member.do");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V3_MemberVO> list = sqlsession.selectList("V3_Member.selectMemberList");
			
			int lastno = sqlsession.selectOne("V3_Member.selectLastNo");
			
			
			request.setAttribute("list", list);
			request.setAttribute("lastno", (lastno+1));
			
			request.getRequestDispatcher("/WEB-INF/v3_member.jsp").forward(request, response);
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
			
			String no = request.getParameter("no");
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String birth = request.getParameter("birth");
			String tel = request.getParameter("tel");
			String phone = request.getParameter("phone");
			String postcode = request.getParameter("postcode");
			String addr = request.getParameter("addr");
			
			V3_MemberVO vo = new V3_MemberVO();
			vo.setNo(no);
			vo.setName(name);
			vo.setPw(pw);
			vo.setBirth(birth);
			vo.setTel(tel);
			vo.setPhone(phone);
			vo.setPostcode(postcode);
			vo.setAddr(addr);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("V3_Member.insertMember", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_member.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
