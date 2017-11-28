package com.mycompanyname.webstore.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {

	private int manufacturerId;

	private String name;

	private Set<Category> categorySet = new HashSet<Category>(0);
	
	private Set<Product> productSet = new HashSet<Product>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	@Id
	@Column(name = "MANUFACTURER_ID", nullable = false)
	@GeneratedValue(generator = "manufacturer_seq")
	@SequenceGenerator(name = "manufacturer_seq", sequenceName = "MANUFACTURER_SEQ", allocationSize = 1)
	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "manufacturerSet")
	public Set<Category> getCategorySet() {
		return categorySet;
	}

	public void setCategorySet(Set<Category> categorySet) {
		this.categorySet = categorySet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + manufacturerId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
		if (manufacturerId != other.manufacturerId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manufacturer [manufacturerId=" + manufacturerId + ", name=" + name + "]";
	}

}
