package de.zeunerds.meat.server.usermanagement.dao;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.zeunerds.meat.server.usermanagement.dao.Account;

public class AccountTest extends TestCase {

	private SessionFactory mSessionFactory;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("deprecation")
	protected void setUp() throws Exception {
		Configuration configuration = new Configuration().configure();
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, false);
		mSessionFactory = configuration.buildSessionFactory();
		//long pkeyAccount = erzeugeAccount();
		// long pkeyPerson = erzeugePerson();
	}

	@Test
	public void testLoad() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = mSessionFactory.openSession();
			transaction = session.beginTransaction();
			session.load(Account.class, (long) 1);
			Query accounts = session.createQuery("from Account");
			System.out.println(accounts.list().size());
			logger.info("test");
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private long erzeugeAccount() {
		Account account = new Account();
		Session session = null;
		Transaction transaction = null;
		try {
			session = mSessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(account);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
				throw e;
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return account.getPkey();
	}

}
