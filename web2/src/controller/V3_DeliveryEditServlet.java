package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_DeliveryVO;

/**
 * Servlet implementation class V3_DeliveryEditServlet
 */
@WebServlet("/v3_deliveryedit.do")
public class V3_DeliveryEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_DeliveryEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String no = request.getParameter("no");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			V3_DeliveryVO vo = sqlsession.selectOne("V3_Delivery.selectDeliveryOne", no);
			
			List<String> p_list = sqlsession.selectList("V3_Provider.selectProviderCodeList");
			List<String> d_list = sqlsession.selectList("V3_Product.selectProductCodeList");
			
			request.setAttribute("p_list", p_list);
			request.setAttribute("d_list", d_list);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("/WEB-INF/v3_deliveryedit.jsp").forward(request, response);
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
			sqlsession.update("V3_Delivery.updateDelivery", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_delivery.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
