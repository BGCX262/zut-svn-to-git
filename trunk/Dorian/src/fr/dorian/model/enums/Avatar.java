package fr.dorian.model.enums;

public enum Avatar {
	
	AVATAR_32("avatar_32", 32, 32),
	AVATAR_64("avatar_64", 64, 64),
	AVATAR_128("avatar_128", 128, 128);
	
	public final String DEFAULT_EXTENSION = "jpg";
	
	private String avatarName;
	private Integer height;
	private Integer width;
	
	private Avatar(String name, Integer width, Integer height) {
		this.avatarName = name;
		this.width = width;
		this.height = height;
	}
	
	public Integer getHeight() {return this.height;}
	public Integer getWidth() {return this.width;}
	public String getName() {
		return new StringBuilder(this.avatarName)
								.append(".")
								.append(DEFAULT_EXTENSION)
								.toString();
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}
