package com.cts;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private CommandGateway commandGateway;
	
	
	
	@PostMapping
	public String postProduct(@RequestBody CreateProductRestModel createProductRestModel) {
		
		CreateProductCommand createProductCommand = CreateProductCommand.builder()
				.title(createProductRestModel.getTitle())
				.price(createProductRestModel.getPrice())
				.quantity(createProductRestModel.getQuantity())
				.productId(UUID.randomUUID().toString())
				.build();
		
		String returnValue;
		
		try {
			returnValue = commandGateway.sendAndWait(createProductCommand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			returnValue=e.getLocalizedMessage();
		}
				
		return returnValue;
	}

}
