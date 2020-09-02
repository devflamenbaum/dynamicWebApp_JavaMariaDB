package control;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.MAtleta;

@Entity
@Table(name = "atletas")
public class Atleta extends Pessoa {
	
	@Column(columnDefinition = "varchar(15)")
	private String categoria;
	@Column(columnDefinition = "boolean default true")
	private boolean ativo;
	
	@Transient
	private String msg;
	
	public Atleta() {
		super();
	}

	public Atleta(String nome, String cpf, int idade, Date dataDeNascimento, String sexo, String endereco,
			String cidade, String estado, String telefone, String email, String login, String senha, String categoria, boolean ativo) {
		super(nome, cpf, idade, dataDeNascimento, sexo, endereco, cidade, estado, telefone, email, login, senha);
		this.categoria = categoria;
		this.ativo = ativo;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean authenticate() {
		MAtleta modelAthlete = new MAtleta();
		Atleta aux = modelAthlete.auth(this);
		if(aux != null) {
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
			this.setAtivo(aux.isAtivo());
			this.setCategoria(aux.getCategoria());
			return true;
		}
		return false;
		
	}
	
	public List<Atleta> getListAtleta(){
		MAtleta ma = new MAtleta();
		return ma.getListAtleta();
	}

	public boolean cadastrar() {
		MAtleta ma = new MAtleta();
		if(!ma.buscarCPF(this.getCpf())&&!ma.buscarLogin(this.getLogin())) {
			if(ma.cadastrar(this)) {
				this.msg = "cadastro realizado com sucesso!";
				return true;
			}
		}else {
			this.msg = ma.getMsg();
			return false;
		}
		this.msg = "Erro ao cadastrar Atleta!";
		return false;
	}
	
	public boolean editar(int id) {
		MAtleta ma = new MAtleta();
		Atleta aux = ma.getAtleta(this, id);
		if(aux != null) {
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
			this.setAtivo(aux.isAtivo());
			this.setCategoria(aux.getCategoria());
			return true;
		}
		return false;
	}

	public boolean atualizar() {
		MAtleta ma = new MAtleta();
		if (!ma.buscarCPF(this.getCpf(), this.getId())
				&& !ma.buscarLogin(this.getLogin(), this.getId())) {
			if (ma.atualizar(this)) {
				return true;
			}
		} else {
			this.msg = ma.getMsg();
			return false;
		}
		this.msg = "Erro ao cadastrar Atleta!";
		return false;
	}

	public boolean excluir() {
		MAtleta ma = new MAtleta();
		if(ma.deletar(this)) {
			return true;
		} else {
			return false;
		}
	}
	
}
