package org.siva.mobilestore.service;

import java.util.List;
import java.util.Optional;

import org.siva.mobilestore.model.Mobile;
import org.siva.mobilestore.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Service
public class IMobileServiceImpl implements IMobileService {
	
	@Autowired
	private MobileRepository mobileRepository;
	
	@Override
	public Mobile saveMobile(Mobile mobile) {
		try {
			Mobile save = mobileRepository.save(mobile);
			return save;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Page<Mobile> getAllMobiles(int pageNo) {
		try {	
			Pageable pageable = PageRequest.of(pageNo, 5);
			Page<Mobile> page = mobileRepository.findAll(pageable);
			return page;
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Mobile getMobileById(Integer id) {
		try {
			Optional<Mobile> optional = mobileRepository.findById(id);
			return optional.get();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Boolean deleteMobile(Mobile mobile) {
		try {
			mobileRepository.delete(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<Mobile> searchMobilesByBrand(String brand) {
		try {
			List<Mobile> mobiles = mobileRepository.findByBrandContainingIgnoreCase(brand);
			return mobiles;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("failMsg");
		session.removeAttribute("successMsg");
		session.removeAttribute("warningMsg");
	}

}
