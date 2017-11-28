package com.mycompanyname.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompanyname.webstore.domain.Manufacturer;
import com.mycompanyname.webstore.domain.repository.ManufacturerRepository;
import com.mycompanyname.webstore.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Override
	public List<Manufacturer> findAll() {
		return manufacturerRepository.findAll();
	}

	@Override
	public Manufacturer findByManufacturerId(int manufacturerId) {
		return manufacturerRepository.findByManufacturerId(manufacturerId);
	}
}
