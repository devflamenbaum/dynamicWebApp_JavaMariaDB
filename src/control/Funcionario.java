package control;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.MFuncionario;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

	@Column(columnDefinition = "varchar(100)")
	private String funcao;

	@Transient
	private String msg;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, int idade, Date dataDeNascimento, String sexo, String endereco,
			String cidade, String estado, String telefone, String email, String login, String senha, String funcao) {
		super(nome, cpf, idade, dataDeNascimento, sexo, endereco, cidade, estado, telefone, email, login, senha);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean authenticate() {
		MFuncionario modelFunc = new MFuncionario();
		Funcionario aux = modelFunc.auth(this);
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
			this.setFuncao(aux.getFuncao());
			return true;
		}
		return false;

	}

	public boolean cadastrar() {
		MFuncionario modelFunc = new MFuncionario();
		if (!modelFunc.buscarCPF(this.getCpf()) && !modelFunc.buscarLogin(this.getLogin())) {
			if (modelFunc.cadastrar(this)) {
				this.msg = "cadastro realizado com sucesso!";
				return true;
			}
		} else {
			this.msg = modelFunc.getMsg();
			return false;
		}
		this.msg = "Erro ao cadastrar Funcionario!";
		return false;
	}

	public List<Funcionario> getListFuncionario() {
		MFuncionario modelFunc = new MFuncionario();
		return modelFunc.getListFuncionario();
	}

	public boolean editar(int id) {
		MFuncionario modelFunc = new MFuncionario();
		Funcionario aux = modelFunc.getFunc(this, id);
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
			this.setFuncao(aux.getFuncao());
			;
			return true;
		}
		return false;
	}

	public boolean atualizar() {
		MFuncionario modelFunc = new MFuncionario();
		if (!modelFunc.buscarCPF(this.getCpf(), this.getId())
				&& !modelFunc.buscarLogin(this.getLogin(), this.getId())) {
			if (modelFunc.atualizar(this)) {
				return true;
			}
		} else {
			this.msg = modelFunc.getMsg();
			return false;
		}
		this.msg = "Erro ao cadastrar Funcionario!";
		return false;
	}

	public boolean excluir() {
		MFuncionario modelFunc = new MFuncionario();
		if (modelFunc.deletar(this)) {
			return true;
		} else {
			return false;
		}
	}

}
