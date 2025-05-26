package org.siva.mobilestore.repository;

import java.util.List;

import org.siva.mobilestore.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {
	
	List<Mobile> findByBrandContainingIgnoreCase(String brand);

}
