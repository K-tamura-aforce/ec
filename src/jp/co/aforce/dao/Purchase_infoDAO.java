package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.Member_info;
import jp.co.aforce.beans.Product_info;
import jp.co.aforce.beans.Purchase_info;

public class Purchase_infoDAO extends DAO {

	public boolean insert(Member_info member_info, Purchase_info purchase_info, List<Item> cart) throws Exception {
		int line = 0;
		Connection con = getConnection();
		con.setAutoCommit(false);

		for (Item item : cart) {
			PreparedStatement st = con.prepareStatement(
					"INSERT INTO  purchase_info(purchase_num, purchase_id, member_id, purchase_year, purchase_month, purchase_day, product_id, product_count, purchase_name, purchase_post_code, purchase_address, payment_method)VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			Product_info product_info = item.getProduct_info();
			st.setString(1, purchase_info.getPurchase_id());
			st.setString(2, member_info.getMember_id());
			st.setString(3, purchase_info.getPurchase_year());
			st.setString(4, purchase_info.getPurchase_month());
			st.setString(5, purchase_info.getPurchase_day());
			st.setString(6, product_info.getProduct_id());
			st.setInt(7, item.getProduct_count());
//			st.setInt(5, purchase_info.getPurchase_price());
			st.setString(8, purchase_info.getPurchase_name());
			st.setString(9, purchase_info.getPurchase_post_code());
			st.setString(10, purchase_info.getPurchase_address());
			st.setString(11, purchase_info.getPayment_method());
			line = st.executeUpdate();
			st.close();

			if (line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false;

			}

		}

		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;

	}

}
