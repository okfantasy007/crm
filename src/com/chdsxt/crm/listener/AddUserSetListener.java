package com.chdsxt.crm.listener;

import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;


/**
 * 当 登陆一个用户时   页面上 滚动内容自动添加上对应的用户名
	思路：
		实现那几个接口
 *
 */
public class AddUserSetListener extends AbstractListener{
	private HashSet<String>  userNameSet;
	/**
	 * 当session 内添加属性时  调用此方法
	 */
	@SuppressWarnings("unchecked")
	public void attributeAdded(HttpSessionBindingEvent sessionBindingEvent) {
		System.out.println("----- AddUserSetListener attributeAdded -----");
		HttpSession session = sessionBindingEvent.getSession();
		String userName = (String)session.getAttribute("userName");
		System.out.println("----- "+userName+" -----");
		if(userName!=null){
			userNameSet.add(userName);
			System.out.println("----- "+userNameSet.size()+" -----");
			if(userNameSet!=null){
				for (Iterator iterator = userNameSet.iterator(); iterator.hasNext();) {
					System.out.println("----- "+(String) iterator.next()+" -----");
				}
			}
			ServletContext context = session.getServletContext();
			context.setAttribute("userNameSet", userNameSet);		
		}
	}
	/**
	 * 用户退出登陆时  调用此方法
	 */
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("----- AddUserSetListener sessionDestroyed -----");
		HttpSession session = sessionEvent.getSession();
		String userName = (String)session.getAttribute("userName");
		userNameSet.remove(userName);
		ServletContext context = session.getServletContext();
		context.setAttribute("userNameSet", userNameSet);	
	}
	/**
	 * 服务启动时 也就是 application创建时   调用此方法
	 */
	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("----- AddUserSetListener contextInitialized -----");
		userNameSet = new HashSet<String>();
		sce.getServletContext().setAttribute("userNameSet", userNameSet);
		if(userNameSet!=null){
			for (Iterator iterator = userNameSet.iterator(); iterator.hasNext();) {
				System.out.println("----- "+(String) iterator.next()+" -----");
			}
		}
		
	}
}
