package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.Product_info;

public class Product_deleteDAO extends DAO {
	public int product_delete(Product_info product_info) throws Exception{
		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM product_info WHERE product_info.product_id=?");
		st.setString(1, product_info.getProduct_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

}
