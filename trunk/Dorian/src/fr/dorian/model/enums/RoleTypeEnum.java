package fr.dorian.model.enums;

public enum RoleTypeEnum {

	ROLE_SUPERVISOR("Supervisor"),
	ROLE_USER("User"),
	ROLE_TELLER("Teller");

	private String description;

	/**
	 * Constructs a RoleTypeEnum with title;
	 * @param description
	 */
	private RoleTypeEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Gets the authority // the name will be returned 
	 * @return
	 */
	public String getAuthority() {
		return this.name();
	}
	
	public static RoleTypeEnum fromNameOrDescription(final String role) {
		RoleTypeEnum result = null;
		for (RoleTypeEnum typeEnum : RoleTypeEnum.values()) {
			if (typeEnum.name().equals(role) || typeEnum.description.equals(role)) {
				result = typeEnum;
				break;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}
