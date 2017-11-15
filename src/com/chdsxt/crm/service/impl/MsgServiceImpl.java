package com.chdsxt.crm.service.impl;

import java.util.List;
import com.chdsxt.crm.dao.MsgDao;
import com.chdsxt.crm.dao.impl.MsgDaoImpl;
import com.chdsxt.crm.po.Msg;
import com.chdsxt.crm.service.MsgService;

public class MsgServiceImpl implements MsgService {
	private MsgDao msgDao = new MsgDaoImpl();

	public List<Msg> queryMsgList() {
		// TODO Auto-generated method stub
		return msgDao.queryMsgList();
	}
	
	public void deleteMsg(Msg msg) {
		// TODO Auto-generated method stub
		msgDao.deleteMsg(msg);
	}

	public Msg getMsgById(Integer msgId) {
		// TODO Auto-generated method stub
		return msgDao.getMsgById(msgId);
	}
	

	public MsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}

}
