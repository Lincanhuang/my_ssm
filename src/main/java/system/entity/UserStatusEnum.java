package system.entity;

public enum UserStatusEnum {
	DISABLE(0),ABLE(1);
	private UserStatusEnum(int code) {
		setCode(code);
	}
	private Integer code;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
