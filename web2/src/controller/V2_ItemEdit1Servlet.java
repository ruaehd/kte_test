package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V2_ItemVO;

/**
 * Servlet implementation class V2_ItemEdit1Servlet
 */
@WebServlet("/v2_itemupdate1.do")
public class V2_ItemEdit1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V2_ItemEdit1Servlet() {
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
			String[] chk = (String[])httpsession.getAttribute("_chk");
			
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<chk.length; i++) {
				list.add(Integer.parseInt(chk[i]));
			}
			
			SqlSession sqlsession = SqlMapClient.getSession();
			List<V2_ItemVO> list1 = sqlsession.selectList("V2_Item.selectItemChk", list);
			
			request.setAttribute("list", list1);
			request.getRequestDispatcher("/WEB-INF/v2_itemedit1.jsp").forward(request, response);
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
			
			String btn = request.getParameter("btn_edit");
			
			if(btn.equals("선택수정")) {
				String[] chk = request.getParameterValues("chk[]");
				//세션에 값을 넣음
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("_chk", chk);
				
				//페이지 전환 => GET으로 호출
				response.sendRedirect("v2_itemupdate1.do");
			}
			else if(btn.equals("전체수정")) {
									
				String[] no = request.getParameterValues("no[]");
				String[] na = request.getParameterValues("name[]");
				String[] pr = request.getParameterValues("price[]");
				String[] qt = request.getParameterValues("qty[]");
								
				List<V2_ItemVO> list = new ArrayList<V2_ItemVO>();
				for(int i=0; i<no.length; i++) {
					V2_ItemVO vo = new V2_ItemVO(Integer.parseInt(no[i]), na[i], Integer.parseInt(pr[i]), Integer.parseInt(qt[i]));
										
					list.add(vo);
				}
				
				SqlSession sqlsession = SqlMapClient.getSession();
				sqlsession.update("V2_Item.updateItemMulti", list);
				sqlsession.commit();
				
				response.sendRedirect("v2_iteminsert1.do");
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
