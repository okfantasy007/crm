package com.chdsxt.crm.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chdsxt.crm.dao.TypeDao;
import com.chdsxt.crm.po.Type;
import com.chdsxt.crm.util.HibUtil;

public class TypeDaoImpl implements TypeDao {
	
	@SuppressWarnings("unchecked")
	public List<Type> queryTypeList(){
		System.out.println("----- TypeDaoImpl queryTypeList -----");
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Type t order by typeId ");
		List<Type> typeList = query.list();
		return typeList;
	}

	public void addType(Type type) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeDaoImpl addType -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(type);
		tx.commit();	
	}

	@SuppressWarnings("unchecked")
	public Type getTypeById(Integer typeId) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeDaoImpl getTypeById -----");
		System.out.println("----- "+typeId+" -----");
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Type t where t.typeId =:typeId");
		query.setInteger("typeId", typeId);
		List<Type> typeList = query.list();
		return (typeList!=null&&typeList.size()>0)?typeList.get(0):null;
	}

	public void updateType(Type type) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeDaoImpl getTypeById -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Type updtype = (Type)session.get(Type.class, type.getTypeId());
		updtype.setTypeName(type.getTypeName());
		updtype.setTypeDesc(type.getTypeDesc());
		updtype.setTypeUpdTime(type.getTypeUpdTime());
		session.update(updtype);
		tx.commit();
	}

	public void deleteType(Type type) {
		// TODO Auto-generated method stub
		System.out.println("----- TypeDaoImpl deleteType -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Type delType = (Type)session.get(Type.class, type.getTypeId());
		session.delete(delType);
		tx.commit();
	}
		
}
