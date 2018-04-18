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
@WebServlet("/v3_productgetimg1.do")
public class V3_ProductGetImg1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public V3_ProductGetImg1Servlet() {
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
			String idx = request.getParameter("idx");
			SqlSession sqlsession = SqlMapClient.getSession();
			V3_ProductVO vo = sqlsession.selectOne("V3_Product.selectImg1", code);
			
			response.setContentType("image/jpeg");	//보안이 강화되나 부하가 커짐	//이전에 했던 방식은 부하가 적으나 보안에 취약	//두가지 모두 사용가능해야함

				OutputStream o = response.getOutputStream();
				
				if (Integer.parseInt(idx) == 0) {
					if (vo.getImg() == null) {
						response.sendRedirect("imgs/default.jpg");
					} else {
						o.write(vo.getImg());
					}
				} else if (Integer.parseInt(idx) == 1) {
					if (vo.getImg1() == null) {
						response.sendRedirect("imgs/default.jpg");
					} else {
						o.write(vo.getImg1());
					}
				} else if (Integer.parseInt(idx) == 2) {
					if (vo.getImg2() == null) {
						response.sendRedirect("imgs/default.jpg");
					} else {
						o.write(vo.getImg2());
					}
				} else if (Integer.parseInt(idx) == 3) {
					if (vo.getImg3() == null) {
						response.sendRedirect("imgs/default.jpg");
					} else {
						o.write(vo.getImg3());
					}
				} else if (Integer.parseInt(idx) == 4) {
					if (vo.getImg4() == null) {
						response.sendRedirect("imgs/default.jpg");
					} else {
						o.write(vo.getImg4());
					}
				}
				o.flush();
				o.close();	
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
