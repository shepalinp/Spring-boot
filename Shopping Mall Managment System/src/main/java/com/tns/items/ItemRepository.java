package com.tns.items;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ItemRepository extends JpaRepository<Item, Integer> 
{
	
}
