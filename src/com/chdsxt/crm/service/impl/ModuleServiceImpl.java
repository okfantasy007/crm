package com.chdsxt.crm.service.impl;

import java.util.List;
import com.chdsxt.crm.dao.ModuleDao;
import com.chdsxt.crm.dao.impl.ModuleDaoImpl;
import com.chdsxt.crm.po.Module;
import com.chdsxt.crm.service.ModuleService;

public class ModuleServiceImpl implements ModuleService {
	private ModuleDao moduleDao = new ModuleDaoImpl();
	public List<Module> queryModuleList() {
		// TODO Auto-generated method stub
		return moduleDao.queryModuleList();
	}
}
