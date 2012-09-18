package de.zeunerds.meat.server.usermanagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.HibernateUtils;
import de.zeunerds.meat.server.exception.FunctionalException;
import de.zeunerds.meat.server.exception.FunctionalText;

public class UsermanagementService {

	private Logger mLogger = LoggerFactory.getLogger(this.getClass());
	
	private UsermanagementFunctions mUserFunctions = new UsermanagementFunctions();

	public UsermanagementService() {

	}

	public Account createAccount(String username, String password, String name,
			String firstname) throws FunctionalException {
		mLogger.trace("Method begin...");

		Account account = new Account(username, password, name, firstname);
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			if(mUserFunctions.loadAccount(username, session) == null){
				session.save(account);
				transaction.commit();
			}
			else{
				transaction.rollback();
				throw new FunctionalException(FunctionalText.DOUBLE_USERNAME);
			}
			
		} catch (HibernateException e) {
			mLogger.error("Catched: " + e);
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		mLogger.trace("Method end...");
		return account;
	}

	public Account loadAccount(String username) {
		mLogger.trace("Method begin...");

		Session session = null;
		Transaction transaction = null;
		Account account = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			account = mUserFunctions.loadAccount(username, session);
			transaction.commit();
		} catch (HibernateException e) {
			mLogger.error("Catched: " + e);
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		mLogger.trace("Method end...");
		return account;
	}
	
	public boolean saveAccount(Account account) {
		mLogger.trace("Method begin...");

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(account);
			transaction.commit();
		} catch (HibernateException e) {
			mLogger.error("Catched: " + e);
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		mLogger.trace("Method end...");
		return true;
	}

}
