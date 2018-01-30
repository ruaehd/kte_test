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
import vo.V3_ProductVO;

/**
 * Servlet implementation class V3_AdminServlet
 */
@WebServlet("/v3_admin.do")
public class V3_AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String menu = request.getParameter("menu");
			if(menu==null) {
				menu="1";
			}
			String smenu = request.getParameter("smenu");
			if(smenu==null) {
				smenu="1";
			}		
				
			if(Integer.parseInt(menu)==1 && (Integer.parseInt(smenu)==1)) {
				
				SqlSession sqlsession = SqlMapClient.getSession();
				List<V3_ProductVO> list = sqlsession.selectList("V3_Product.selectProductList");
				
				request.setAttribute("list", list);
			}
			else if(Integer.parseInt(menu)==1 && (Integer.parseInt(smenu)==2)) {
				SqlSession sqlsession = SqlMapClient.getSession();
				List<V3_ProductVO> list = sqlsession.selectList("V3_Product.selectProductList");
				
				request.setAttribute("list", list);
			}
			
			request.getRequestDispatcher("/WEB-INF/v3_admin.jsp").forward(request, response);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SqlSession sqlsession = SqlMapClient.getSession();
		
		try {
			String menu = request.getParameter("menu");
			String smenu = request.getParameter("smenu");
			
			if(Integer.parseInt(menu)==1 && (Integer.parseInt(smenu)==1)) {
				String items_idx = request.getParameter("items_idx");
				
				String[] items_arr = items_idx.split(",");
				
				
				
				for(int i=0; i<items_arr.length; i++) {
					System.out.println(items_arr[i]);
					V3_ProductVO vo = new V3_ProductVO();
					vo.setCode(items_arr[i]);
					vo.setIdx((i+1));
					
					sqlsession.update("V3_Product.updateIDXOrder",vo);
				}
				sqlsession.commit();//적용하기
				response.sendRedirect("v3_admin.do?menu=1&smenu=1");
				
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			sqlsession.rollback();//되돌리기
		}
	}

}
