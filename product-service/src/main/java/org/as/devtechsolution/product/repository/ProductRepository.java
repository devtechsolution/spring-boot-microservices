package org.as.devtechsolution.product.repository;

import org.as.devtechsolution.product.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}