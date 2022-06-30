package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Member_info;

public class Member_registDAO extends DAO {
	public int member_select_count(Member_info member_info)
			throws Exception {
		int count = 0;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT COUNT(*)  FROM  member_info WHERE last_name=? AND first_name=? AND sex=? AND birth_year=? AND birth_month=? AND birth_day=? AND phone_number=? AND mail_address=? AND post_code=? AND address=?");
		st.setString(1, member_info.getLast_name());
		st.setString(2, member_info.getFirst_name());
		st.setString(3, member_info.getSex());
		st.setInt(4, member_info.getBirth_year());
		st.setInt(5, member_info.getBirth_month());
		st.setInt(6, member_info.getBirth_day());
		st.setString(7, member_info.getPhone_number());
		st.setString(8, member_info.getMail_address());
		st.setString(9, member_info.getPost_code());
		st.setString(10, member_info.getAddress());
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}

		st.close();
		con.close();

		return count;
	}

	public int member_regist(Member_info member_info) throws Exception {
		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO   member_info(member_id, last_name, first_name, sex, birth_year, birth_month, birth_day, phone_number, mail_address, post_code, address, password)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, member_info.getMember_id());
		st.setString(2, member_info.getLast_name());
		st.setString(3, member_info.getFirst_name());
		st.setString(4, member_info.getSex());
		st.setInt(5, member_info.getBirth_year());
		st.setInt(6, member_info.getBirth_month());
		st.setInt(7, member_info.getBirth_day());
		st.setString(8, member_info.getPhone_number());
		st.setString(9, member_info.getMail_address());
		st.setString(10, member_info.getPost_code());
		st.setString(11, member_info.getAddress());
		st.setString(12, member_info.getPassword());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}
