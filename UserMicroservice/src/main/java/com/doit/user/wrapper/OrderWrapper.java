package com.doit.user.wrapper;

import java.util.List;

import com.doit.user.rest.OrderDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderWrapper {
	private List<OrderDetail> result;

	public List<OrderDetail> getResult() {
		return result;
	}

	public void setResult(List<OrderDetail> result) {
		this.result = result;
	}
}
