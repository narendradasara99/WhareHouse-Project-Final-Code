package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_tab")
public class Shipping {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	private String shippingCode;
	private String shippingRefNum;
	private String billToaddress;
	private String corierRefNum;
	private String contactDetails;
	private String shipToAddress;
	private String description;
	/*
	 * Integration
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="saleOrderId") private Sale saleOrder;
	 */

	/*** Integrations **/
	// 1...1
	@ManyToOne
	@JoinColumn(name = "saleIdFk", unique = true)
	private Sale saleOrder;
	@OneToMany(cascade=CascadeType.ALL)
	//@OneToMany(mappedBy = "parent")
	@JoinColumn(name="shipIdfk")
	private List<ShippingDtl> childs;

	public Shipping() {
		super();
	}

	public Shipping(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public String getShippingRefNum() {
		return shippingRefNum;
	}

	public void setShippingRefNum(String shippingRefNum) {
		this.shippingRefNum = shippingRefNum;
	}

	public String getBillToaddress() {
		return billToaddress;
	}

	public void setBillToaddress(String billToaddress) {
		this.billToaddress = billToaddress;
	}

	public String getCorierRefNum() {
		return corierRefNum;
	}

	public void setCorierRefNum(String corierRefNum) {
		this.corierRefNum = corierRefNum;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}


	public String getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Sale getSaleOrder() {
		return saleOrder;
	}

	public void setSaleOrder(Sale saleOrder) {
		this.saleOrder = saleOrder;
	}



	public List<ShippingDtl> getChilds(List<ShippingDtl> purdtls) {
		return childs;
	}

	public void setChilds(List<ShippingDtl> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "Shipping [id=" + id + ", shippingCode=" + shippingCode + ", shippingRefNum=" + shippingRefNum
				+ ", billToaddress=" + billToaddress + ", corierRefNum=" + corierRefNum + ", contactDetails="
				+ contactDetails + ", shipToAddress=" + shipToAddress
				+ ", description=" + description + ", saleOrder=" + saleOrder + ", childs=" + childs
				+ "]";
	}

}
