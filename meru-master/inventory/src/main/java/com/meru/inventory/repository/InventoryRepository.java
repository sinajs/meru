package com.meru.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meru.inventory.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	@Query("select i from Inventory i where i.productId = :productId")
	public Inventory findById(@Param("productId") int productId);
	
	@Modifying
	@Query("UPDATE Inventory  set qty =:qty where inventoryId = :inventoryId")
	int updateInventory(@Param("inventoryId") int inventoryId, @Param("qty") int qty);

//	@Modifying
//	@Query("UPDATE Inventory where inventoryId =:inventoryId")
//	public int deleteInventory(@Param("inventoryId") int inventoryId);
//	

}
