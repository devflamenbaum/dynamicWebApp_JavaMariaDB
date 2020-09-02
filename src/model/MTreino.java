package model;

import org.hibernate.Session;
import org.hibernate.query.Query;

import control.Treino;

public class MTreino {

	public boolean cadastrar(Treino treino) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.save(treino);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Treino getTreino(Treino treino, String data) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("From Treino where dataTreino='" + data + "'");
		if (query.getResultList().isEmpty()) {
			return null;
		}

		treino = (Treino) query.list().get(0);
		return treino;
	}

	public boolean atualizar(Treino treino) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.update(treino);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public boolean deletar(Treino treino) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.delete(treino);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
