package com.chdsxt.crm.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chdsxt.crm.dao.MsgDao;
import com.chdsxt.crm.po.Msg;
import com.chdsxt.crm.util.HibUtil;

public class MsgDaoImpl implements MsgDao {
	
	@SuppressWarnings("unchecked")
	public List<Msg> queryMsgList(){
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Msg m order by msgId ");
		List<Msg> msgList = query.list();
		return msgList;
	}

	@SuppressWarnings("unchecked")
	public Msg getMsgById(Integer msgId) {
		// TODO Auto-generated method stub
		Session session = HibUtil.getSession();
		Query query = session.createQuery("   from Msg m where m.msgId = ? ");
		query.setParameter(0, msgId);
		
		List<Msg> msgList = query.list();
		if(msgList!=null){
			return msgList.get(0);
		}else{
			return null;
		}	
	}

	public void deleteMsg(Msg msg) {
		// TODO Auto-generated method stub
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Msg delMsg = (Msg)session.get(Msg.class, msg.getMsgId());
		session.delete(delMsg);
		tx.commit();
	}
	
}
