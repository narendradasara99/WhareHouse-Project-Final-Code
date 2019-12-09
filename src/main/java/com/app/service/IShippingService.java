package com.app.service;

import java.util.List;


import com.app.model.Shipping;
import com.app.model.ShippingDtl;

public interface IShippingService {
	public Integer saveShipping(Shipping shipping);
	public void updateShipping(Shipping shipping);
	public void deleteShipping(Integer id);
	public Shipping getOneShipping(Integer id);
	public List<Shipping> getAllShippings();
	
	
	public Integer saveShippingDtl(ShippingDtl dtl);
	public List<ShippingDtl> getShippingDtlByShippingId(Integer id);

}
