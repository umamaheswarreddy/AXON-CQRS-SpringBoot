package com.cts.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cts.ProductCreatedEvent;
import com.cts.data.ProductEntity;
import com.cts.data.ProductRepository;

@Component
public class ProductEventHandler {

	private final ProductRepository productRepository;

	public ProductEventHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@EventHandler
	public void on(ProductCreatedEvent event) {

		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(event, productEntity);

		productRepository.save(productEntity);

	}

}
