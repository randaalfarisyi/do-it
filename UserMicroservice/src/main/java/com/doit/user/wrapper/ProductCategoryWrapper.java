package com.doit.user.wrapper;

import java.util.List;

import com.doit.user.rest.ProductCategoryDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategoryWrapper {
	private List<ProductCategoryDetail> result;

	public List<ProductCategoryDetail> getResult() {
		return result;
	}

	public void setResult(List<ProductCategoryDetail> result) {
		this.result = result;
	}
}
