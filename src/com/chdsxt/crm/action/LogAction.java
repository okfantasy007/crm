package com.chdsxt.crm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.chdsxt.crm.po.Log;
import com.chdsxt.crm.service.LogService;
import com.chdsxt.crm.service.impl.LogServiceImpl;

@SuppressWarnings("unused")
public class LogAction {
	private List<Log> logList;
	private LogService logService = new LogServiceImpl();
	private Log log;
	private Integer updLogId;
	private String ids;
	
	public String queryLogList(){
		System.out.println("----- LogAction  queryLogList -----");	
		logList = logService.queryLogList();
		System.out.println("----- "+logList.size()+" -----");
		return "queryLogList";
	}
	
	public String queryAndDelLog(){
		System.out.println("----- LogAction  queryAndDelLog -----");	
		logList = logService.queryLogList();
		System.out.println("----- "+logList.size()+" -----");
		return "queryAndDelLog";
	}
	
	public String addBeforeLog(){
		System.out.println("----- LogAction  addBeforeLog -----");
		return "addBeforeLog";
	}
	
	public String addLog(){
		System.out.println("----- LogAction  addLog -----");
		System.out.println("----- "+log.getLogId()+" -----");
		System.out.println("----- "+log.getLogName()+" -----");
		System.out.println("----- "+log.getLogContent()+" -----");
		System.out.println("----- "+log.getLogAuthor()+" -----");
		System.out.println("----- "+log.getLogCreateTime()+" -----");
		System.out.println("----- "+log.getLogUpdTime()+" -----");
		logService.addLog(log);
		return queryLogList();
	}
	
	public String updateBeforeLog(){
		System.out.println("----- LogAction  updateBeforeLog -----");
		log = logService.getLogById(log.getLogId());
		System.out.println("----- "+log.getLogCreateTime()+" -----");
		System.out.println("----- "+log.getLogUpdTime()+" -----");
		return "updateBeforeLog";
	}
	
	public String updateLog(){
		System.out.println("----- LogAction  updateLog -----");
		logService.updateLog(log);
		System.out.println("----- "+log.getLogId()+" -----");
		System.out.println("----- "+log.getLogName()+" -----");
		System.out.println("----- "+log.getLogContent()+" -----");
		System.out.println("----- "+log.getLogAuthor()+" -----");
		System.out.println("----- "+log.getLogCreateTime()+" -----");
		System.out.println("----- "+log.getLogUpdTime()+" -----");
		logList = logService.queryLogList();
		System.out.println("----- "+logList.size()+" -----");
		return "queryLogList";
	}
	
	public String deleteLog(){
		System.out.println("----- LogAction  delLog -----");
		log = logService.getLogById(log.getLogId());
		logService.deleteLog(log);
		return queryAndDelLog();
	}
	
	public String deleteAll(){
		System.out.println("----- LogAction  deleteAll -----");
		System.out.println("----- ids : "+ids+" -----");
		String[] ss = ids.split(";");
		System.out.println("----- ss.length : "+ss.length+" -----");
		for (int i = 0; i < ss.length; i++) {
			System.out.println("----- "+Integer.parseInt(ss[i])+" -----");
			log = logService.getLogById(Integer.parseInt(ss[i]));
			logService.deleteLog(log);
		}
		return queryAndDelLog();
	}
	
	public List<Log> getLogList() {
		return logList;
	}
	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}
	
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getUpdLogId() {
		return updLogId;
	}

	public void setUpdLogId(Integer updLogId) {
		this.updLogId = updLogId;
	}
	
}
