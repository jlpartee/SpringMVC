package springmvc.service;

import java.util.LinkedList;
import java.util.List;

import springmvc.model.Brand;

public class BrandManager {

	private static List<Brand> brandList;
	
	static {
		Brand brand1 = new Brand();
		brand1.setId((long)1);
		brand1.setName("Mercedes");
		brand1.setCountry("Germany");
		
		Brand brand2 = new Brand();
		brand2.setId((long)2);
		brand2.setName("peugeot");
		brand2.setCountry("France");
		
		brandList = new LinkedList<Brand>();
		brandList.add(brand1);
		brandList.add(brand2);
	}
	
	public List<Brand> getBrandList() {
		return brandList;
	}
	
	public Brand getBrandById(Long id) {
		for (Brand brand : brandList) {
			if (brand.getId().equals(id))
					return brand;
		}
		return null;
	}
}
