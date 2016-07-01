package org.tacademy.webdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.tacademy.webdata.vo.ProductVO;

public class ProductDAO {
	public String selectSQL = "select * from product";
	
	public ArrayList<ProductVO> selectAllList(){
		ArrayList<ProductVO>  list = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(selectSQL);
			rst = stmt.executeQuery();
			ProductVO vo = null;
			
			while(rst.next()){
				vo = new ProductVO();
				vo.setNum(rst.getInt("num"));
				vo.setTitle(rst.getString("title"));
				vo.setCount(rst.getString("count"));
				vo.setPrice(rst.getInt("price"));
				vo.setImage(rst.getString("image"));
				vo.setCategory(rst.getString("category"));
				list.add(vo);
			}
			
		}catch(SQLException e){
			System.out.println("list e : " + e);
		}finally {
			JDBCUtil.close(rst,stmt, conn);
		}
		return list;
	}

}




