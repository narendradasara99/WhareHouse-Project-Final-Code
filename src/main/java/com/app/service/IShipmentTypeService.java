package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	
	public Integer saveShipmentType(ShipmentType s);
	public  void updateShipmentType(ShipmentType s);
    public  void deleteShipmentType(Integer id);
    public ShipmentType getOneShipmentType(Integer id);
    public List<ShipmentType> getAllShipmentTypes();
    public List<Object[]> getShipmentTypeModeAndCount();
    public List<Object[]> getShipmentTypeIdAndEnable(String enabled);
  
    

}
