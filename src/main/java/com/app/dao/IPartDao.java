package com.app.dao;

import java.util.List;

import com.app.model.Part;

public interface IPartDao {
	public  Integer savePart(Part part );
	public  void updatepart(Part part);
	public  void deletePart(Integer id);
	public Part getOnePart(Integer id);
	public  List<Part>  getAllParts();	
	public List<Object[]> getPartBaseCurrencyAndCount();
	
	public List<Object[]> getPartIdAndCodes();
	
	

	

}
