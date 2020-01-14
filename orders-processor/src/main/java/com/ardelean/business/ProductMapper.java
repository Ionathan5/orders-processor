package com.ardelean.business;

import com.ardelean.model.InputProduct;
import com.ardelean.model.OutputProduct;

public class ProductMapper {

	public static OutputProduct map(InputProduct source, int id) {
		OutputProduct target = new OutputProduct();
		target.setDescription(source.getDescription());
		target.setGtin(source.getGtin());
		target.setPrice(source.getPrice());
		target.setOrderid(id);
		return target;
	}
}
