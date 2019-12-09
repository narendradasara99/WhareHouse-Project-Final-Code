package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pdtltab")
public class PurchaseDtl {
@Id	
@GeneratedValue
	private Integer id;
	@Transient
  private  Integer slno;
  private Integer qty;
  @ManyToOne
  @JoinColumn(name="partIdFk")
  private Part part;
  
	/* Bi-Directional Mapping */
  @ManyToOne
  @JoinColumn(name="poIdFk")
  private  Purchase parent;

	public PurchaseDtl() {
		super();
	}

	public PurchaseDtl(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSlno() {
		return slno;
	}

	public void setSlno(Integer slno) {
		this.slno = slno;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Purchase getParent() {
		return parent;
	}

	public void setParent(Purchase parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "PurchaseDtl [id=" + id + ", slno=" + slno + ", qty=" + qty + ", part=" + part + ", parent=" + parent
				+ "]";
	}





}
