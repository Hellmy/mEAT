package de.zeunerds.meat.server.usermanagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.HibernateUtils;

public class UsermanagementService {

	private Logger mLogger = LoggerFactory.getLogger(this.getClass());

	public UsermanagementService() {

	}

	public Account createAccount(String username, String password, String name,
			String firstname) {
		mLogger.trace("Method begin...");

		Account account = new Account(username, password, name, firstname);
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(account);
			transaction.commit();
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
			Query query = session.createQuery("from Account where username='"
					+ username + "'");
			mLogger.trace("Count Accounts: " + query.list().size());
			if (query.list().size() > 0) {
				account = (Account) query.list().get(0);
			}
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

}
