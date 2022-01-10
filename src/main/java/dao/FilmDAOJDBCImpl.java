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

import bo.Film;

/**
 * @author exia
 *
 */
public class FilmDAOJDBCImpl {

	private static Session session;

	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	public static List<Film> selectAll() {
		return session.createQuery("from Film", Film.class).list();
	}

	public static Film selectByName(String strToSearchFor) {
		return session.createQuery("from Film where nom = :param_nom", Film.class)
				.setParameter("param_nom", strToSearchFor).getSingleResult();
	}

	public static Film selectById(int id) {
		return session.find(Film.class, id);
	}

	public static Film insert(Film film) {
		Transaction t = session.beginTransaction();
		try {
			session.save(film);
			session.flush();
			t.commit();
			return film;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Film update(Film film) {
		Transaction t = session.beginTransaction();
		try {
			session.update(film);
			session.flush();
			t.commit();
			return film;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

	public static Film delete(Film film) {
		Transaction t = session.beginTransaction();
		try {
			session.delete(film);
			session.flush();
			t.commit();
			return film;
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
			return null;
		}
	}

}