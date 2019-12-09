package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipmenttab")
public class ShipmentType {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer  id;
	@Column(name="sMode")
	private  String shipmentTypeMode;
	@Column(name="sCode")
	private String shipmentTypeCode;
	@Column(name="eShipment")
	private String  enableShipmentType;
	@Column(name="sGrade")
	private String shipmentTypeGrade;
	@Column(name="note")
	private String description;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShipmentTypeMode() {
		return shipmentTypeMode;
	}
	public void setShipmentTypeMode(String shipmentTypeMode) {
		this.shipmentTypeMode = shipmentTypeMode;
	}
	public String getShipmentTypeCode() {
		return shipmentTypeCode;
	}
	public void setShipmentTypeCode(String shipmentTypeCode) {
		this.shipmentTypeCode = shipmentTypeCode;
	}
	public String getEnableShipmentType() {
		return enableShipmentType;
	}
	public void setEnableShipmentType(String enableShipmentType) {
		this.enableShipmentType = enableShipmentType;
	}
	public String getShipmentTypeGrade() {
		return shipmentTypeGrade;
	}
	public void setShipmentTypeGrade(String shipmentTypeGrade) {
		this.shipmentTypeGrade = shipmentTypeGrade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentTypeMode=" + shipmentTypeMode + ", shipmentTypeCode="
				+ shipmentTypeCode + ", enableShipmentType=" + enableShipmentType + ", shipmentTypeGrade="
				+ shipmentTypeGrade + ", description=" + description + "]";
	}


}







