package com.chdsxt.crm.service;

import java.util.List;
import com.chdsxt.crm.po.Type;

public interface TypeService {
	public List<Type> queryTypeList();
	public void addType(Type type);
	public Type getTypeById(Integer typeId);
	public void updateType(Type type);
	public void deleteType(Type type);
}
