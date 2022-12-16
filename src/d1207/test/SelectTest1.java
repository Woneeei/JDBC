package d1207.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.util.OracleUtil;

public class SelectTest1 {

	public static void main(String[] args) {
		//java.sql 패키지의 인터페이스는 자바API 에 구현클래스는 없다. 연관된 다른객체를 통해서 객체가 생성
		Connection conn = OracleUtil.getConnection();
		System.out.print("연결확인 : ");
		System.out.println(conn);	//null이 출력되면 연결 실패

		//SQL select 실행 해봅시다. - 새로운 객체 2가지 -> 인터페이스를 통해서 DBMS 종류에 따라 구현체의 객체가 생성
		PreparedStatement pstmt = null;	//sql실행할 객체를 참조
		ResultSet rs = null;	//select 쿼리 결과 객체를 참조
		String sql = "select * from TBL_MAMBERSHIP";
		
		try {
		pstmt = conn.prepareStatement(sql);	//sql 명령을 인자로 받아 실행할 객체를 생성하여 pstmt가 참조변수
		rs = pstmt.executeQuery();			//쿼리 실행하고 그 결과를 객체로 생성하여 rs가 참조변수
		//while문으로 변경해보자
		System.out.println("조회 결과가 있습니까? (첫번째 행)" + rs.next()); //next() 메소드 : 조회 결과 다음행을 참조. 참 또는 거짓
		System.out.println("첫번째 컬럼의 값 : " + rs.getInt(1));
		System.out.println("두번째 컬럼의 값 : " + rs.getNString(2));
		System.out.println("세번째 컬럼의 값 : " + rs.getNString(3));
		System.out.println("네번째 컬럼의 값 : " + rs.getNString(4));
		System.out.println("다섯번째 컬럼의 값 : " + rs.getDate(5));
		System.out.println("여섯번째 컬럼의 값 : " + rs.getNString(6));
		System.out.println("일곱번째 컬럼의 값 : " + rs.getNString(7));
		
		System.out.println("조회 결과가 있습니까? (두번째 행)" + rs.next()); //참 또는 거짓
		System.out.println("첫번째 컬럼의 값 : " + rs.getInt("CUSTNO"));
		System.out.println("두번째 컬럼의 값 : " + rs.getNString("CUSTNAME"));
		System.out.println("세번째 컬럼의 값 : " + rs.getNString("PHONE"));
		System.out.println("네번째 컬럼의 값 : " + rs.getNString("ADDRESS"));
		System.out.println("다섯번째 컬럼의 값 : " + rs.getDate("JOINDATE"));
		System.out.println("여섯번째 컬럼의 값 : " + rs.getNString("GRADE"));
		System.out.println("일곱번째 컬럼의 값 : " + rs.getNString("CITY"));
		
		System.out.println("조회 결과가 있습니까? (3번째 행)" + rs.next());
		System.out.println("조회 결과가 있습니까? (4번째 행)" + rs.next());
		System.out.println("조회 결과가 있습니까? (5번째 행)" + rs.next());
		System.out.println("조회 결과가 있습니까? (6번째 행)" + rs.next());
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
			OracleUtil.close(conn);
	}

}
