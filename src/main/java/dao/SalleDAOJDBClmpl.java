package dao;

import bo.Salle;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SalleDAOJDBClmpl {

	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	public static List<Salle> selectAll() {
		return session.createQuery("from Salle", Salle.class).list();
	}

	public static Salle selectById(int id) {
		return session.find(Salle.class, id);
	}

	public static Salle insert(Salle salle) {
		Transaction t = session.beginTransaction();
		try {
			session.save(salle);
			session.flush();
			t.commit();
			return salle;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Salle update(Salle salle) {
		Transaction t = session.beginTransaction();
		try {
			session.update(salle);
			session.flush();
			t.commit();
			return salle;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Salle delete(Salle salle) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(salle);
			session.flush();
			t.commit();
			return salle;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

}
