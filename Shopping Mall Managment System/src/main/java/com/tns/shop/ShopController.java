package com.tns.shop;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

	@Autowired
	private ShopService service;
	
	@GetMapping("/shop")
	public List<Shop> list() {
		return service.listAll();
	}
	
	@GetMapping("/shops/{id}")
	public ResponseEntity<Shop> get(@PathVariable Integer id) {
		try {
			Shop shop = service.get(id);
			return new ResponseEntity<Shop>(shop, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Shop>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/shops")
	public void add(@RequestBody Shop shop) {
		service.save(shop);
	}
	
	@PutMapping("/shops/{id}")
	public ResponseEntity<?> update(@RequestBody Shop shop, @PathVariable Integer id) {
		try {
			Shop existShop = service.get(id);
			service.save(shop);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/shops/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
