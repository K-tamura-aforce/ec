package jp.co.aforce.beans;

public class Item implements java.io.Serializable {

	private Product_info product_info;
	private int product_count;
	private int product_subtotal;

	public Product_info getProduct_info() {
		return product_info;
	}

	public int getProduct_count() {
		return product_count;
	}

	public int getProduct_subtotal() {
		return product_subtotal;
	}


	public void setProduct_info(Product_info product_info) {
		this.product_info = product_info;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public void setProduct_subtotal(int product_subtotal) {
		this.product_subtotal = product_subtotal;
	}


}
