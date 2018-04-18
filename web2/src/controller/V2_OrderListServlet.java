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
import vo.V2_ItemOrderVO;
import vo.V2_OrderVO;

/**
 * Servlet implementation class V2_OrderListServlet
 */
@WebServlet("/v2_orderlist.do")
public class V2_OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession httpsession = request.getSession();
		String id = (String)httpsession.getAttribute("_id");
		if(id != null) {
			V2_OrderVO vo = new V2_OrderVO();
			vo.setCustom_id(id);
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V2_ItemOrderVO> list = sqlsession.selectList("V2_Order.selectItemOrder", vo);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("/WEB-INF/v2_order.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
