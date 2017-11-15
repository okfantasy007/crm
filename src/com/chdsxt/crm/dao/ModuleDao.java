package com.chdsxt.crm.dao;

import java.util.List;
import com.chdsxt.crm.po.Module;

public interface ModuleDao {
	public List<Module> queryModuleList();
	public Module queryModuleById(Integer moduleId);
}
