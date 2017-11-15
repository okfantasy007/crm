package com.chdsxt.crm.service;

import java.util.List;
import com.chdsxt.crm.po.Menu;

public interface MenuService {
	public List<Menu> queryMenuListByRoleId(Integer roleId);
}
