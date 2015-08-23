package com.fr.zut.model.enums;

/**
 * Sample Enum model to use for persistence
 * @author KONE
 *
 */
public enum EnumForDatabase {

	SAMPLE_1(0, "ENUM_1");
	/**
	 * Code for database
	 */
	private Integer code;
	/**
	 * Object
	 */
	private String value;
	
	/**
	 * Construct an enum
	 * @param code - Enum code (database integer index)
	 * @param value - 
	 */
	private EnumForDatabase(final Integer code, final String value) {
		this.code = code;
		this.value = value;
	}
	
	/**
	 * Gets current code
	 * @return current enum code
	 */
	public Integer getCode() {
		return this.code;
	}
	
	/**
	 * Gets current value
	 * @return current enum value;
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Gets an enum from code.
	 * @param code - Code that match an enum
	 * @return an enum that corresponds this code; otherwise null.
	 */
	public static EnumForDatabase fromCode(Integer code) {
		
		for (EnumForDatabase sampleEnum : EnumForDatabase.values()) {
			if (code.equals(sampleEnum.getCode())) {
				return sampleEnum;
			}
		}
		return null;
	}
}
