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
import vo.V3_DeliveryVO;
import vo.V3_ProductVO;



/**
 * Servlet implementation class V3_DeliveryServlet
 */
@WebServlet("/v3_delivery.do")
public class V3_DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_DeliveryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("_url", "v3_delivery.do");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<String> p_list = sqlsession.selectList("V3_Provider.selectProviderCodeList");
			List<String> d_list = sqlsession.selectList("V3_Product.selectProductCodeList");
			
			int lastno = sqlsession.selectOne("V3_Delivery.selectLastNo");
			
			List<V3_DeliveryVO> list = sqlsession.selectList("V3_Delivery.selectDeliveryList");
			
			request.setAttribute("p_list", p_list);
			request.setAttribute("d_list", d_list);
			request.setAttribute("lastno", (lastno+1));
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/WEB-INF/v3_delivery.jsp").forward(request, response);
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
			String code_pv = request.getParameter("code_pv");
			String code_pd = request.getParameter("code_pd");
			String d_date = request.getParameter("d_date");
			String cnt = request.getParameter("cnt");
			String cost = request.getParameter("cost");
			String price = request.getParameter("price");
			
			V3_DeliveryVO vo = new V3_DeliveryVO();
			vo.setNo(Integer.parseInt(no));
			vo.setCode_pd(code_pd);
			vo.setCode_pv(code_pv);
			vo.setD_date(d_date);
			vo.setCnt(Integer.parseInt(cnt));
			vo.setCost(Integer.parseInt(cost));
			vo.setPrice(Integer.parseInt(price));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.insert("V3_Delivery.insertDelivery", vo);
			
			V3_ProductVO vo1 = new V3_ProductVO();
			vo1.setCode(code_pd);
			vo1.setQty(Integer.parseInt(cnt));
			
			sqlsession.update("V3_Product.updateQtyAddPlus", vo1);
			sqlsession.commit();
			
			response.sendRedirect("v3_delivery.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
