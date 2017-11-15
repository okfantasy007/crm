package com.chdsxt.crm.dao;

import java.util.List;
import com.chdsxt.crm.po.Type;


public interface TypeDao {
	public List<Type> queryTypeList();
	public void addType(Type type);
	public Type getTypeById(Integer typeId);
	public void updateType(Type type);
	public void deleteType(Type type);
}
