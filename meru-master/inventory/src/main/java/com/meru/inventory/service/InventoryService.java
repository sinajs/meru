package com.meru.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.inventory.entity.Inventory;
import com.meru.inventory.repository.*;

@Service
public class InventoryService implements InventoryServiceIntf {

	@Autowired
	public InventoryRepository repo;

	@Override
	public List<Inventory> getAllInvetory() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Inventory getInventoryById(int prodId) {
		// TODO Auto-generated method stub
		return repo.findById(prodId);
	}

	@Override
	public Inventory addInventory(int productId) {
		// TODO Auto-generated method stub
		Inventory invent= new Inventory();
		invent.setProductId(productId);
		invent.setQty(10);
		return repo.save(invent);
	}

	@Override
	public int deleteInventory(int inventoryId) {
		// TODO Auto-generated method stub

		return repo.updateInventory(inventoryId, 0);
	}

	@Override
	public int updateInventory(int prodId, int qty) {
		return repo.updateInventory(prodId, qty);
	}

}
