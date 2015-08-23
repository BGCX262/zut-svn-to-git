package fr.dorian.model.enums;

public enum ActivityCommandEnum {
	
	CREATE_NEW_TRHEAD(0, "created a new thread"),
	CREATE_NEW_TUTORIAL(1, "created a new tutorial"),
	CONVERT_THREAD_TO_TUTORIAL(2, "convert thread to a new tutorial"),
	ADD_NEW_POST(3, "added new post"),
	CREATE_NEW_TAG(4, "created new tag"),
	CREATE_NEW_ACCOUNT(5, "created account"),
	CLOSE_THREAD(6, "closed thread");
	
	private Integer code; 
	private String command;

	private ActivityCommandEnum(Integer code, String command) {
		this.code = code;
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}

	public Integer getCode() {
		return this.code;
	}

	@Override
	public String toString() {
		return this.name();
	}
	

}
