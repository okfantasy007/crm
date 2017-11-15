package com.chdsxt.crm.service;

import java.util.List;
import com.chdsxt.crm.po.Log;

public interface LogService {
	public List<Log> queryLogList();
	public Log getLogById(Integer logId);
	public void deleteLog(Log log);
	public void addLog(Log log);
	public void updateLog(Log log);
}
