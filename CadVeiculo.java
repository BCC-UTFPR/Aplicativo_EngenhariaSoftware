package database;

import Persistencia.DAO;
import Persistencia.DAOInterface;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe Fronchetti
 */

@Entity
@Table(name = "CAD_Veiculo")
public class CadPessoas implements Serializable, DAOInterface {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Ano")
    private String Ano;
    @Column(name = "Quilometragem")
    private String Quilometragem;
    @Column(name = "Placa")
    private String Placa;
    @Column(name = "Cor")
    private String Cor;
    @Column(name = "Marca")
    private String Marca;
    @Column(name = "Modelo")
    private String Modelo;
    @Column(name = "Categoria")
    private String Categoria;
    @Column(name = "Renavam")
    private String Renavam;
    @Column(name = "EstadoConservacao")
    private String EstadoConservacao;
    @Column(name = "ComentariosAdicionais")
    private String ComentariosAdicionais;

    public CadPessoas() {
    }

    public CadPessoas() {
        this.id = id;
        this.Ano = Ano;
        this.Quilometragem = Quilometragem;
        this.Placa = Placa;
        this.Cor = Cor;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Categoria = Categoria;
        this.Renavam = Renavam;
		this.EstadoConservacao = EstadoConservacao;
        this.ComentariosAdicionais = ComentariosAdicionais;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }
    
    public String getQuilometragem() {
		return Quilometragem;
	}
	
	public void setQuilometragem(String Quilometragem){
		this.Quilometragem = Quilometragem;
	}

    public String getPlaca() {
		return Placa;
	}
	
	public void setPlaca(String Placa){
		this.Placa = Placa;
	}
	
    public String getCor() {
		return Cor;
	}
	
	public void setCor(String Cor){
		this.Cor = Cor;
	}
	
	public String getMarca() {
		return Marca;
	}
	
	public void setMarca(String Marca){
		this.Marca = Marca;
	}
	
	public String getModelo() {
		return Modelo;
	}
	
	public void setModelo(String Modelo){
		this.Modelo = Modelo;
	}
	
	public String getCategoria() {
		return Categoria;
	}
	
	public void setCategoria(String Categoria){
		this.Categoria = Categoria;
	}
	
	public String getRenavam() {
		return Renavam;
	}
	
	public void setRenavam(String Renavam){
		this.Renavam = Renavam;
	}
	
	public String getEstadoConservacao() {
		return EstadoConservacao;
	}
	
	public void setEstadoConservacao(String EstadoConservacao){
		this.EstadoConservacao = EstadoConservacao;
	}
	
	public String getComentariosAdicionais() {
		return ComentariosAdicionais;
	}
	
	public void setComentariosAdicionais(String ComentariosAdicionais){
		this.ComentariosAdicionais = ComentariosAdicionais;
	}
}
