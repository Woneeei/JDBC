package d1208.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class MemberInsertTest {

	public static void main(String[] args) throws SQLException {
//		String sql="INSERT INTO MEMBER_TBL_02 \r\n"
//				+ "VALUES (seq_custno.nextval, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', '20151202', 'A', '01')";
		String sql="INSERT INTO MEMBER_TBL_02 \r\n"
				+ "VALUES (seq_custno.nextval, ?, ?, ?, sysdate, ?, ?)";
		
		
		Connection conn = OracleUtil.getConnection();
		PreparedStatement pstmt = null;
		//insert, update, delete 는 ResulstSet 사용 안함
		
		pstmt = conn.prepareStatement(sql);
//		System.out.println("autucommit : " + conn.getautucommit());
		//select 메소드로 sql 실행하기 전에 필요한 인자 전달 
		pstmt.setString(1, "김행복");
		pstmt.setString(2, "010-1111-2222");
		pstmt.setString(3, "서울 동대문구 휘경1동");
		pstmt.setString(4, "A");
		pstmt.setString(5, "01");
		
		
		
		
		pstmt.execute();	//select SQL은 executeQuery 메소드, 나머지는 execute 메소드
		
		conn.close();
		
	}

}
