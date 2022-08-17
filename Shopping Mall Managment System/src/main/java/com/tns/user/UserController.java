package com.tns.user;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController 
{
 @Autowired
 private UserService service;
private User user;
 
 // RESTful API methods for Retrieval operations
 @GetMapping("/user")
 
 public java.util.List<User> list() 
 {
 return service.listAll();
 }
 //Get particular user id details 
 @GetMapping("/User/{id}")
 public ResponseEntity<User> get(@PathVariable Integer id) 
 {
 try
 {
 User user = service.get(id);
 return new ResponseEntity<User>(user, HttpStatus.OK);
 } 
 catch (NoSuchElementException e) 
 {
 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
 } 
 }
 //  Create or Add user data
 @PostMapping("/user")
 public void add(@RequestBody User user) 
 {
	 service.save(user);
 }
 
 //  Update the data
 @PutMapping("/user/{id}")
 public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) 
 {
 try
 {
	 
 User existUser = service.get(id);
 service.save(user);
 return new ResponseEntity<>(HttpStatus.OK);
 
 } 
 catch (NoSuchElementException e) 
 {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 } 
 }
 
 //  Delete  the user data
 @DeleteMapping("/user/{id}")
 public void delete(@PathVariable Integer id) 
 {
 service.delete(id);
 }
	
	

}


