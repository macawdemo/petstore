package io.macaw.demo.petstore.ordersservice.mysql.db.dto;

import java.util.Date;

import io.macaw.db.mysql.utils.BaseDTO;

public class Order  extends BaseDTO {

	public Order() {
		
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getShipaddr1() {
		return shipaddr1;
	}
	public void setShipaddr1(String shipaddr1) {
		this.shipaddr1 = shipaddr1;
	}
	public String getShipaddr2() {
		return shipaddr2;
	}
	public void setShipaddr2(String shipaddr2) {
		this.shipaddr2 = shipaddr2;
	}
	public String getShipcity() {
		return shipcity;
	}
	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}
	public String getShipstate() {
		return shipstate;
	}
	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}
	public String getShipzip() {
		return shipzip;
	}
	public void setShipzip(String shipzip) {
		this.shipzip = shipzip;
	}
	public String getShipcountry() {
		return shipcountry;
	}
	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}
	public String getBilladdr1() {
		return billaddr1;
	}
	public void setBilladdr1(String billaddr1) {
		this.billaddr1 = billaddr1;
	}
	public String getBilladdr2() {
		return billaddr2;
	}
	public void setBilladdr2(String billaddr2) {
		this.billaddr2 = billaddr2;
	}
	public String getBillstate() {
		return billstate;
	}
	public void setBillstate(String billstate) {
		this.billstate = billstate;
	}
	public String getBillzip() {
		return billzip;
	}
	public void setBillzip(String billzip) {
		this.billzip = billzip;
	}
	public String getBillcountry() {
		return billcountry;
	}
	public void setBillcountry(String billcountry) {
		this.billcountry = billcountry;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public String getBilltofirstname() {
		return billtofirstname;
	}
	public void setBilltofirstname(String billtofirstname) {
		this.billtofirstname = billtofirstname;
	}
	public String getBilltolastname() {
		return billtolastname;
	}
	public void setBilltolastname(String billtolastname) {
		this.billtolastname = billtolastname;
	}
	public String getShiptofirstname() {
		return shiptofirstname;
	}
	public void setShiptofirstname(String shiptofirstname) {
		this.shiptofirstname = shiptofirstname;
	}
	public String getShiptolastname() {
		return shiptolastname;
	}
	public void setShiptolastname(String shiptolastname) {
		this.shiptolastname = shiptolastname;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public Date getShipdate() {
		return shipdate;
	}
	public void setShipdate(Date shipdate) {
		this.shipdate = shipdate;
	}
	private String orderid;
	private String userid;
	private Date orderdate;
	private String shipaddr1;
	private String shipaddr2;
	private String shipcity;
	private String shipstate;
	private String shipzip;
	private String shipcountry;
	private String billaddr1;
	private String billaddr2;
	private String billstate;
	private String billzip;
	private String billcountry;
	private String courier;
	private Double totalprice;
	private Date shipdate;
	private String billtofirstname;
	private String billtolastname;
	private String shiptofirstname;
	private String shiptolastname;
	private String creditcard;
	private Date expirydate;
	private String cardtype;
	private String locale;
}
