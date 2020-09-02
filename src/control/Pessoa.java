package control;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = true, columnDefinition = "varchar(100)")
	private String nome;
	@Column(nullable = true, columnDefinition="char(14)", unique = true)
	private String cpf;
	@Column(columnDefinition = "int default 0")
	private int idade;
	@Column(name = "dataNascimento", columnDefinition = "date")
	private Date dataDeNascimento;
	@Column(columnDefinition = "varchar(10)")
	private String sexo;
	@Column(columnDefinition = "varchar(150)")
	private String endereco;
	@Column(columnDefinition = "varchar(30)")
	private String cidade;
	@Column(columnDefinition = "varchar(20)")
	private String estado;
	@Column(columnDefinition = "varchar(12)")
	private String telefone;
	@Column(columnDefinition = "varchar(50)")
	private String email;
	@Column(columnDefinition = "varchar(10)")
	private String login;
	@Column(columnDefinition = "varchar(10)")
	private String senha;
	
	protected Pessoa() {
		
	}

	protected Pessoa(String nome, String cpf, int idade, Date dataDeNascimento, String sexo, String endereco,
			String cidade, String estado, String telefone, String email, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.dataDeNascimento = dataDeNascimento;
		this.sexo = sexo;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", dataDeNascimento="
				+ dataDeNascimento + ", sexo=" + sexo + ", endereco=" + endereco + ", cidade=" + cidade + ", estado="
				+ estado + ", telefone=" + telefone + ", email=" + email + ", login=" + login + ", senha=" + senha
				+ "]";
	}
		

}
