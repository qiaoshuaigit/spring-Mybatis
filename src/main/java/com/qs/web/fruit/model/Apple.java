package com.qs.web.fruit.model;

import java.io.Serializable;

public class Apple implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8264392783009412161L;

	private Integer id;
	
	private String name;
	
	private String sale;
	
	private String rank;
	
	private String field;
	
	private Integer customerId;
	
	private Integer dealState;
	
	private String dealDate;
	
	private String createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getDealState() {
		return dealState;
	}

	public void setDealState(Integer dealState) {
		this.dealState = dealState;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Apple(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Apple() {
	}
}
