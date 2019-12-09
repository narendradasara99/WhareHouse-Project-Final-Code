package com.app.dao;

import java.util.List;
import com.app.model.Grn;
import com.app.model.GrnDtl;
public interface IGrnDao {
	Integer saveGrn(Grn grn);
	void updateGrn(Grn grn);
	void deleteGrn(Integer id);
	Grn getOneGrn(Integer id);
	List<Grn> getAllGrns();
    public List<Object[]> getGrnTypeAndCount();

	/* Integration */
  public  Integer saveGrnDtl(GrnDtl dtl);
    public List<GrnDtl> getGrnDtlByGrnId(Integer id);
    
    
    
    
 

}
