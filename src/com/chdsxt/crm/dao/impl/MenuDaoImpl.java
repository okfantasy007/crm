package com.chdsxt.crm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import com.chdsxt.crm.dao.MenuDao;
import com.chdsxt.crm.dao.RoleModuleDao;
import com.chdsxt.crm.po.Menu;
import com.chdsxt.crm.po.Module;
import com.chdsxt.crm.po.RoleModule;
import com.chdsxt.crm.util.HibUtil;

public class MenuDaoImpl implements MenuDao {
 
	private RoleModuleDao roleModuleDao = new RoleModuleDaoImpl();
	
	public List<Menu> queryMenuListByRoleId(Integer roleId) {
		
		System.out.println("----- MenuDaoImpl queryMenuListByRoleId -----");
		List<Menu> menuList = new ArrayList<Menu>();
		List<Module> moduleList = new ArrayList<Module>();
		List<RoleModule> rmList = roleModuleDao.queryRoleModuleListByRoleId(roleId);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer limitsCode = null;
		Integer parentMenuId = null;
		Menu menu = new Menu();
		
		for (int i = 0; i < rmList.size(); i++) {
			Module module = rmList.get(i).getModule();
			System.out.println("----- module.getModuleId() : "+module.getModuleId()+" -----");
			moduleList.add(module);
			limitsCode = roleModuleDao.queryLimitsByRoleAndModuleId(roleId,module.getModuleId());
			System.out.println("----- limitsCode : "+limitsCode+" -----");
			map.put(module.getModuleId(), limitsCode);
		}
		
		for (int i = 0; i < moduleList.size(); i++) {
			limitsCode = map.get(moduleList.get(i).getModuleId());
			System.out.println("=============分隔线============分隔线================");
			System.out.println("----- limitsCode : "+limitsCode+" -----");
			Menu parentMenu = getMenuById(moduleList.get(i).getModuleId());
			System.out.println("----- parentMenu.getMenuName() : "+parentMenu.getMenuName()+" -----");
			menuList.add(parentMenu);
			parentMenuId = parentMenu.getMenuId();
			if((limitsCode&4)==4){
				System.out.println("----- go to son menu -----");
				menu = getMenuByKeyWord("query","Del",parentMenuId);
				System.out.println("----- "+menu.getMenuName()+" -----");
				menuList.add(menu);
			}
			if(parentMenuId!=27){
				if((limitsCode&4)==4&&(limitsCode&1)==1){
					System.out.println("----- go to son menu -----");
					menu = getMenuByKeyWord("Del",parentMenuId);
					System.out.println("----- "+menu.getMenuName()+" -----");
					menuList.add(menu);
				}
			}
			if(menuList!=null&&menuList.size()==1){
				menuList.clear();
			}
		}
		return menuList;
		//return list;
	}
	
	@SuppressWarnings("unchecked")
	public Menu getMenuByKeyWord(String keyWord,Integer parentMenuId){
		System.out.println("----- MenuDaoImpl getMenuByKeyWord -----");
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Menu m where m.menuUrl like ? and m.parentMenu.menuId = ? ");
		query.setParameter(0, "%"+keyWord+"%");
		query.setParameter(1, parentMenuId);
		List<Menu> list = query.list();
		if(list!=null){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Menu getMenuByKeyWord(String in,String notIn,Integer parentMenuId){
		System.out.println("----- MenuDaoImpl getMenuByKeyWord by in and notIn -----");
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Menu m where m.menuUrl like ? and m.menuUrl not like ? and m.parentMenu.menuId = ? ");
		query.setParameter(0, "%"+in+"%");
		query.setParameter(1, "%"+notIn+"%");
		query.setParameter(2, parentMenuId);
		List<Menu> list = query.list();
		if(list!=null){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Menu getMenuById(Integer menuId){
		System.out.println("----- MenuDaoImpl getMenuById -----");
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Menu m where m.menuId=:menuId ");
		query.setInteger("menuId", menuId);
		List<Menu> list = query.list();
		if(list!=null){
			return list.get(0);
		}else{
			return null;
		}
	}

	public RoleModuleDao getRoleModuleDao() {
		return roleModuleDao;
	}

	public void setRoleModuleDao(RoleModuleDao roleModuleDao) {
		this.roleModuleDao = roleModuleDao;
	}
	
}
