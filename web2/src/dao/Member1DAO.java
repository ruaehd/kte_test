package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member1VO;

public class Member1DAO {
	
	public int updateMemberPW(Member1VO vo) {
		try {
			String sql = "UPDATE member1 SET pw=SHA1(?) WHERE id=? AND pw=SHA1(?)";
			
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			pstmt.setString(1, vo.getPw1());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			
			return pstmt.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public int updateMember(Member1VO vo) {
		try {
			String sql = "UPDATE member1 SET name=?, tel=?, postcode=?, addr1=?, addr2=?, email=? WHERE id=?";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getPostcode());
			pstmt.setString(4, vo.getAddr1());
			pstmt.setString(5, vo.getAddr2());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getId());
			
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public Member1VO passwordCheck(Member1VO vo) {
		try {
			String sql = "SELECT * FROM member1 WHERE id=? AND pw=SHA1(?)";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			//SELECT문일 경우
			ResultSet rs = pstmt.executeQuery();
			//리턴하기위한 vo 생성
			Member1VO cVO = new Member1VO();
						
			if(rs.next()) {
				rs.getString("id");
				return cVO;
			}
			return null;			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public Member1VO selectMemberOne(Member1VO vo) {
		try {
			String sql = "SELECT * FROM member1 WHERE id=?";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			
			ResultSet rs = pstmt.executeQuery();
			Member1VO vo1 = new Member1VO();
			if(rs.next()) {
				vo1.setId(rs.getString("id"));
				vo1.setName(rs.getString("name"));
				vo1.setTel(rs.getString("tel"));
				vo1.setPostcode(rs.getString("postcode"));
				vo1.setAddr1(rs.getString("addr1"));
				vo1.setAddr2(rs.getString("addr2"));
				vo1.setEmail(rs.getString("email"));
				
				return vo1;
			}
			return null;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	public int selectIDCheck(Member1VO vo) {
		try {
			String sql = "SELECT count(*) AS cnt FROM member1 WHERE id=?";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnt"); //0또는 1이 리턴됨
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return -1;	//오류나면 -1이 리턴됨
		}
	}
	
	
	public List<Member1VO> selectMemberList() {
		try {
			String sql = "SELECT * FROM member1 WHERE grade=1 ORDER BY joindate DESC";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Member1VO> list = new ArrayList<Member1VO>();
			while(rs.next()) {
				Member1VO vo = new Member1VO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setPostcode(rs.getString("postcode"));
				vo.setAddr1(rs.getString("addr1"));
				vo.setAddr2(rs.getString("addr2"));
				vo.setEmail(rs.getString("email"));
				vo.setJoindate(rs.getString("joindate"));
				
				list.add(vo);
			}
			
			return list;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public Member1VO selectMember(Member1VO vo) {
		try {
			String sql = "SELECT * FROM member1 WHERE id=? AND pw=SHA1(?)";
			PreparedStatement pstmt = DBConn.getConn().prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			
			//SELECT문일 경우
			ResultSet rs = pstmt.executeQuery();
			//리턴하기위한 vo 생성
			Member1VO rVO = new Member1VO();
			if(rs.next()) {//결과값이 있다면
				rVO.setId(rs.getString("id"));
				rVO.setName(rs.getString("name"));
				rVO.setGrade(rs.getInt("grade"));
				return rVO;
			}
			
			return null;			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public int insertMember(Member1VO vo) {
		try {
			Connection conn = DBConn.getConn();
			String sql = "INSERT INTO member1(id, pw, name, tel, postcode, addr1, addr2, email, joindate) VALUES(?,SHA1(?),?,?,?,?,?,?,NOW())";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getPostcode());
			pstmt.setString(6, vo.getAddr1());
			pstmt.setString(7, vo.getAddr2());
			pstmt.setString(8, vo.getEmail());
						
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
}
