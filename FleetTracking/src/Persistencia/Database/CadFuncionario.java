package Persistencia.Database;

import Persistencia.DAOInterface;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Felipe Fronchetti
 */

@Entity
@Table(name = "CAD_FUNCIONARIO")
public class CadFuncionario implements Serializable, DAOInterface {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "REGISTRO")
    private String registro;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @Column(name = "CNH")
    private String cnh;
    @Column(name = "COMENTARIOS")
    private String comentarios;

    public CadFuncionario() {
    }

    public CadFuncionario(String nome, String registro,String cpf, String rg, String cnh, String comentarios) {
        this.nome = nome;
        this.registro = registro;
        this.cpf = cpf;
        this.rg = rg;
        this.cnh = cnh;
        this.comentarios = comentarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public String[] getColunas() {
        return new String[]{"Id", "Nome", "Registro", "CPF", "Categoria CNH"};
    }

    @Override
    public Object[] toArray() {
        return new Object[]{id, nome, registro, cpf, cnh};
    }

    @Override
    public int[] getDefineRenderersColumn() {
        return new int[]{40, 230, 115, 115, 60};}

    @Override
    public String getReferencia() {
        return this.getNome();
    }

    @Override
    public boolean validar() {
        return (!nome.isEmpty() && !registro.isEmpty() && !cpf.isEmpty() && !rg.isEmpty() && !cnh.isEmpty());
    }
}
