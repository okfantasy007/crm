package com.chdsxt.crm.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.chdsxt.crm.dao.ModuleDao;
import com.chdsxt.crm.po.Module;
import com.chdsxt.crm.util.HibUtil;

public class ModuleDaoImpl implements ModuleDao {
	
	@SuppressWarnings("unchecked")
	public List<Module> queryModuleList(){
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Module m order by moduleId ");
		List<Module> moduleList = query.list();
		return moduleList;
	} 

	public Module queryModuleById(Integer moduleId) {
		Session session = HibUtil.getSession();
		return (Module)session.get(Module.class, moduleId);
	}
	
}
