package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.EmployeeBean;
import beans.LoginBean;
import beans.UpdatePasswordBean;
import dbutil.DBUtil;

public class DAO {
	private Connection conn = null;
	
	{
		conn = DBUtil.getMyConnection();
		System.out.println(conn);
	}
	public Connection returnConnection() { return conn; }
	
	public boolean registerEmployee(EmployeeBean obj) {
		String sql = "INSERT into Empl values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getEmpNo());
			ps.setString(2, obj.getEmpName());
			ps.setDouble(3, obj.getEmpSal());
			int ret = ps.executeUpdate();
			System.out.println(ret);
			if(ret > 0) {
				conn.commit();
				return true;
			}
		} catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		return false;
	}
	public boolean authenticateUser(LoginBean obj) {
		String sql = "SELECT * FROM Login WHERE emailId = ? and password = ? ";
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,obj.getEmailId());
			ps.setString(2,obj.getPassword());
			rs = ps.executeQuery();
			
			if(rs.next()){ 
				System.out.println("In next statement");
				return true;
			}
		} catch(SQLException sqe) {
			System.out.println("In catch statement");
			//System.out.println(ps);
			sqe.printStackTrace();
		}
		return false;
	}
	public boolean changePassword(UpdatePasswordBean obj) {
		String sql = "UPDATE Login set password = ? where emailId = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getNewPwd());
			ps.setString(2, obj.getEmailId());
			int ret = ps.executeUpdate();
			if(ret > 0) {
				conn.commit();
				return true;
			}
		} catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		return false;
	}
	public ResultSet getEmployeeDetails() {
		String sql = "SELECT * from Empl";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			return rs;
		} catch(SQLException sqe) {

			sqe.printStackTrace();
		}
		System.out.println("Returning null");
		return null;
	}
	public boolean removeUser(String uId)  {
		String sql = "DELETE FROM Empl where EmpNo = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uId);
			int ret = ps.executeUpdate();
			if(ret > 0) {
				conn.commit();
				return true;
			}
		} catch(SQLException sqe) {
			sqe.printStackTrace();
		} 
		return false;
	}
}
