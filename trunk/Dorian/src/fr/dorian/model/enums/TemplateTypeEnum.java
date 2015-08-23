package fr.dorian.model.enums;

public enum TemplateTypeEnum {

	REGISTRATION_VERIFICATION(0, "verification.vm", "tpl_verification"),
	PASSWORD_RECOVERY(1, "passwordRecovery.vm", "tpl_password_recovery"),
	CONTACT_US(2, "contactus.vm", "tpl_contactus");
	
	private Integer code;
	private String template;
	private String file;
	
	private TemplateTypeEnum(Integer code, String template, String file) {
		this.setCode(code);
		this.setTemplate(template);
		this.setFile(file);
	}

	public Integer getCode() {return code;}
	public void setCode(Integer code) {this.code = code;}

	public String getTemplate() {return template;}
	public void setTemplate(String template) {this.template = template;}
	
	public String getFile() {return file;}
	public void setFile(String file) {this.file = file;}
	
	public static TemplateTypeEnum fromCode(Integer code) {
		TemplateTypeEnum type = null;
		for (TemplateTypeEnum tt : TemplateTypeEnum.values()) {
			if (tt.code.equals(code)) {
				type = tt;
				break;
			}
		}
		return type;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}
