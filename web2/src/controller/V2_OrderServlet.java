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
import vo.V2_OrderVO;

/**
 * Servlet implementation class V2_OrderServlet
 */
@WebServlet("/v2_order.do")
public class V2_OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			//v2_shop.jsp에서 2개의 값을 받음
			String no = request.getParameter("no");
			String cnt = request.getParameter("cnt");
			//세션객체 필요
			HttpSession httpsession = request.getSession();
			//세션에서 아이디값을 읽어봄
			String id = (String)httpsession.getAttribute("_id");
			
			if(id==null) {
				httpsession.setAttribute("_url", "v2_order.do?no="+no+"&cnt="+cnt);
				response.sendRedirect("v2_login.do");
			}
			else {
				V2_OrderVO vo = new V2_OrderVO();
				vo.setItem_no(Integer.parseInt(no));
				vo.setCnt(Integer.parseInt(cnt)); 
				vo.setCustom_id(id);
				
				SqlSession sqlsession = SqlMapClient.getSession();
				sqlsession.insert("V2_Order.insertOrder", vo);
				sqlsession.commit();			
				
				response.sendRedirect("v2_orderlist.do");
			}
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
		doGet(request, response);
		
		
	}

}
