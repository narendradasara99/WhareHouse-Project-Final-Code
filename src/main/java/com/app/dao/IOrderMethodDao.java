package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {
	
	public Integer saveOrderMethod(OrderMethod o);
	public  void updateOrderMethod(OrderMethod o);
    public  void deleteOrderMethod(Integer id);
    public OrderMethod getOneOrderMethod(Integer id);
    public List<OrderMethod> getAllOrderMethods();
    public List<Object[]> getOrderModeTypeAndCount();
    public List<Object[]> getOrderMethodIdAndOrderCodes(String mode);
   // public List<Object[]> getOrderMethodIdAndOrderCode();
    
 

}
