package jp.co.aforce.beans;

public class Purchase_info implements java.io.Serializable {

	private int purchase_num;
	private String purchase_id;
	private String member_id;
	private String purchase_year;
	private String purchase_month;
	private String purchase_day;
	private String product_id;
	private int product_count;
	//	private int purchase_price;
	private String purchase_name;
	private String purchase_post_code;
	private String purchase_address;
	private String payment_method;

	public int getPurchase_num() {
		return purchase_num;
	}

	public String getPurchase_id() {
		return purchase_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getPurchase_year() {
		return purchase_year;
	}

	public String getPurchase_month() {
		return purchase_month;
	}

	public String getPurchase_day() {
		return purchase_day;
	}

	public String getProduct_id() {
		return product_id;
	}

	public int getProduct_count() {
		return product_count;
	}

	//	public int getPurchase_price() {
	//		return purchase_price;
	//	}

	public String getPurchase_name() {
		return purchase_name;
	}

	public String getPurchase_post_code() {
		return purchase_post_code;
	}

	public String getPurchase_address() {
		return purchase_address;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPurchase_num(int purchase_num) {
		this.purchase_num = purchase_num;
	}

	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public void setPurchase_year(String purchase_year) {
		this.purchase_year = purchase_year;
	}

	public void setPurchase_month(String purchase_month) {
		this.purchase_month = purchase_month;
	}

	public void setPurchase_day(String purchase_day) {
		this.purchase_day = purchase_day;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	//	public void setPurchase_price(int purchase_price) {
	//		this.purchase_price = purchase_price;
	//	}

	public void setPurchase_name(String purchase_name) {
		this.purchase_name = purchase_name;
	}

	public void setPurchase_post_code(String purchase_post_code) {
		this.purchase_post_code = purchase_post_code;
	}

	public void setPurchase_address(String purchase_address) {
		this.purchase_address = purchase_address;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

}
