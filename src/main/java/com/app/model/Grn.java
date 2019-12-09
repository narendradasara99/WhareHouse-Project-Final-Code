package com.app.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grntab")
public final class Grn {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	private String code;
	private String grnType;
	private String note;
	
	/***Integrations**/
	//1...1
	@ManyToOne
	@JoinColumn(name="poIdFk",unique=true)
	private Purchase purchase;
	
	//@OneToMany(cascade=CascadeType.ALL)
	@OneToMany(mappedBy = "parent")
	private List<GrnDtl> childs;
	
	
	public Grn() {
		super();
	}
	public Grn(Integer id) {
		super();
		this.id = id;
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
	public String getGrnType() {
		return grnType;
	}
	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public List<GrnDtl> getChilds() {
		return childs;
	}
	public void setChilds(List<GrnDtl> childs) {
		this.childs = childs;
	}
	@Override
	public String toString() {
		return "Grn [id=" + id + ", code=" + code + ", grnType=" + grnType + ", note=" + note + ", purchase=" + purchase
				+ ", childs=" + childs + "]";
	}
	
	
	
	
	
}
