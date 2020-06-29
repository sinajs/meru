package com.meru.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meru.inventory.entity.Inventory;
import com.meru.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	InventoryService service;
	
	public InventoryController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method=RequestMethod.GET, value="/invent", produces="application/json")
	ResponseEntity<List<Inventory>> getAllInventory(){
		return new ResponseEntity<List<Inventory>>(service.getAllInvetory(),HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/invent/{prodId}", produces="application/json")
	ResponseEntity<Inventory> getInventoryById(@PathVariable int prodId){
		return new ResponseEntity<Inventory>(service.getInventoryById(prodId),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/invent/add/{productId}", produces="application/json")
	ResponseEntity<Inventory> addInventory(@PathVariable int productId){
		Inventory iobj=service.addInventory(productId);
		return ResponseEntity.ok().body(iobj);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/invent/update/{prodId}", produces="application/json")
	ResponseEntity<Inventory> updateInventory(@PathVariable int prodId){
		return new ResponseEntity<Inventory>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/invent/delete/{prodId}", produces="application/json")
	ResponseEntity<Inventory> deleteInventory(@PathVariable int prodId){
		return new ResponseEntity<Inventory>(HttpStatus.OK);
	}

}
