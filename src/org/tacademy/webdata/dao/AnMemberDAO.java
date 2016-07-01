package org.tacademy.webdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.tacademy.webdata.vo.AnMemberVO;
import org.tacademy.webdata.dao.JDBCUtil;

public class AnMemberDAO {
	private String loginSQL = "select name from anmember where id = ? and pw = ? ";
	private String joinSQL = "insert into anmember (name, id, pw, tel, address, comment, idate)"
									+ "values(?, ?, ?, ?, ?, ?, now() ) " ;
	private String checkSQL = "select id from anmember where id = ? ";
	
	public void doLogin(AnMemberVO vo){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loginSQL);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPw());
			rst = stmt.executeQuery();
			
			//로그인 정보는 1개만 리턴하므로 while문이 필요없음
			if(rst.next()){
				vo.setName(rst.getString(1));
			}
			
		}catch(SQLException e){
			System.out.println("login e : " + e);
		}finally {
			JDBCUtil.close(rst,stmt, conn);
		}
	}
	
	
	public void doJoin(AnMemberVO vo){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(joinSQL);
			
/*			insert into ANMEMBER values(null, '김재웅', 'abc', '1234', 
		            '01037926917', '경기도 성남시 중원구', '모바일 서버 예제', now() );*/

//			private String joinSQL = "insert into anmember values(null, ?, ?, ?, ?, ?, ? , now()) " ;
			
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getId());
			stmt.setString(3, vo.getPw());
			stmt.setString(4, vo.getTel());
			stmt.setString(5, vo.getAddress());
			stmt.setString(6, vo.getComment());
			
			int cnt = stmt.executeUpdate();
			if(cnt > 0){
				System.out.println("Insert Success");
			}			
			
		}catch(SQLException e){
			System.out.println("Join e : " + e);
		}finally {
			JDBCUtil.close(rst,stmt, conn);
		}
	}
	
	public boolean doCheck(AnMemberVO vo){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(checkSQL);
			stmt.setString(1, vo.getId());
			
			rst = stmt.executeQuery();
			
			if(rst.next()){
				result = true;
			}
			
		}catch(SQLException e){
			System.out.println("login e : " + e);
		}finally {
			JDBCUtil.close(rst,stmt, conn);
		}
		return result;
	}
	
	

}
