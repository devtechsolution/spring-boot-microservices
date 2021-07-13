package org.as.devtechsolution.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryClient {
	
    @GetMapping("/api/inventory/{skuCode}")
    Boolean checkStock(@PathVariable("skuCode") String skuCode);
}