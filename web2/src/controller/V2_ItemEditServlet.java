package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V2_ItemVO;

/**
 * Servlet implementation class v2_ItemEditServlet
 */
@WebServlet("/v2_itemedit.do")
public class V2_ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_ItemEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			//이전 페이지에서 넘어오는 no값을 받음
			String no = request.getParameter("no");
			//DB SQL문 실행을 위한 객체 생성
			SqlSession sqlsession = SqlMapClient.getSession();
			//물품번호를 넘겨서 그 항목에 해당하는 1개의 물품정보를 받음
			V2_ItemVO vo = sqlsession.selectOne("V2_Item.selectItemOne", Integer.parseInt(no));
			//jsp로 값을 전달함
			request.setAttribute("vo", vo);
			//jsp를 표시함
			request.getRequestDispatcher("/WEB-INF/v2_itemedit.jsp").forward(request, response);
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
			String na = request.getParameter("name");
			String pr = request.getParameter("price");
			String qt = request.getParameter("qty");
			
			V2_ItemVO vo = new V2_ItemVO(Integer.parseInt(no), na, Integer.parseInt(pr), Integer.parseInt(qt));
						
			SqlSession sqlsession = SqlMapClient.getSession();
			sqlsession.update("V2_Item.updateItemOne", vo);
			sqlsession.commit();
			
			response.sendRedirect("v2_iteminsert1.do");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
