package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="omtab")
public class OrderMethod {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer  id;
	@Column(name="mode")
	private  String orderMode;
	@Column(name="code")
	private String orderCode;
	@Column(name="type")
	private String  orderType;
	@Column(name="note")
	private String description;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="orderaccepttab",joinColumns = @JoinColumn(name="id"))
	@Column(name="accept")
	private List<String> orderAccept;
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getOrderAccept() {
		return orderAccept;
	}
	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", orderType="
				+ orderType + ", description=" + description + ", orderAccept=" + orderAccept + "]";
	}
	



}







