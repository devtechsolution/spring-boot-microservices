package org.as.devtechsolution.inventory.repository;
import java.util.Optional;

import org.as.devtechsolution.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findBySkuCode(String skuCode);
}