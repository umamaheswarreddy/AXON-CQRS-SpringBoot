package com.cts.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	ProductEntity findByProductIdOrTitle(String productId, String title);
}
