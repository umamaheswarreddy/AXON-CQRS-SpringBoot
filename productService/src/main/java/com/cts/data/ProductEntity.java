package com.cts.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5465113844278425847L;

	@Id
	@Column(unique = true)
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;

}
