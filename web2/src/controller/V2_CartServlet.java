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
import vo.V2_CartVO;
import vo.V2_OrderVO;

/**
 * Servlet implementation class V2_CartServlet
 */
@WebServlet("/v2_cart.do")
public class V2_CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_CartServlet() {
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
			
			String no = request.getParameter("no");
			String cnt = request.getParameter("cnt");
			
			V2_CartVO vo = new V2_CartVO();
			vo.setItem_no(Integer.parseInt(no));
			vo.setCnt(Integer.parseInt(cnt));
			
			//1. 세션에 의한 ID 생성
			HttpSession httpsession = request.getSession();
			String id0 = httpsession.getId();
			vo.setUser_id(id0);
			
			/*//2. 접속한 IP를 사용자
			String id1 = request.getRemoteAddr();*/
			
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("V2_Cart.insertCart",vo);
			sqlsession.commit();
			
			request.setAttribute("vo", vo);
			response.sendRedirect("v2_cartlist.do");
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
		doGet(request, response);
	}

}
