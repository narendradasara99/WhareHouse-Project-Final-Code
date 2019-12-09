package com.app.dao;

import java.util.List;

import com.app.model.Purchase;
import com.app.model.PurchaseDtl;

public interface IPurchaseDao {
	public  Integer savePurchase(Purchase purchase);
	public  void updatePurchse(Purchase purchase);
	public  void deletePurchse(Integer id);
	public Purchase getOnePurchase(Integer id);
	public  List<Purchase>  getAllPurchases();	
	public List<Object[]> getPurchaseQualityCheckAndCount();
	public List<Object[]> getPartAndCodes();
	
	public Integer savePurchaseDtl(PurchaseDtl purchaseDtl);
	
	public void deletePurchaseDtl(Integer id);
	
public 	List<Object[]> getPurchaseIdAndCode();
	
public	void updateStatusById(Integer id,String defectStatus);

}
