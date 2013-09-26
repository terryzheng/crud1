package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.database.UserModel;
import com.crud.tool.DataBase;

public class UserDao {
	public Boolean insertUser(UserModel um) {
		Connection con = DataBase.getCon();
		Boolean result = true;
		try {
			String sql = "insert into tbl_user(name,sex,age) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, um.getName());
			ps.setShort(2, um.getSex());
			ps.setInt(3, um.getAge());

			ps.execute();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public Boolean updateUser(UserModel um) {
		Connection con = DataBase.getCon();
		Boolean result = true;
		try {
			String sql = "update tbl_user set name=?,sex=?,age=? where userId=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, um.getName());
			ps.setShort(2, um.getSex());
			ps.setInt(3, um.getAge());
			ps.setInt(4, um.getUserId());

			ps.execute();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public Boolean deleteUser(int userId) {
		Connection con = DataBase.getCon();
		Boolean result = true;
		try {
			String sql = "delete from tbl_user where userId=" + userId;
			PreparedStatement ps = con.prepareStatement(sql);

			ps.execute();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	public UserModel getUser(int userId) {
		Connection con = DataBase.getCon();
		ResultSet rs = null;
		UserModel um = new UserModel();
		try {
			String sql = "select * from tbl_user where userId=" + userId;
			PreparedStatement ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				um.setUserId(rs.getInt(1));
				um.setName(rs.getString(2));
				um.setSex(rs.getShort(3));
				um.setAge(rs.getInt(4));
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return um;
	}

	public List<UserModel> queryUser(String condition) {
		Connection con = DataBase.getCon();
		ResultSet rs = null;
		List<UserModel> umlist = new ArrayList<UserModel>();
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from tbl_user where "
							+ condition);

			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel um = new UserModel();
				um.setUserId(rs.getInt(1));
				um.setName(rs.getString(2));
				um.setSex(rs.getShort(3));
				um.setAge(rs.getInt(4));
				umlist.add(um);
			}
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return umlist;
	}
}
