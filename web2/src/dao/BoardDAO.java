package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVO;

public class BoardDAO {
	
	public List<BoardVO> BoardList() {
		try {
			String sql = "SELECT * FROM board ORDER BY no DESC";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<BoardVO> list = new ArrayList<BoardVO>();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setNo(rs.getInt("no"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setHit(rs.getString("hit"));
				bvo.setWritedate(rs.getString("writedate"));
			
				list.add(bvo);
			}
			
			return list;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
