package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="parttab")
public class Part {
	///For integrations
	@ManyToOne
	@JoinColumn(name="uomIdFk")
	private  Uom uom;
	@ManyToOne
	@JoinColumn(name="saleIdFk")
	private OrderMethod ordermethodSale;
	@ManyToOne
	@JoinColumn(name="purchaseIdFk")
	private OrderMethod omPurchase;
	//end code.....
	@Id
	@Column(name="id")
	@GeneratedValue	
private Integer id;	
@Column(name="code")	
private String	code;
private Double width;
private Double length;
private Double heigth;
@Column(name="cost")
private Double	baseCost;
@Column(name="currency")
private String baseCurrency;
@Column(name="Note")
private String description;
public Part() {
	super();
}
public Part(Integer id) {
	super();
	this.id = id;
}
public Uom getUom() {
	return uom;
}
public void setUom(Uom uom) {
	this.uom = uom;
}
public OrderMethod getOrdermethodSale() {
	return ordermethodSale;
}
public void setOrdermethodSale(OrderMethod ordermethodSale) {
	this.ordermethodSale = ordermethodSale;
}
public OrderMethod getOmPurchase() {
	return omPurchase;
}
public void setOmPurchase(OrderMethod omPurchase) {
	this.omPurchase = omPurchase;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Double getWidth() {
	return width;
}
public void setWidth(Double width) {
	this.width = width;
}
public Double getLength() {
	return length;
}
public void setLength(Double length) {
	this.length = length;
}
public Double getHeigth() {
	return heigth;
}
public void setHeigth(Double heigth) {
	this.heigth = heigth;
}
public Double getBaseCost() {
	return baseCost;
}
public void setBaseCost(Double baseCost) {
	this.baseCost = baseCost;
}
public String getBaseCurrency() {
	return baseCurrency;
}
public void setBaseCurrency(String baseCurrency) {
	this.baseCurrency = baseCurrency;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Part [uom=" + uom + ", ordermethodSale=" + ordermethodSale + ", omPurchase=" + omPurchase + ", id=" + id
			+ ", code=" + code + ", width=" + width + ", length=" + length + ", heigth=" + heigth + ", baseCost="
			+ baseCost + ", baseCurrency=" + baseCurrency + ", description=" + description + "]";
}






}
