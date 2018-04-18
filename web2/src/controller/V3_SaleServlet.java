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
import vo.V3_SaleVO;

/**
 * Servlet implementation class V3_SaleServlet
 */
@WebServlet("/v3_sale.do")
public class V3_SaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_SaleServlet() {
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
			httpsession.setAttribute("_url", "v3_sale.do");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V3_SaleVO> list = sqlsession.selectList("V3_Sale.selectSaleList");
			
			int lastno = sqlsession.selectOne("V3_Sale.selectLastNo");
			
			List<String> p_list = sqlsession.selectList("V3_Member.selectMemberNoList");
			List<String> d_list = sqlsession.selectList("V3_Product.selectProductCodeList");
			
			
			request.setAttribute("list", list);
			request.setAttribute("lastno", (lastno+1));
			request.setAttribute("p_list", p_list);
			request.setAttribute("d_list", d_list);
			
			request.getRequestDispatcher("/WEB-INF/v3_sale.jsp").forward(request, response);
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
			String code_pd = request.getParameter("code_pd");
			String no_mem = request.getParameter("no_mem");
			String s_date = request.getParameter("s_date");
			String cnt = request.getParameter("cnt");
			String price = request.getParameter("price");
			String price_c = request.getParameter("price_c");
			
			V3_SaleVO vo = new V3_SaleVO();
			vo.setNo(no);
			vo.setCode_pd(code_pd);
			vo.setNo_mem(no_mem);
			vo.setS_date(s_date);
			vo.setCnt(Integer.parseInt(cnt));
			vo.setPrice(Integer.parseInt(price));
			vo.setPrice_c(Integer.parseInt(price_c));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("V3_Sale.insertSale", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_sale.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
