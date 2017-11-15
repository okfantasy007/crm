package com.chdsxt.crm.dao;

import java.util.List;
import com.chdsxt.crm.po.Msg;


public interface MsgDao {
	public List<Msg> queryMsgList();
	public Msg getMsgById(Integer msgId);
	public void deleteMsg(Msg msg);
}
