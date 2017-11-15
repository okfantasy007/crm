package com.chdsxt.crm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {
	private static ThreadLocal<Session>  threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory ;
	static{
		Configuration config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	public static Session getSession(){
		if(threadLocal.get()!=null&&threadLocal.get().isOpen()){
			return threadLocal.get();
		}else{
			threadLocal.set(sessionFactory.openSession());
		}
		return threadLocal.get();
	}
	public static void main(String[] args) {
		final Session s1 = getSession();
		System.out.println(s1);
		new Thread(new Runnable() {
			public void run() {
				Session s2 = getSession();
				System.out.println(s2);
				System.out.println(s1==s2);
			}
		}).start();
	}
}
