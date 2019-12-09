package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	
	public Integer saveWhUserType(WhUserType u);
	public  void updateWhUserType(WhUserType u);
    public  void deleteWhUserType(Integer id);
    public WhUserType getOneWhUserType (Integer id);
    public List<WhUserType> getAllWhUserTypes();
    public List<Object[]> getWhuserTypeAndCount();
    public List<Object[]> getWhUserTypeIdAndCode(String userType);
    

}
