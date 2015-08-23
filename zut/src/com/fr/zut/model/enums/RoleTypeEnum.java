package com.fr.zut.model.enums;

public enum RoleTypeEnum {

	COSTUM(0, "COSTUM"),
	ADMIN(1, "ADMIN"),
	SYSTEM(2, "SYSTEM");

	private Integer code;
	private String name;

	private RoleTypeEnum(final Integer code, final String name) {
		this.name = name;
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static RoleTypeEnum fromCode(Integer code) {
		for (RoleTypeEnum role : RoleTypeEnum.values()) {
			if (code.equals(role.ordinal())) {
				return role;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
