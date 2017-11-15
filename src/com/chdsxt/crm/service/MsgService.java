package com.chdsxt.crm.service;

import java.util.List;
import com.chdsxt.crm.po.Msg;

public interface MsgService {
	public List<Msg> queryMsgList();
	public Msg getMsgById(Integer msgId);
	public void deleteMsg(Msg msg);
}
