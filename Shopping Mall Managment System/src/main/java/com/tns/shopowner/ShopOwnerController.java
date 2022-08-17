package com.tns.shopowner;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShopOwnerController {
	
	@Autowired
	private ShopOwnerService service;
	private ShopOwner shopowner;
	
	@GetMapping("/shopowner")
	public java.util.List<ShopOwner>list()
	{
		return service.listAll();
	}

	 @GetMapping("/shopowner/{id}")
	 public ResponseEntity<ShopOwner> get(@PathVariable Integer id) 
	 {
	 try
	 {
	 ShopOwner shopowner = service.get(id);
	 return new ResponseEntity<ShopOwner>(shopowner, HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
	 } 
	 }
	
	 // RESTful API method for Create operation
	 @PostMapping("/shopowner")
	 public void add(@RequestBody ShopOwner shopowner) 
	 {
		 service.save(shopowner);
	 }
	
	// RESTful API method for Update operation
	 @PutMapping("/shopowner/{id}")
	 public ResponseEntity<?> update(@RequestBody ShopOwner shopowner, @PathVariable Integer id) 
	 {
	 try
	 {
	 ShopOwner shopowner1 = service.get(id);
	 service.save(shopowner1);
	 return new ResponseEntity<>(HttpStatus.OK);
	 } 
	 catch (NoSuchElementException e) 
	 {
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 } 
	 }
	 
	// RESTful API method for Delete operation
	 @DeleteMapping("/shopowner/{id}")
	 public void delete(@PathVariable Long id) 
	 {
	 service.delete(id);
	 }

	public ShopOwner getShopowner() {
		return shopowner;
	}

	public void setShopowner(ShopOwner shopowner) {
		this.shopowner = shopowner;
	}
	 
	 
}
