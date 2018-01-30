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
 * Servlet implementation class V2_UserLoginServelt
 */
@WebServlet("/v2_userlogin.do")
public class V2_UserLoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_UserLoginServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/v2_userlogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String type = request.getParameter("type");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			V2_CustomVO vo = new V2_CustomVO();
			vo.setId(id);
			vo.setPw(pw);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			
			if(Integer.parseInt(type)==1) {
				
				V2_CustomVO rvo = sqlsession.selectOne("V2_Custom.selectUserLogin", vo);
				
				HttpSession httpsession = request.getSession();
									
					if(rvo != null) {
						httpsession.setAttribute("_id", rvo.getId());
						httpsession.setAttribute("_name", rvo.getName());
						httpsession.setAttribute("_grade", rvo.getGrade());
						
						response.sendRedirect("v2_shop.do");
					}
					else {
						response.sendRedirect("v2_userlogin.do");
					}
				
			}
			else if(Integer.parseInt(type)==2) {
				
				V2_CustomVO rvo = sqlsession.selectOne("V2_Custom.selectAdminLogin", vo);
				
				HttpSession httpsession = request.getSession();
								
					if(rvo != null) {
						httpsession.setAttribute("_id", rvo.getId());
						httpsession.setAttribute("_name", rvo.getName());
						httpsession.setAttribute("_grade", rvo.getGrade());
						
						response.sendRedirect("v2_iteminsert1.do");
					}
					else {
						response.sendRedirect("v2_userlogin.do");
					}
				
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
