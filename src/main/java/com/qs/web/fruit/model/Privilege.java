package com.qs.web.fruit.model;

import java.io.Serializable;

public class Privilege implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2596891603189478240L;

	private Integer privilegeId;
	
	private String privilegeName;
	
	private String privilegeDescription;
	
	private Integer parentId;

	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeIdId) {
		this.privilegeId = privilegeIdId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeDescription() {
		return privilegeDescription;
	}

	public void setPrivilegeDescription(String privilegeDescription) {
		this.privilegeDescription = privilegeDescription;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	
}
