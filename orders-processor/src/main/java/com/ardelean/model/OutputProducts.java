package com.ardelean.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutputProducts {
	
    @XmlElement(name = "product")
	private List<OutputProduct> products;

	public List<OutputProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OutputProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutputProducts [products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}

}

