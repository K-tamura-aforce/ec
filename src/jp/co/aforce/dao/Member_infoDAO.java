package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Member_info;

public class Member_infoDAO extends DAO {
	public Member_info search(String member_id, String password)
			throws Exception {
		Member_info member_info = null;

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("SELECT * FROM member_info where member_id=? and password=BINARY ?");
		st.setString(1, member_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			member_info = new Member_info();
			member_info.setMember_id(rs.getString("member_id"));
			member_info.setLast_name(rs.getString("last_name"));
			member_info.setFirst_name(rs.getString("first_name"));
			member_info.setSex(rs.getString("sex"));
			member_info.setBirth_year(rs.getInt("birth_year"));
			member_info.setBirth_month(rs.getInt("birth_month"));
			member_info.setBirth_day(rs.getInt("birth_day"));
			member_info.setPhone_number(rs.getString("phone_number"));
			member_info.setMail_address(rs.getString("mail_address"));
			member_info.setPost_code(rs.getString("post_code"));
			member_info.setAddress(rs.getString("address"));

		}

		st.close();
		con.close();

		return member_info;
	}

public Member_info member_display_search(String member_id)
		throws Exception {
	Member_info member_info = null;

	Connection con = getConnection();

	PreparedStatement st = con.prepareStatement("SELECT * FROM member_info where member_id=?");
	st.setString(1, member_id);
	ResultSet rs = st.executeQuery();

	while (rs.next()) {
		member_info = new Member_info();
		member_info.setMember_id(rs.getString("member_id"));
		member_info.setLast_name(rs.getString("last_name"));
		member_info.setFirst_name(rs.getString("first_name"));
		member_info.setSex(rs.getString("sex"));
		member_info.setBirth_year(rs.getInt("birth_year"));
		member_info.setBirth_month(rs.getInt("birth_month"));
		member_info.setBirth_day(rs.getInt("birth_day"));
		member_info.setPhone_number(rs.getString("phone_number"));
		member_info.setMail_address(rs.getString("mail_address"));
		member_info.setPost_code(rs.getString("post_code"));
		member_info.setAddress(rs.getString("address"));

	}

	st.close();
	con.close();

	return member_info;
}

}
