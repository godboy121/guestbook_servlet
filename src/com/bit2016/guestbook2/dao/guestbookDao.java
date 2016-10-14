package com.bit2016.guestbook2.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.guestbook2.vo.guestbookVo;

public class guestbookDao {
	private Connection getConnection() throws SQLException{
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 " + e);
	}
		return conn;
	}
	
	public void insert(guestbookVo vo){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try{
			conn=getConnection();
			String sql="insert into guestbook values(guestbooklist.nextval,?,?,?,sysdate)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			pstmt.setString(2,vo.getContext());
			pstmt.setString(3,vo.getPasswd());
			
			
			pstmt.executeQuery();	
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			try{
				if(conn!=null)
					conn.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e){
				System.out.println("error"+e);
			}
		}
	}
	
	public void delete(int no){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
			try {
				conn=getConnection();
				String sql="delete guestbook where no=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,no);
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally{
				try{
					if(conn!=null)
						conn.close();
					if(pstmt!=null)
						pstmt.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			
			}
			
		
	}
	
	
	
	public List<guestbookVo> getList(){
		List<guestbookVo> list=new ArrayList<guestbookVo>();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			conn=getConnection();
			stmt = conn.createStatement();
			String sql="select no, name, context, passwd, to_char(day,'yyyy-mm-dd hh:mi:ss') from guestbook order by no desc";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int no=rs.getInt(1);
				String name=rs.getString(2);
				String context=rs.getString(3);
				String passwd=rs.getString(4);
				String day=rs.getString(5);
				
				guestbookVo vo=new guestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setContext(context);
				vo.setPasswd(passwd);
				vo.setDate(day);
				
				list.add(vo);
			}
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			try{
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}catch(SQLException e)
			{
				System.out.println("error"+e);
			}
		}
		return list;
	}
	

}
