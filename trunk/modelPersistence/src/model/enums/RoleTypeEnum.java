package model.enums;

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
	 * Gets the authority 
	 * @return
	 */
	public String getAuthority() {
		return this.name();
	}

	@Override
	public String toString() {
		return this.name();
	}
}
