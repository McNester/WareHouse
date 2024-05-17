package com.arta.warehouse.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Goods
 */
@Data
@NoArgsConstructor
public class Goods {
	private int id;
	private String name;
	private int quantity;
}
