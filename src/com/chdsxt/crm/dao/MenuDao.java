package com.chdsxt.crm.dao;

import java.util.List;
import com.chdsxt.crm.po.Menu;

public interface MenuDao {
	public List<Menu> queryMenuListByRoleId(Integer roleId);
	public Menu getMenuByKeyWord(String keyWord,Integer parentMenuId);
	public Menu getMenuByKeyWord(String in,String notIn,Integer parentMenuId);
	public Menu getMenuById(Integer menuId);
}
