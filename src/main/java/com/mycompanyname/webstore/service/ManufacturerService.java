package com.mycompanyname.webstore.service;

import java.util.List;

import com.mycompanyname.webstore.domain.Manufacturer;

public interface ManufacturerService {

	List<Manufacturer> findAll();

	Manufacturer findByManufacturerId(int manufacturerId);
}
