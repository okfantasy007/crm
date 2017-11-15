package com.chdsxt.crm.service.impl;

import java.util.List;

import com.chdsxt.crm.dao.LogDao;

import com.chdsxt.crm.dao.impl.LogDaoImpl;

import com.chdsxt.crm.po.Log;

import com.chdsxt.crm.service.LogService;


public class LogServiceImpl implements LogService {
	private LogDao logDao = new LogDaoImpl();
	
	public List<Log> queryLogList() {
		// TODO Auto-generated method stub
		System.out.println("----- LogServiceImpl queryLogList -----");
		return logDao.queryLogList();
	}
	
	public Log getLogById(Integer logId) {
		// TODO Auto-generated method stub
		return logDao.getLogById(logId);
	}
	
	public void addLog(Log log) {
		// TODO Auto-generated method stub
		System.out.println("----- LogServiceImpl addLog -----");
		logDao.addLog(log);
	}
	
	public void updateLog(Log log) {
		// TODO Auto-generated method stub
		System.out.println("----- LogServiceImpl updateLog -----");
		logDao.updateLog(log);
	}
	
	public void deleteLog(Log log) {
		// TODO Auto-generated method stub
		logDao.deleteLog(log);
	}

	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

}
