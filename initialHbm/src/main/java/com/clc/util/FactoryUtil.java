package com.clc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FactoryUtil {
	
	static public SessionFactory sfactoryMysql = null;
	static public SessionFactory sfactoryHsql = null;
		
	public static SessionFactory getSessionFactory(AppConstants.MyDB database ){
		
			if(database.equals(AppConstants.MyDB.MYSQL)){
				if(sfactoryMysql==null)
						sfactoryMysql=new Configuration().configure("mysql-hibernate.cfg.xml").buildSessionFactory();
				return sfactoryMysql;
				}
			else if(database.equals(AppConstants.MyDB.HSQL)){
					if( sfactoryHsql==null)
						sfactoryHsql=new Configuration().configure("hsql-hibernate.cfg.xml").buildSessionFactory();
					return sfactoryHsql;
				}
			
			return null;
			
			
	}

	public static void cleanUpResources(Session session, Transaction tr) {
		if(session!=null){
			if(tr!=null){
				session.flush();
				tr.commit();
			}
			session.close();
		}
		
	}

}
