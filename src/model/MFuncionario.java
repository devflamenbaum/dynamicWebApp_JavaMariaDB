package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import control.Funcionario;

public class MFuncionario {
	
	private String msg;

	public String getMsg() {
		return msg;
	}
	
	public Funcionario auth(Funcionario func) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			Query<?> query = session.createQuery("from Funcionario where login='" + func.getLogin()
					+ "' and senha='" + func.getSenha() + "'");

			if (query.getResultList().isEmpty()) {
				HibernateUtil.fecharSession();
				msg = "Nenhum resultado encontrado!";
				return null;
			}

			func = (Funcionario) query.list().get(0);

			HibernateUtil.fecharSession();
			return func;
		} catch (Exception e) {
			msg = e.toString();
			return null;
		}
	}
	
	public boolean cadastrar(Funcionario funcionario) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			
			session.save(funcionario);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		}catch(Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public List<Funcionario> getListFuncionario(){
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			Query<?> query = session.createQuery("from Funcionario");
			@SuppressWarnings("unchecked")
			List<Funcionario> listFuncionario = (List<Funcionario>) query.list();
			HibernateUtil.fecharSession();
			return listFuncionario;
		} catch(Exception e) {
			msg = e.toString();
			return null;
		}
	}

	public Funcionario getFunc(Funcionario funcionario, int id) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			funcionario = session.get(Funcionario.class, id);
			HibernateUtil.fecharSession();
			return funcionario;
		} catch(Exception e) {
			msg = e.toString();
			return null;
		}
	}
	
	public boolean atualizar(Funcionario funcionario) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.update(funcionario);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		}catch(Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public boolean deletar(Funcionario funcionario) {
		Session session = HibernateUtil.abrirSession();
		try {
			session.beginTransaction();
			session.delete(funcionario);
			session.getTransaction().commit();
			HibernateUtil.fecharSession();
			return true;
		}catch(Exception e) {
			msg = e.toString();
			return false;
		}
	}
	
	public boolean buscarCPF(String cpf) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Funcionario where cpf='" + cpf + "'");
		@SuppressWarnings("unchecked")
		List<Funcionario> listFunc = (List<Funcionario>) query.list();
		if (listFunc.size() > 0) {
			msg = "Funcionario com cpf: " + cpf + ". Já cadastrado(a)!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}
	
	public boolean buscarLogin(String login) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Funcionario where login='" + login + "'");
		if (!query.getResultList().isEmpty()) {
			msg = "Funcionario com login: " + login + ". Já cadastrado(a)!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarCPF(String cpf, int id) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Funcionario where cpf='" + cpf + "' and id !=" + id);
		@SuppressWarnings("unchecked")
		List<Funcionario> listFunc = (List<Funcionario>) query.list();
		if (listFunc.size() > 0) {
			msg = "Cpf: " + cpf + ". Já cadastrado no banco de dados!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}

	public boolean buscarLogin(String login, int id) {
		Session session = HibernateUtil.abrirSession();
		session.beginTransaction();
		Query<?> query = session.createQuery("from Funcionario where login='" + login + "' and id != " + id);
		if (!query.getResultList().isEmpty()) {
			msg = "Login: " + login + ". Já cadastrado no banco de dados!";
			return true;
		}
		HibernateUtil.fecharSession();
		return false;
	}
}
