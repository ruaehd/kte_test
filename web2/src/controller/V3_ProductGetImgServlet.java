package controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.V3_ProductVO;

/**
 * Servlet implementation class V3_ProductGetImgServlet
 */
@WebServlet("/v3_productgetimg.do")
public class V3_ProductGetImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_ProductGetImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String code = request.getParameter("code");
			SqlSession sqlsession = SqlMapClient.getSession();
			V3_ProductVO vo = sqlsession.selectOne("V3_Product.selectImg", code);
			
			response.setContentType("image/jpeg");	//보안이 강화되나 부하가 커짐	//이전에 했던 방식은 부하가 적으나 보안에 취약	//두가지 모두 사용가능해야함
			if(vo.getImg() != null) {
				OutputStream o = response.getOutputStream();
				o.write(vo.getImg());
				o.flush();
				o.close();
			}
			else {
				response.sendRedirect("imgs/default.jpg");
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
