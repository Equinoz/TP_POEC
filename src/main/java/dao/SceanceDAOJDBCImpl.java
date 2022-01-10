package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bo.Sceance;

public class SceanceDAOJDBCImpl {

	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	public static List<Sceance> selectByDate(LocalDateTime dateTime) {
		return session.createQuery("from Sceance where horaireSceance = param", Sceance.class).setParameter("param", Timestamp.valueOf(dateTime)).list();
	}

	public static List<Sceance> selectAll() {
		return session.createQuery("from Sceance", Sceance.class).list();
	}

	public static Sceance selectById(int id) {
		return session.find(Sceance.class, id);
	}

	public static Sceance insert(Sceance sceance) {
		Transaction t = session.beginTransaction();
		try {
			session.save(sceance);
			session.flush();
			t.commit();
			return sceance;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Sceance update(Sceance sceance) {
		Transaction t = session.beginTransaction();
		try {
			session.update(sceance);
			session.flush();
			t.commit();
			return sceance;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Sceance delete(Sceance sceance) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(sceance);
			session.flush();
			t.commit();
			return sceance;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

}
