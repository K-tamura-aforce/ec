package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.Member_info;

public class Member_deleteDAO extends DAO {
	public int member_delete(Member_info member_info) throws Exception{
		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM member_info WHERE member_info.member_id=?");
		st.setString(1, member_info.getMember_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

}
