package dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bo.Client;

public class ClientDAOJDCImpl {
	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	public static List<Client> selectAll() {
		return session.createQuery("from Client", Client.class).list();
	}

	public static Client selectByName(String strToSearchFor) {
		return session.createQuery("from Client where nom = :param_nom", Client.class)
				.setParameter("param_nom", strToSearchFor).getSingleResult();
	}

	public static Client selectById(int id) {
		return session.find(Client.class, id);
	}

	public static Client insert(Client client) {
		Transaction t = session.beginTransaction();
		try {
			session.save(client);
			session.flush();
			t.commit();
			return client;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Client update(Client client) {
		Transaction t = session.beginTransaction();
		try {
			session.update(client);
			session.flush();
			t.commit();
			return client;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Client delete(Client client) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(client);
			session.flush();
			t.commit();
			return client;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}
}
