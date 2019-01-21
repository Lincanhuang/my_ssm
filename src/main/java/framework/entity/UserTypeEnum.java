package framework.entity;

public enum UserTypeEnum {
	
	ROOT("超级用户"),ADMIN("管理员"),NONE("未知");
	
	private String value;

	private UserTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
