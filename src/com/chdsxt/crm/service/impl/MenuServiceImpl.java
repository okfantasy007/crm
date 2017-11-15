package com.chdsxt.crm.service.impl;

import java.util.List;
import com.chdsxt.crm.dao.MenuDao;
import com.chdsxt.crm.dao.impl.MenuDaoImpl;
import com.chdsxt.crm.po.Menu;
import com.chdsxt.crm.service.MenuService;

public class MenuServiceImpl implements MenuService{
	private MenuDao  menuDao = new MenuDaoImpl();
	public List<Menu> queryMenuListByRoleId(Integer roleId){
		return menuDao.queryMenuListByRoleId(roleId);
	}
	public MenuDao getMenuDao() {
		return menuDao;
	}
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
