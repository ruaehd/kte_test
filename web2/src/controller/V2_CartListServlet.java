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
import vo.V2_CartVO;
import vo.V2_ItemCartVO;

/**
 * Servlet implementation class V2_CartlistServlet
 */
@WebServlet("/v2_cartlist.do")
public class V2_CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_CartListServlet() {
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
			
			SqlSession sqlsession = SqlMapClient.getSession();
			V2_CartVO vo = new V2_CartVO();
			vo.setUser_id(httpsession.getId());
			
			List<V2_ItemCartVO> list = sqlsession.selectList("V2_Cart.selectCartList",vo);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/v2_cart.jsp").forward(request, response);
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
