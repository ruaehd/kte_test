package controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_BoardqnaVO;

/**
 * Servlet implementation class V3_BoardqnaHitServlet
 */
@WebServlet("/v3_boardqnahit.do")
public class V3_BoardqnaHitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_BoardqnaHitServlet() {
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
			
			V3_BoardqnaVO vo = new V3_BoardqnaVO();
			vo.setNo(new BigInteger(no));
			
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.update("V3_Boardqna.updateBoardqnaHit", vo);
			sqlsession.commit();
			
			response.sendRedirect("v3_boardqnacontent.do?no=" + no);
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
