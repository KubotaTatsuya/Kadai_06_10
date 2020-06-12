package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.BBSbean;

public class BBSdao {
	private static final String url = "jdbc:mysql://localhost:3306/bbs?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "4191121shiba@KTjp";
	public static ArrayList<BBSbean> selectAllComment(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM history_2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<BBSbean> list = new ArrayList<BBSbean>();
			while( rs.next() ){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String comment = rs.getString("comment");
				String file = rs.getString("file");
				String postdate = rs.getString("postdate");
				String posttime = rs.getString("posttime");
				String editdate = rs.getString("editdate");
				String edittime = rs.getString("edittime");
				BBSbean result = new BBSbean(id,name,mail,comment,file,postdate,posttime,editdate,edittime);
				list.add(result);
			}
			return list;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void insertComment(BBSbean s){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "INSERT INTO history_2(name,mail,comment,file,postdate,posttime,editdate,edittime) VALUES(?,?,?,?,now(),now(),now(),now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMail());
			pstmt.setString(3, s.getComment());
			pstmt.setString(4, s.getFile());
			int result = pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");
		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public static void deleteComment(int no){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "DELETE FROM history_2 WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			System.out.println(result + "件削除されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
}