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

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/v2_logout.do")
public class V2_LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//세션객체
		HttpSession httpSession = request.getSession();
		//세션 파일 지우고 다시 생성 - 내용이 모두 없어짐
		
		/*String str0 = httpSession.getId();*/
		
		httpSession.invalidate();
		
		/*String str1 = httpSession.getId();*/
		
		 
		
		/*SqlSession sqlsession = SqlMapClient.getSession();*/
		/*sqlsession.update("");*/
		
		//index.do 화면으로 이동함.
		response.sendRedirect("v2_shop.do");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
