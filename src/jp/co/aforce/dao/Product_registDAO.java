package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Product_info;

public class Product_registDAO extends DAO {
	public int product_select_count(Product_info product_info)
			throws Exception {
		int count = 0;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT COUNT(*)  FROM  product_info WHERE product_genre=? AND product_name=? AND product_price=?");
		st.setString(1, product_info.getProduct_genre());
		st.setString(2, product_info.getProduct_name());
		st.setInt(3, product_info.getProduct_price());
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}

		st.close();
		con.close();

		return count;
	}

	public int product_regist(Product_info product_info) throws Exception {
		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO product_info(product_id, product_genre, product_name, product_price) VALUES(?, ?, ?, ?)");
		st.setString(1, product_info.getProduct_id());
		st.setString(2, product_info.getProduct_genre());
		st.setString(3, product_info.getProduct_name());
		st.setInt(4, product_info.getProduct_price());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}
