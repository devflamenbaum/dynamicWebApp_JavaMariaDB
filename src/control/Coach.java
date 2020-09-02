package control;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.MCoach;

@Entity
@Table(name = "coachs")
public class Coach extends Pessoa {

	@Column(columnDefinition = "varchar(255)")
	private String certificados;

	@Transient
	private String msg;

	public Coach() {
		super();
	}

	public Coach(String nome, String cpf, int idade, Date dataDeNascimento, String sexo, String endereco, String cidade,
			String estado, String telefone, String email, String login, String senha, String certificados) {
		super(nome, cpf, idade, dataDeNascimento, sexo, endereco, cidade, estado, telefone, email, login, senha);
		this.certificados = certificados;
	}

	public String getCertificados() {
		return certificados;
	}

	public void setCertificados(String certificados) {
		this.certificados = certificados;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean cadastrar() {
		MCoach mc = new MCoach();
		if (!mc.buscarCPF(this.getCpf()) && !mc.buscarLogin(this.getLogin())) {
			if (mc.cadastrar(this)) {
				this.msg = "cadastro realizado com sucesso!";
				return true;
			}
		} else {
			this.msg = mc.getMsg();
			return false;
		}
		this.msg = "Erro ao cadastrar Coach!";
		return false;
	}

	public List<Coach> getListCoach() {
		MCoach mc = new MCoach();
		return mc.getListCoach();
	}

	public boolean editar(int id) {
		MCoach mc = new MCoach();
		Coach aux = mc.getCoach(this, id);
		if (aux != null) {
			this.setId(aux.getId());
			this.setNome(aux.getNome());
			this.setCpf(aux.getCpf());
			this.setIdade(aux.getIdade());
			this.setDataDeNascimento(aux.getDataDeNascimento());
			this.setSexo(aux.getSexo());
			this.setEndereco(aux.getEndereco());
			this.setCidade(aux.getCidade());
			this.setEstado(aux.getEstado());
			this.setTelefone(aux.getTelefone());
			this.setEmail(aux.getEmail());
			this.setLogin(aux.getLogin());
			this.setSenha(aux.getSenha());
			this.setCertificados(aux.getCertificados());
			return true;
		}
		return false;
	}

	public boolean atualizar() {
		MCoach mc = new MCoach();
		if (!mc.buscarCPF(this.getCpf(), this.getId())
				&& !mc.buscarLogin(this.getLogin(), this.getId())) {
			if (mc.atualizar(this)) {
				return true;
			}
		} else {
			this.msg = mc.getMsg();
			return false;
		}
		this.msg = "Erro ao cadastrar Coach!";
		return false;
	}

	public boolean excluir() {
		MCoach mc = new MCoach();
		if (mc.deletar(this)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean authenticate() {
		MCoach mc = new MCoach();
		Coach aux = mc.auth(this);
		if (aux != null) {
			this.setId(aux.getId());
			this.setNome(aux.getNome());
			this.setCpf(aux.getCpf());
			this.setIdade(aux.getIdade());
			this.setDataDeNascimento(aux.getDataDeNascimento());
			this.setSexo(aux.getSexo());
			this.setEndereco(aux.getEndereco());
			this.setCidade(aux.getCidade());
			this.setEstado(aux.getEstado());
			this.setTelefone(aux.getTelefone());
			this.setEmail(aux.getEmail());
			this.setLogin(aux.getLogin());
			this.setSenha(aux.getSenha());
			this.setCertificados(aux.getCertificados());
			return true;
		}
		return false;

	}

}
