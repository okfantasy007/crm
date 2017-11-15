package com.chdsxt.crm.action;

import java.util.List;

import com.chdsxt.crm.po.Type;
import com.chdsxt.crm.service.TypeService;
import com.chdsxt.crm.service.impl.TypeServiceImpl;

public class TypeAction {
	private List<Type> typeList;
	private Type type;
	private String ids;
	private TypeService typeService = new TypeServiceImpl();
	
	public String queryTypeList(){
		System.out.println("----- TypeAction  queryTypeList -----");
		typeList = typeService.queryTypeList();
		System.out.println("----- "+typeList.size()+" -----");
		for (int i = 0; i < typeList.size(); i++) {
			System.out.println("----- "+typeList.get(i).getTypeName()+" -----");
		}
		return "queryTypeList";
	}
	
	public String queryAndDelType(){
		System.out.println("----- TypeAction  queryAndDelType -----");
		typeList = typeService.queryTypeList();
		System.out.println("----- "+typeList.size()+" -----");
		for (int i = 0; i < typeList.size(); i++) {
			System.out.println("----- "+typeList.get(i).getTypeName()+" -----");
		}
		return "queryAndDelType";
	}

	public String addBeforeType(){
		System.out.println("----- TypeAction  addBeforeType -----");
		return "addBeforeType";
	}
	
	public String addType(){
		System.out.println("----- TypeAction  addType -----");
		System.out.println("----- "+type.getTypeId()+" -----");
		System.out.println("----- "+type.getTypeName()+" -----");
		System.out.println("----- "+type.getTypeDesc()+" -----");
		typeService.addType(type);
		return queryTypeList();
	}
	
	public String updateBeforeType(){
		System.out.println("----- TypeAction  updateBeforeType -----");
		type = typeService.getTypeById(type.getTypeId());
		return "updateBeforeType";
	}
	
	public String updateType(){
		System.out.println("----- TypeAction  updateType -----");
		typeService.updateType(type);
		return queryTypeList();
	}
	
	public String deleteType(){
		System.out.println("----- TypeAction  deleteType -----");
		type = typeService.getTypeById(type.getTypeId());
		typeService.deleteType(type);
		return queryAndDelType();
	}
	
	public String deleteAll(){
		System.out.println("----- TypeAction  deleteAll -----");
		System.out.println("----- ids : "+ids+" -----");
		String[] ss = ids.split(";");
		System.out.println("----- ss.length : "+ss.length+" -----");
		for (int i = 0; i < ss.length; i++) {
			System.out.println("----- "+Integer.parseInt(ss[i])+" -----");
			type = typeService.getTypeById(Integer.parseInt(ss[i]));
			typeService.deleteType(type);
		}
		return queryAndDelType();
	}
	
	public List<Type> getTypeList() {
		return typeList;
	}
	
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	
	
	
	
	
	
	
	
	
	
}
