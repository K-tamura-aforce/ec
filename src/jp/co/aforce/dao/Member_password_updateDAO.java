package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Member_info;

public class Member_password_updateDAO extends DAO {
	public int member_password_select_count(String password)
			throws Exception {
		int count = 0;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT COUNT(*)  FROM  member_info WHERE password=?");
		st.setString(1, password);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}

		st.close();
		con.close();

		return count;
	}

	public int member_password_update(Member_info member_info) throws Exception {

		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE member_info SET member_info.password=? WHERE member_info.member_id=?");
		st.setString(1, member_info.getPassword());
		st.setString(2, member_info.getMember_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}

