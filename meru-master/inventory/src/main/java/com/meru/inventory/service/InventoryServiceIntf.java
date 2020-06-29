package com.meru.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meru.inventory.entity.Inventory;

@Service
public interface InventoryServiceIntf {
	
	public List<Inventory> getAllInvetory();
	
	public Inventory getInventoryById(int prodId);
	
	public Inventory addInventory(int productId);
	
	public int deleteInventory(int prodId);
	
	public int updateInventory(int prodId,int qty);

}
