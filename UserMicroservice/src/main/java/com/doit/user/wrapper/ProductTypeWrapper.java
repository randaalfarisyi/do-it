package com.doit.user.wrapper;

import java.util.List;

import com.doit.user.rest.ProductTypeDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeWrapper {
	private List<ProductTypeDetail> result;

	public List<ProductTypeDetail> getResult() {
		return result;
	}

	public void setResult(List<ProductTypeDetail> result) {
		this.result = result;
	}
}
