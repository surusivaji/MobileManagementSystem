package org.siva.mobilestore.service;

import java.util.List;

import org.siva.mobilestore.model.Mobile;
import org.springframework.data.domain.Page;

public interface IMobileService {
	
	Mobile saveMobile(Mobile mobile);
	
	Page<Mobile> getAllMobiles(int pageNo);
	
	Mobile getMobileById(Integer id);
	
	Boolean deleteMobile(Mobile mobile);
	
	List<Mobile> searchMobilesByBrand(String brand);

}
