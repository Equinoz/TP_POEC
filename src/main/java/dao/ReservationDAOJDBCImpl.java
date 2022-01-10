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

import bo.Reservation;

public class ReservationDAOJDBCImpl {

	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	public static List<Reservation> selectAll() {
		return session.createQuery("from Reservation", Reservation.class).list();
	}

	public static Reservation selectByName(String strToSearchFor) {
		return session.createQuery("from Reservation where nom = :param_nom", Reservation.class)
				.setParameter("param_nom", strToSearchFor).getSingleResult();
	}

	public static Reservation selectById(int id) {
		return session.find(Reservation.class, id);
	}

	public static Reservation insert(Reservation reservation) {
		Transaction t = session.beginTransaction();
		try {
			session.save(reservation);
			session.flush();
			t.commit();
			return reservation;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Reservation update(Reservation reservation) {
		Transaction t = session.beginTransaction();
		try {
			session.update(reservation);
			session.flush();
			t.commit();
			return reservation;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Reservation delete(Reservation reservation) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(reservation);
			session.flush();
			t.commit();
			return reservation;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

}
