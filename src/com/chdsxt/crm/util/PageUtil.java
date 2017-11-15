package com.chdsxt.crm.util;

import java.util.List;

public class PageUtil {
	private String currPageNumStr;//��ǰ�ڼ�ҳ
	private Integer  totalCount;//�ܹ���������� 
	private Integer  pageSize;//ÿҳ������
	// ��ݵ�����
	private Integer startNum;
	private Integer endNum; //ÿҳ�Ľ������ �ڼ���
	//����������
	private Integer previous; //��һҳ
	private Integer next;//��һҳ
	private Integer pageTotal;//�ܹ�����ҳ
	private Integer navStartNum;//������ʼҳ����
	private Integer navEndNum;//��������ҳ����
	private Integer first = 1;//��ҳ
	private Integer last;//βҳ
	private Integer navSize=10;//����ÿƪ�м�ҳ
	@SuppressWarnings("unchecked")
	private List list ;//��ݵ�List
	public PageUtil(){}
	/**
	 * @param currPageNumStr  ��ǰ�ڼ�ҳ
	 * @param totalCount  �ܹ���������� 
	 * @param pageSize ÿҳ������
	 */
	public PageUtil(String currPageNumStr, Integer totalCount, Integer pageSize) {
		this.currPageNumStr = (currPageNumStr==null||currPageNumStr.equals(""))?"1":currPageNumStr;
		int currPageNum = Integer.parseInt(this.currPageNumStr);
		currPageNum = currPageNum<=0?1:currPageNum;//С�ڵ���0 ��û������Σ���Ϊ1
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		//��ݵ�����
		startNum = (currPageNum-1)*pageSize+1;
		endNum = startNum+pageSize-1;
		//����������
		this.pageTotal = (int)Math.ceil(totalCount*1.0/pageSize);//�ܹ�����ҳ
		this.previous = currPageNum==1?1:currPageNum-1;//��һҳ
		this.next = currPageNum>=pageTotal?pageTotal:currPageNum+1;//��һҳ
		this.last = pageTotal;
		this.navStartNum = currPageNum-pageSize/2<=1?1:currPageNum-pageSize/2;//������ʼҳ����
		this.navEndNum = (navStartNum+navSize-1)>=pageTotal?pageTotal:navStartNum+navSize-1;//��������ҳ����
		if(pageTotal<navSize){
			navStartNum = 1;
		}else{
			if(pageTotal - currPageNum < pageSize/2-1){
				navStartNum = pageTotal-pageSize+1;
			}
		}
	}

	public String getCurrPageNum() {
		return currPageNumStr;
	}
	public void setCurrPageNum(String currPageNumStr) {
		this.currPageNumStr = currPageNumStr;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getEndNum() {
		return endNum;
	}
	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
	public Integer getPrevious() {
		return previous;
	}
	public void setPrevious(Integer previous) {
		this.previous = previous;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getNavStartNum() {
		return navStartNum;
	}
	public void setNavStartNum(Integer navStartNum) {
		this.navStartNum = navStartNum;
	}
	public Integer getNavEndNum() {
		return navEndNum;
	}
	public void setNavEndNum(Integer navEndNum) {
		this.navEndNum = navEndNum;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getNavSize() {
		return navSize;
	}
	public void setNavSize(Integer navSize) {
		this.navSize = navSize;
	}
	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}
	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}
}
