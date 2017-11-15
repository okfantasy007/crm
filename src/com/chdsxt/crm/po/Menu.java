package com.chdsxt.crm.po;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Menu implements Serializable{
	private Integer menuId;
	private String menuCode;
	private String menuName;
	private Integer menuLevel;
	//自己和自己是一个一对多的关系   一个 父菜单对应多个子菜单
	private Menu parentMenu;//多方
	private Set<Menu> menuSet;//一方
	private String menuUrl;
	private Set<Role> roleSet;
	
	public Set<Menu> getMenuSet() {
		return menuSet;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Set<Role> getRoleSet() {
		return roleSet;
	}
	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}
	
	
}
