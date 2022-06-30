package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Product_info;

public class Product_infoDAO extends DAO {
	public Product_info searchProduct(String product_id)
			throws Exception {
		Product_info product_info = null;

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("SELECT * FROM product_info where product_id=?");
		st.setString(1, product_id);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			product_info = new Product_info();
			product_info.setProduct_id(rs.getString("product_id"));
			product_info.setProduct_genre(rs.getString("product_genre"));
			product_info.setProduct_name(rs.getString("product_name"));
			product_info.setProduct_price(rs.getInt("product_price"));

		}

		st.close();
		con.close();

		return product_info;
	}

	public List<Product_info> search(String keyword) throws Exception {
		List<Product_info> list = new ArrayList<>();
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("SELECT * FROM product_info WHERE product_name like ?");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Product_info product_info = new Product_info();
			product_info.setProduct_id(rs.getString("product_id"));
			product_info.setProduct_genre(rs.getString("product_genre"));
			product_info.setProduct_name(rs.getString("product_name"));
			product_info.setProduct_price(rs.getInt("product_price"));
			list.add(product_info);
		}

		st.close();
		con.close();

		return list;
	}

}
