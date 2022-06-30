package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.Product_info;

public class Product_updateDAO extends DAO {
	public int product_update(Product_info product_info) throws Exception {

		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE product_info SET product_info.product_genre=?, product_info.product_name=?, product_info.product_price=? WHERE product_info.product_id=?");
		st.setString(1, product_info.getProduct_genre());
		st.setString(2, product_info.getProduct_name());
		st.setInt(3, product_info.getProduct_price());
		st.setString(4, product_info.getProduct_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}
