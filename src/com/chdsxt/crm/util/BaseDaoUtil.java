package com.chdsxt.crm.util;


import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDaoUtil {
	
	/**
	 * ��һ������ ����һ��������
	 */
	public static String getFieldNameByColName(String colName){
		String[] colArray = colName.split("_");
		StringBuffer fieldNameBuffer = new StringBuffer(colArray[0]);
		for(int i = 1;i<colArray.length;i++){
			String name = colArray[i].substring(0,1).toUpperCase()+colArray[i].substring(1);
			fieldNameBuffer.append(name);
		}
		return fieldNameBuffer.toString();
	}
	/**
	 * ��ȡ�趨��������
	 * @param fieldName
	 * @return
	 */
	public static String getSetter(String fieldName){
		return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
	/**
	 * ��ȡ������������
	 * @param field
	 * @return
	 */
	public static String getGetter(Field field){
		String fieldName = field.getName();
		return (field.getType()==boolean.class?"is":"get")+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
	/**
	 * ���
	 * @param ps
	 * @param paramArray
	 * @throws SQLException
	 */
	public static void setPsValue(PreparedStatement ps ,Object...paramArray) throws SQLException{
		if(paramArray!=null&&paramArray.length>0){
			for(int i = 0;i<paramArray.length;i++){
				ps.setObject(i+1, paramArray[i]);
			}
		}
	}
	/**
	 * ���
	 * @param ps
	 * @param paramArray
	 * @throws SQLException
	 */
	public static void setPsValueByPage(PageUtil page,PreparedStatement ps ,Object...paramArray) throws SQLException{
		int count = 0;
		if(paramArray!=null&&paramArray.length>0){
			for(int i = 0;i<paramArray.length;i++){
				ps.setObject(++count, paramArray[i]);
			}
		}
		ps.setObject(++count, page.getEndNum());
		ps.setObject(++count, page.getStartNum());
	}
	/**
	 * @param classOrFieldName
	 * @return
	 */
	public static String getTabOrColName(String classOrFieldName){
		StringBuffer tabOrColName = new StringBuffer();
		tabOrColName.append(classOrFieldName.charAt(0));
		for(int i = 1;i<classOrFieldName.length();i++){
			char c = classOrFieldName.charAt(i);
			if(c>='A'&&c<='Z'){
				tabOrColName.append("_"+c);
			}else{
				tabOrColName.append(c);
			}
		}
		return tabOrColName.toString();
	}
}
