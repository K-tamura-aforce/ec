package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.Member_info;

public class Member_updateDAO extends DAO {
	public int member_update(Member_info member_info) throws Exception {

		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE member_info SET member_info.last_name=?, member_info.first_name=?, member_info.sex=?, member_info.birth_year=?, member_info.birth_month=?, member_info.birth_day=?, member_info.phone_number=?, member_info.mail_address=?, member_info.post_code=?, member_info.address=? WHERE member_info.member_id=?");
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
		st.setString(11, member_info.getMember_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}
