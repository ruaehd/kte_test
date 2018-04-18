package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V2_CustomVO;

/**
 * Servlet implementation class V2_JoinServlet
 */
@WebServlet("/v2_custominsert.do")
public class V2_CustomInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_CustomInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/v2_costominsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
						
			V2_CustomVO vo = new V2_CustomVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3"));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			
			sqlsession.insert("V2_Custom.insertCustom", vo);
			sqlsession.commit();
			
			response.sendRedirect("v2_index.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
