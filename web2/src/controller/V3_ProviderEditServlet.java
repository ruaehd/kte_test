package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_ProviderVO;

/**
 * Servlet implementation class V3_ProviderEditServlet
 */
@WebServlet("/v3_provideredit.do")
public class V3_ProviderEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_ProviderEditServlet() {
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
			
			String code = request.getParameter("code");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			V3_ProviderVO vo = sqlsession.selectOne("V3_Provider.selectProviderOne", code);
			
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("/WEB-INF/v3_provideredit.jsp").forward(request, response);
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
			
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String header = request.getParameter("header");
			String phone = request.getParameter("phone");
			String postcode = request.getParameter("postcode");
			String addr = request.getParameter("addr");
			
			V3_ProviderVO vo = new V3_ProviderVO();
			vo.setCode(code);
			vo.setName(name);
			vo.setTel(tel);
			vo.setHeader(header);
			vo.setPhone(phone);
			vo.setPostcode(postcode);
			vo.setAddr(addr);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.update("V3_Provider.updateProvider", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_provider.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
