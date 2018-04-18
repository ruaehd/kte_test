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
import vo.V3_ProviderVO;

/**
 * Servlet implementation class V3_ProviderInsertServlet
 */
@WebServlet("/v3_provider.do")
public class V3_ProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_ProviderServlet() {
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
			httpsession.setAttribute("_url", "v3_product.do");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V3_ProviderVO> list = sqlsession.selectList("V3_Provider.selectProviderList");
			
			request.setAttribute("list", list);
		
			request.getRequestDispatcher("/WEB-INF/v3_provider.jsp").forward(request, response);
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
			sqlsession.insert("V3_Provider.insertProvider", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_provider.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
