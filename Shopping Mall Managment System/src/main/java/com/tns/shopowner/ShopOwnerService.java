package com.tns.shopowner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopOwnerService {

@Autowired
private ShopOwnerRepository repo;
	
	public List<ShopOwner> listAll() {
		return repo.findAll();
	}
	
	public ShopOwner save(ShopOwner ShopOwner) {
		repo.save(ShopOwner);
		return ShopOwner;
	}
	
	public ShopOwner get(Integer id) {
		return repo.findAll().get(id);
		
	}

	public void delete(Long id) 
	 {
	repo.deleteAll();
	 
	}
}


