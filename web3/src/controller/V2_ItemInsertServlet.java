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
 * Servlet implementation class V2_ItemInsertServlet
 */
@WebServlet("/v2_iteminsert.do")
public class V2_ItemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_ItemInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		SqlSession sqlsession = SqlMapClient.getSession();
		int ret = sqlsession.selectOne("V2_Item.selectLastNo");
		
		request.setAttribute("lastno", ret);
		request.getRequestDispatcher("/WEB-INF/v2_iteminsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String[] no = request.getParameterValues("no[]");
			String[] na= request.getParameterValues("name[]");
			String[] pr = request.getParameterValues("price[]");
			String[] qt = request.getParameterValues("qty[]");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			
			for(int i=0; i<no.length; i++) {
				V2_ItemVO vo = new V2_ItemVO();
				vo.setNo(Integer.parseInt(no[i]));
				vo.setName(na[i]);
				vo.setPrice(Integer.parseInt(pr[i]));
				vo.setQty(Integer.parseInt(qt[i]));
				
				sqlsession.insert("V2_Item.insertItemOne", vo);
			}
			sqlsession.commit();
			
			response.sendRedirect("v2_iteminsert.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
