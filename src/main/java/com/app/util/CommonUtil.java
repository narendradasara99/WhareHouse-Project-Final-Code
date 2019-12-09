package com.app.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	public static Map<Integer,String> convertData(List<Object[]> list){
		Map<Integer,String> map=new HashMap<Integer,String>();
			for(Object[] ob:list) {
				map.put(new Integer(ob[0].toString()),ob[1].toString());
			}
		return map;
		
	}

}
