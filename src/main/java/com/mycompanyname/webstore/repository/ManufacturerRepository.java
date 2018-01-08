package com.mycompanyname.webstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycompanyname.webstore.domain.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

	List<Manufacturer> findAll();
	
	Manufacturer findByManufacturerId(int manufacturerId);
}
