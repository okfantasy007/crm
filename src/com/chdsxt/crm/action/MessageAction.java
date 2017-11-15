package com.chdsxt.crm.action;

import java.util.List;

import com.chdsxt.crm.po.Msg;
import com.chdsxt.crm.service.MsgService;
import com.chdsxt.crm.service.impl.MsgServiceImpl;

public class MessageAction {

	private List<Msg> msgList;
	private Msg msg;
	private String ids;
	private MsgService msgService = new MsgServiceImpl();
	
	public String queryMessageList(){
		System.out.println("----- MessageAction  queryMessageList -----");
		msgList = msgService.queryMsgList();
		return "queryMessageList";
	}
	
	public String deleteMsg(){
		System.out.println("----- MessageAction  deleteMessage -----");
		msg = msgService.getMsgById(msg.getMsgId());
		msgService.deleteMsg(msg);
		return queryMessageList();
	}
	
	public String deleteAll(){
		System.out.println("----- MessageAction  deleteAll -----");
		System.out.println("----- ids : "+ids+" -----");
		String[] ss = ids.split(";");
		System.out.println("----- ss.length : "+ss.length+" -----");
		for (int i = 0; i < ss.length; i++) {
			System.out.println("----- "+Integer.parseInt(ss[i])+" -----");
			msg = msgService.getMsgById(Integer.parseInt(ss[i]));
			msgService.deleteMsg(msg);
		}
		return queryMessageList();
	}
	
	public List<Msg> getMsgList() {
		return msgList;
	}
	
	public void setMsgList(List<Msg> msgList) {
		this.msgList = msgList;
	}
	
	public MsgService getMsgService() {
		return msgService;
	}
	
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
	
	
	
	
}
