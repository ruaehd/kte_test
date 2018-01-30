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
import vo.V3_ProductVO;

/**
 * Servlet implementation class V3_ProductServlet
 */
@WebServlet("/v3_product.do")
public class V3_ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_ProductServlet() {
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
			List<V3_ProductVO> list = sqlsession.selectList("V3_Product.selectProductList");
			
			request.setAttribute("list", list);
		
			request.getRequestDispatcher("/WEB-INF/v3_product.jsp").forward(request, response);
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
			String company = request.getParameter("company");
			String price = request.getParameter("price");
			String price_c = request.getParameter("price_c");
			String qty = request.getParameter("qty");
			
			V3_ProductVO vo = new V3_ProductVO();
			vo.setCode(code);
			vo.setName(name);
			vo.setCompany(company);
			vo.setPrice(Integer.parseInt(price));
			vo.setPrice_c(Integer.parseInt(price_c));
			vo.setQty(Integer.parseInt(qty));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("V3_Product.insertProduct", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_product.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
