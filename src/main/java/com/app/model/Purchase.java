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
@Table(name="purchasetab")
public class Purchase {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	@Column(name="pCode")
	private String	orderCode;
	@Column(name="pqcheck")
	private	 String qualityCheck;
	@Column(name="pdStatus")
	private String	defectStatus;
	@Column(name="prNumber")
	private	 String refrenceNumber;
	@Column(name="DESCRIPTION")
	private String	description;
	@ManyToOne
	@JoinColumn(name="whcodeIdFk")
	private WhUserType  whcode;
	@ManyToOne
	@JoinColumn(name="shipmentCodeIdFk")
	private ShipmentType shipmentMode;
	
	/* Getting parts Data */
	/* Bi-directional */
	@OneToMany(mappedBy = "parent",fetch=FetchType.EAGER)
	private List<PurchaseDtl> childs;
	
	

	public Purchase() {
		super();
	}

	public Purchase(Integer id) {
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

	public String getQualityCheck() {
		return qualityCheck;
	}

	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}

	public String getDefectStatus() {
		return defectStatus;
	}

	public void setDefectStatus(String defectStatus) {
		this.defectStatus = defectStatus;
	}

	public String getRefrenceNumber() {
		return refrenceNumber;
	}

	public void setRefrenceNumber(String refrenceNumber) {
		this.refrenceNumber = refrenceNumber;
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

	public List<PurchaseDtl> getChilds() {
		return childs;
	}

	public void setChilds(List<PurchaseDtl> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", orderCode=" + orderCode + ", qualityCheck=" + qualityCheck + ", defectStatus="
				+ defectStatus + ", refrenceNumber=" + refrenceNumber + ", description=" + description + ", whcode="
				+ whcode + ", shipmentMode=" + shipmentMode + ", childs=" + childs + "]";
	}


}
