package jp.co.aforce.beans;

public class Product_info implements java.io.Serializable {

	private String product_id;
	private String product_genre;
	private String product_name;
	private int product_price;

	public String getProduct_id() {
		return product_id;
	}

	public String getProduct_genre() {
		return product_genre;
	}
	public String getProduct_name() {
		return product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setProduct_genre(String product_genre) {
		this.product_genre = product_genre;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

}
