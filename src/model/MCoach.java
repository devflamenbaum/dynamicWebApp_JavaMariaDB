package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import control.Coach;

public class MCoach {
	
	private String msg;

	public String getMsg() {
		return msg;
	}
	
	public boolean cadastrar(Coach coach) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			
			session.save(coach);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		}catch(Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public List<Coach> getListCoach(){
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			Query<?> query = session.createQuery("from Coach");
			@SuppressWarnings("unchecked")
			List<Coach> listCoach = (List<Coach>) query.list();
			HibernateUtil.fecharSession();
			return listCoach;
		} catch(Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public Coach getCoach(Coach coach, int id) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			coach = session.get(Coach.class, id);
			HibernateUtil.fecharSession();
			return coach;
		} catch(Exception e) {
			msg = e.toString();
			return null;
		}
	}
	
	public boolean atualizar(Coach coach) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.update(coach);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		}catch(Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public boolean deletar(Coach coach) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.delete(coach);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		}catch(Exception e) {
			msg = e.toString();
			return false;
		}
	}

	public Coach auth(Coach coach) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			Query<?> query = session.createQuery(
					"from Coach where login='" + coach.getLogin() + "' and senha='" + coach.getSenha() + "'");

			if (query.getResultList().isEmpty()) {
				HibernateUtil.fecharSession();
				msg = "Nenhum resultado encontrado!";
				return null;
			}
			
			coach = (Coach) query.list().get(0);
			HibernateUtil.fecharSession();
			return coach;
		} catch (Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public boolean buscarCPF(String cpf) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Coach where cpf='" + cpf + "'");
		@SuppressWarnings("unchecked")
		List<Coach> listCoach = (List<Coach>) query.list();
		if (listCoach.size() > 0) {
			msg = "Coach com cpf: " + cpf + ". Já cadastrado(a)!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}
	
	public boolean buscarLogin(String login) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Coach where login='" + login + "'");
		if (!query.getResultList().isEmpty()) {
			msg = "Coach com login: " + login + ". Já cadastrado(a)!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarCPF(String cpf, int id) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Coach where cpf='" + cpf + "' and id !=" + id);
		@SuppressWarnings("unchecked")
		List<Coach> listCoach = (List<Coach>) query.list();
		if (listCoach.size() > 0) {
			msg = "Cpf: " + cpf + ". Já cadastrado no banco de dados!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarLogin(String login, int id) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Coach where login='" + login + "' and id != " + id);
		if (!query.getResultList().isEmpty()) {
			msg = "Login: " + login + ". Já cadastrado no banco de dados!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}
}
