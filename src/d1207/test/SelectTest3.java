package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest3 {

	public static void main(String[] args) {
		// \r\n 은 줄바꿈(엔터), sql 자바 문자열에서는 꼭 필요한 것은 아님 (있어도 되고 없어도 됨)
		String sql = "SELECT tm.custno,custname,decode(grade,'A','VIP','B','일반','C','직원') \"등급\",psum\r\n "
				+ "FROM TBL_MAMBERSHIP tm \r\n "
				+ "JOIN	\r\n"
				+ "(		 	\r\n"
				+ "	SELECT custno , sum(price) psum     \r\n"
				+ "	FROM TBL_MONEY tm2  \r\n"
				+ "	GROUP BY custno\r\n"
				+ ") sale		\r\n"
				+ "ON tm.custno = sale.custno\r\n"
				+ "ORDER BY psum desc";
				
			Connection conn = OracleUtil.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println("회원매출현황");
				System.out.println("::::::::::::::::::::");
			while(rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + 
						rs.getNString(2) + "\t" + 
						rs.getNString(3) + "\t" + 
						rs.getInt(4) + "\t"
						);
			}
		
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
	}
}
