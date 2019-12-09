package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="grn_dtls")
public class GrnDtl {
	@Id
	@GeneratedValue
	private Integer id;
	private String itemCode;
	private Double baseCost;
	private Integer qnty;
	private Double itemVal;
	
	/* Integrations. Parts */
	@ManyToOne
	@JoinColumn(name="grnIdFk")
	private Grn parent;

	public GrnDtl() {
		super();
	}

	public GrnDtl(Integer id) {
		super();
		this.id = id;
	}
	
	

	public GrnDtl(String itemCode, Double baseCost, Integer qnty, Double itemVal) {
		super();
		
		this.itemCode = itemCode;
		this.baseCost = baseCost;
		this.qnty = qnty;
		this.itemVal = itemVal;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}

	public Integer getQnty() {
		return qnty;
	}

	public void setQnty(Integer qnty) {
		this.qnty = qnty;
	}

	public Double getItemVal() {
		return itemVal;
	}

	public void setItemVal(Double itemVal) {
		this.itemVal = itemVal;
	}

	public Grn getParent() {
		return parent;
	}

	public void setParent(Grn parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "GrnDtl [id=" + id + ", itemCode=" + itemCode + ", baseCost=" + baseCost + ", qnty=" + qnty
				+ ", itemVal=" + itemVal + ", parent=" + parent + "]";
	}
	
	
	
	


	
}
