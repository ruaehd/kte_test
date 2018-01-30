package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/v2_iteminsert1.do")
public class V2_ItemInsert1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_ItemInsert1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SqlSession sqlsession = SqlMapClient.getSession();
		
		List<V2_ItemVO> list = sqlsession.selectList("V2_Item.selectItemList");
		request.setAttribute("list", list);
		
		int ret = sqlsession.selectOne("V2_Item.selectLastNo");
		request.setAttribute("lastno", ret);
		
		request.getRequestDispatcher("/WEB-INF/v2_iteminsert1.jsp").forward(request, response);
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
			
			List<V2_ItemVO> list = new ArrayList<V2_ItemVO>();
			
			for(int i=0; i<no.length; i++) {
				V2_ItemVO vo = new V2_ItemVO();
				vo.setNo(Integer.parseInt(no[i]));
				vo.setName(na[i]);
				vo.setPrice(Integer.parseInt(pr[i]));
				vo.setQty(Integer.parseInt(qt[i]));
				list.add(vo);					
			}
			
			sqlsession.insert("V2_Item.insertItemMulti", list);
			sqlsession.commit();
			
			response.sendRedirect("v2_iteminsert1.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
