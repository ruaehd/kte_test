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
import vo.V2_CustomVO;

/**
 * Servlet implementation class V2_LoginServelt
 */
@WebServlet("/v2_login.do")
public class V2_LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_LoginServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/v2_login.jsp").forward(request, response);
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
			String pw = request.getParameter("pw");
			
			V2_CustomVO vo = new V2_CustomVO();
			vo.setId(id);
			vo.setPw(pw);
			
			SqlSession sqlsession = SqlMapClient.getSession();
					
			V2_CustomVO rvo = sqlsession.selectOne("V2_Custom.selectLogin", vo);
			
			HttpSession httpsession = request.getSession();
			
			
			System.out.println(rvo);
			
			
			if(rvo != null) {
				httpsession.setAttribute("_id", rvo.getId());
				httpsession.setAttribute("_name", rvo.getName());
				
				String url = (String) httpsession.getAttribute("_url");
				response.sendRedirect(url);
				
			}
			else {
				response.sendRedirect("v2_login.do");
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("1");
		}
		
	}

}
