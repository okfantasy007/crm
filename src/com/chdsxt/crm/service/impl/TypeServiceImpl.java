package com.chdsxt.crm.service.impl;

import java.util.List;
import com.chdsxt.crm.dao.TypeDao;
import com.chdsxt.crm.dao.impl.TypeDaoImpl;
import com.chdsxt.crm.po.Type;
import com.chdsxt.crm.service.TypeService;

public class TypeServiceImpl implements TypeService {
	private TypeDao typeDao = new TypeDaoImpl();
	
	public List<Type> queryTypeList() {
		// TODO Auto-generated method stub
		System.out.println("----- TypeServiceImpl queryTypeList -----");
		return typeDao.queryTypeList();
	}
	
	public void addType(Type type) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeServiceImpl addType -----");
		typeDao.addType(type);
	}
	
	public Type getTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeServiceImpl getTypeById -----");
		return typeDao.getTypeById(typeId);
	}
	
	public void updateType(Type type) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeServiceImpl updateType -----");
		typeDao.updateType(type);
	}

	public void deleteType(Type type) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeServiceImpl deleteType -----");
		typeDao.deleteType(type);
	}
	
	public TypeDao getTypeDao() {
		return typeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	
}
