package com.chdsxt.crm.action;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.chdsxt.crm.po.Type;
import com.chdsxt.crm.util.XlsException;
import com.chdsxt.crm.util.XlsExportUtil;
import com.opensymphony.xwork2.ActionContext;

public class XlsExpAction {
	
	private List<Type> typeList;
	
	@SuppressWarnings("unchecked")
	public String execute() {
		System.out.println("开始导出Excel文件");
		Map<String, Object>  session = ActionContext.getContext().getSession();
		typeList = (List<Type>)session.get("typeList");
		Map<String, Object>  application = ActionContext.getContext().getApplication();
		//在PhotoInitPath类中就已经将realPath放入application中了
		String realPath = (String)application.get("realPath");
	    XlsExportUtil e = new XlsExportUtil(realPath+File.separator+"TypeXlsExport.xls");
	    e.createRow(0);
	    e.setCell(0,"分类id");
	    e.setCell(1,"分类名称");
	    e.setCell(2,"分类描述");
	    e.setCell(3,"分类创建时间");
	    e.setCell(4,"最后更新时间");
	   
	    System.out.println("===== "+typeList.size()+" =====");
	    for (int i = 0; i < typeList.size(); i++) {
			Type type = typeList.get(i);
			System.out.println("===== 分类id : "+type.getTypeName()+" =====");
			e.createRow(i+1);
			e.setCell(0,type.getTypeId());
		    e.setCell(1,type.getTypeName());
		    e.setCell(2,type.getTypeDesc());
		    e.setCell(3,type.getTypeCreateTime().toString());
		    e.setCell(4,type.getTypeUpdTime().toString());
		}
	   
	    try {
	        e.exportXLS();
	        System.out.println("导出Excel文件[成功]");
	        return "xlsexpsuccess";
	    } catch (XlsException e1) {
	        System.out.println("导出Excel文件[失败]");
	        e1.printStackTrace();
	        return "queryTypeList";
	    } 

	}
	public List<Type> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}
	
}
