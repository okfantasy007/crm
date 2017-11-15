package com.chdsxt.crm.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.chdsxt.crm.dao.LogDao;
import com.chdsxt.crm.po.Log;
import com.chdsxt.crm.util.HibUtil;

@SuppressWarnings("unused")
public class LogDaoImpl implements LogDao {
	
	@SuppressWarnings("unchecked")
	public List<Log> queryLogList(){
		System.out.println("----- LogDaoImpl queryLogList -----");
		Session session = HibUtil.getSession();
		Query query1 = session.createQuery(" from Log l order by logId ");
		List<Log> logList = query1.list();
		/*Query query2 = session.createQuery("select logId,logName,logContent,logAuthor,to_char(logCreateTime,'yyyy-MM-dd HH:mm:ss'),to_char(logUpdTime,'yyyy-MM-dd HH:mm:ss') from Log l order by logId");
		List<Log> logList = query2.list();*/
		return logList;
	}

	
	@SuppressWarnings("unchecked")
	public Log getLogById(Integer logId) {
		// TODO Auto-generated method stub
		System.out.println("----- LogDaoImpl getLogById -----");
		System.out.println("----- "+logId+" -----");
		Session session = HibUtil.getSession();
		Query query = session.createQuery(" from Log l where l.logId =:logId");
		query.setInteger("logId", logId);
		List<Log> logList = query.list();
		return (logList!=null&&logList.size()>0)?logList.get(0):null;
	}

	public void addLog(Log log) {
		// TODO Auto-generated method stub
		System.out.println("----- LogDaoImpl addLog -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(log);
		tx.commit();	
	}
	
	public void updateLog(Log log) {
		// TODO Auto-generated method stub
		System.out.println("----- LogDaoImpl updateLog -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Log updlog = (Log)session.get(Log.class, log.getLogId());
		updlog.setLogName(log.getLogName());
		updlog.setLogContent(log.getLogContent());
		updlog.setLogAuthor(log.getLogAuthor());
		updlog.setLogCreateTime(log.getLogCreateTime());
		updlog.setLogUpdTime(log.getLogUpdTime());
		session.update(updlog);
		tx.commit();
	}
	
	public void deleteLog(Log log) {
		// TODO Auto-generated method stub
		System.out.println("----- LogDaoImpl getLogById -----");
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Log delLog = (Log)session.get(Log.class, log.getLogId());
		session.delete(delLog);
		tx.commit();
	}
	
}
