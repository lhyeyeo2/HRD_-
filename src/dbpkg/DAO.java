package dbpkg;

import java.sql.*;

public class DAO {
	// (_)싱글톤 4줄임
	// (_)접속
	// crud
	// (_)접속 닫다.
	private static DAO instance = new DAO();

	public static DAO getInstance() {
		return instance;
	} private DAO () {}

	public Connection DBConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getCustno() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int custno = 0;
		
		try {

			//conn, sql, pstmt, rs
			conn= DBConnection();
			sql = "select nvl(max(custno),100000)+1 from MEMBER_TBL_02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				custno = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} return custno;		
	}
		//vo를 인자로 안넣어서 안 불러옴
	public int insertMem(MemberVO vo) {
		//여기도 4줄 헷
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = null;
		//conn, sql, pstmt, rs
		
		try {
			conn = DBConnection();
			sql = "insert into MEMBER_TBL_02 values (?,?,?,?,to_date(?,'yyyymmdd'),?,?)";
			pstmt = conn.prepareStatement(sql);
			//.들어가고 set이랑 get이랑 헷//custno, custname, phone, address, joindate, grade, city
			pstmt.setInt(1, vo.getCustno());
			pstmt.setString(2, vo.getCustname());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getAddress());
			pstmt.setString(5, vo.getJoindate());
			pstmt.setString(6, vo.getGrade());
			pstmt.setString(7, vo.getCity());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//여기는rs.close()하면안됨요
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}return rs;
	}
	
	public 
}
