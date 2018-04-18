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
 * Servlet implementation class V2_ItemDeleteServlet
 */
@WebServlet("/v2_itemdelete.do")
public class V2_ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_ItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String no =request.getParameter("no");
			
			SqlSession sqlsession = SqlMapClient.getSession();
			
			sqlsession.delete("V2_Item.deleteItemOne", Integer.parseInt(no));
			sqlsession.commit();
			
			response.sendRedirect("v2_iteminsert1.do");
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
		
		try {
			String[] chk = request.getParameterValues("chk[]");
			SqlSession sqlsession = SqlMapClient.getSession();
			
			//
			/*for(int i=0; i<chk.length; i++) {

			sqlsession.delete("V2_Item.deleteItemOne", Integer.parseInt(chk[i]));
				
			}*/
			//
		
			//전체 데이터를 전달해서 일괄 삭제
			List<V2_ItemVO> list = new ArrayList<V2_ItemVO>();
			
			for(int i=0; i<chk.length; i++) {
				V2_ItemVO vo = new V2_ItemVO();
				vo.setNo(Integer.parseInt(chk[i]));
				list.add(vo);
			}
			sqlsession.delete("V2_Item.deleteItemMulti", list);
			//
			
			sqlsession.commit();
			response.sendRedirect("v2_iteminsert1.do");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
