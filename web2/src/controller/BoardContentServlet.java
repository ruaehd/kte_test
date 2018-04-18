package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import session.SqlMapClient;
import vo.Board1VO;

/**
 * Servlet implementation class BoardContentServlet
 */
@WebServlet("/boardc.do")
public class BoardContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    private String nl2br(String str) {
    	str = str.replaceAll("\r\n", "<br />");
    	str = str.replaceAll("\r", "<br />");
    	str = str.replaceAll("\n", "<br />");
    	
    	return str;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = request.getParameter("no");
		Board1VO vo = new Board1VO();
		vo.setNo(Integer.parseInt(no));
		
		SqlSession sqlsession = SqlMapClient.getSession();
		
		//세션에 객체 얻기
		HttpSession httpSession = request.getSession();
		
		int chk_hit = (int)httpSession.getAttribute("_hit");
		if(chk_hit==1) {
			//조회수를 1 증가 
			sqlsession.update("Board1.updateHit", vo);
			sqlsession.commit();
			//중복 방지를 위해 0으로 변경
			httpSession.setAttribute("_hit",0);
		}
		
		int prev = sqlsession.selectOne("selectBoardPrev",vo);
		request.setAttribute("prev", prev);
		
		int next = sqlsession.selectOne("selectBoardNext",vo);
		request.setAttribute("next", next);
		
		Board1VO vo1 = sqlsession.selectOne("Board1.selectBoardOne", vo);
		sqlsession.commit();
		
		String tmp = nl2br(vo1.getContent());
		vo1.setContent(tmp);
		
		request.setAttribute("vo", vo1);
		request.getRequestDispatcher("/WEB-INF/boardc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
