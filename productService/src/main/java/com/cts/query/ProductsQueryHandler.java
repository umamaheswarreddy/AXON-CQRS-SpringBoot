package com.cts.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cts.data.ProductEntity;
import com.cts.data.ProductRepository;

@Component
public class ProductsQueryHandler {

	private final ProductRepository productRepository;

	public ProductsQueryHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@QueryHandler
	public List<ProductRestModel> getProducts(FindProductQuery findProductQuery) {
		
		List<ProductRestModel> restmodel = new ArrayList<>();
		List<ProductEntity> entities= productRepository.findAll();
		
		for(ProductEntity products:entities) {
			ProductRestModel model=new ProductRestModel();
			BeanUtils.copyProperties(products, model);
			restmodel.add(model);
		}
		return restmodel;
		
	}
}
