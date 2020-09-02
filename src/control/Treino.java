package control;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.MTreino;

@Entity
@Table(name = "treinos")
public class Treino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "varchar(10)")
	private String titulo;
	@Column(columnDefinition = "varchar(255)")
	private String descricao;
	@Column(name = "dataTreino", columnDefinition = "date")
	private Date dataTreino;
	
	public Treino() {
		
	}
	
	public Treino(int id, String titulo, String descricao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public Date getDataTreino() {
		return dataTreino;
	}

	public void setDataTreino(Date dataTreino) {
		this.dataTreino = dataTreino;
	}

	@Override
	public String toString() {
		return "Treino [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + "]";
	}

	public boolean cadastrar() {
		MTreino mt = new MTreino();
		if(mt.cadastrar(this)) {
			return true;
		}
		return false;
	}

	public Treino getTreino(String data) {
		MTreino mt = new MTreino();
		return mt.getTreino(this,data);
	}

	public boolean atualizar() {
		MTreino mt = new MTreino();
		if(mt.atualizar(this)) {
			return true;
		}
		return false;
	}

	public boolean deletar() {
		MTreino mt = new MTreino();
		if(mt.deletar(this)) {
			return true;
		}
		return false;
	}
	
	
}
