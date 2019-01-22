package ch.my.framework.entity;

public enum MenuTypeEnum {
	CATALOG("目录"),
	MENU("菜单"),
	BUTTON("按钮");
	
	private String descrpit;
	
	private MenuTypeEnum(String descrpit) {
		this.descrpit = descrpit;
	}

	public String getDescrpit() {
		return descrpit;
	}
}
