package com.app.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="saletable")
public class Sale {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer	id;
	@Column(name="saleCode")
	private String	orderCode;
	@Column(name="refnumber")
	private String	refNumber;
	@Column(name="stockMode")
	private String	stockMode;
	@Column(name="stockSource")
	private String	stockSource;
	
	@Column(name="status")
	private String saleOrderStatus;
	@Column(name="DESCRIPTION")
	private String	description;
	@ManyToOne
	@JoinColumn(name="whcodesIdFK")
	private WhUserType  whcode;
	@ManyToOne
	@JoinColumn(name="shipmentcodeIdFK")
	private ShipmentType shipmentMode;
	

	/* Getting parts Data */
	@OneToMany(mappedBy = "parent",fetch=FetchType.EAGER)
	private List<SaleDtl> childs;


	public Sale() {
		super();
	}


	public Sale(Integer id) {
		super();
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	public String getRefNumber() {
		return refNumber;
	}


	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}


	public String getStockMode() {
		return stockMode;
	}


	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}


	public String getStockSource() {
		return stockSource;
	}


	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}


	public String getSaleOrderStatus() {
		return saleOrderStatus;
	}


	public void setSaleOrderStatus(String saleOrderStatus) {
		this.saleOrderStatus = saleOrderStatus;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public WhUserType getWhcode() {
		return whcode;
	}


	public void setWhcode(WhUserType whcode) {
		this.whcode = whcode;
	}


	public ShipmentType getShipmentMode() {
		return shipmentMode;
	}


	public void setShipmentMode(ShipmentType shipmentMode) {
		this.shipmentMode = shipmentMode;
	}


	public List<SaleDtl> getChilds() {
		return childs;
	}


	public void setChilds(List<SaleDtl> childs) {
		this.childs = childs;
	}


	@Override
	public String toString() {
		return "Sale [id=" + id + ", orderCode=" + orderCode + ", refNumber=" + refNumber + ", stockMode=" + stockMode
				+ ", stockSource=" + stockSource + ", saleOrderStatus=" + saleOrderStatus + ", description="
				+ description + ", whcode=" + whcode + ", shipmentMode=" + shipmentMode + ", childs=" + childs + "]";
	}




}
