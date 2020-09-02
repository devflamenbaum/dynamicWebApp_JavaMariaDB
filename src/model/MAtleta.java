package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import control.Atleta;

public class MAtleta {

	private String msg;

	public String getMsg() {
		return msg;
	}

	public Atleta auth(Atleta atleta) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			Query<?> query = session.createQuery(
					"from Atleta where login='" + atleta.getLogin() + "' and senha='" + atleta.getSenha() + "'");

			if (query.getResultList().isEmpty()) {
				HibernateUtil.fecharSession();
				msg = "Nenhum resultado encontrado!";
				return null;
			}

			atleta = (Atleta) query.list().get(0);

			HibernateUtil.fecharSession();
			return atleta;
		} catch (Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public List<Atleta> getListAtleta() {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			Query<?> query = session.createQuery("from Atleta");
			@SuppressWarnings("unchecked")
			List<Atleta> listAtleta = (List<Atleta>) query.list();
			HibernateUtil.fecharSession();
			return listAtleta;
		} catch (Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public Atleta getAtleta(Atleta atleta, int id) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			atleta = session.get(Atleta.class, id);
			HibernateUtil.fecharSession();
			return atleta;
		} catch (Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public boolean cadastrar(Atleta atleta) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.save(atleta);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean atualizar(Atleta atleta) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.update(atleta);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean deletar(Atleta atleta) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.delete(atleta);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		} catch (Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public boolean buscarCPF(String cpf) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Atleta where cpf='" + cpf + "'");
		@SuppressWarnings("unchecked")
		List<Atleta> listAtleta = (List<Atleta>) query.list();
		if (listAtleta.size() > 0) {
			msg = "Atleta com cpf: " + cpf + ". Já cadastrado(a)!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarLogin(String login) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Atleta where login='" + login + "'");
		if (!query.getResultList().isEmpty()) {
			msg = "Atleta com login: " + login + ". Já cadastrado(a)!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarCPF(String cpf, int id) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Atleta where cpf='" + cpf + "' and id !=" + id);
		@SuppressWarnings("unchecked")
		List<Atleta> listAtleta = (List<Atleta>) query.list();
		if (listAtleta.size() > 0) {
			msg = "Cpf: " + cpf + ". Já cadastrado no banco de dados!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarLogin(String login, int id) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Atleta where login='" + login + "' and id != " + id);
		if (!query.getResultList().isEmpty()) {
			msg = "Login: " + login + ". Já cadastrado no banco de dados!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}
}
