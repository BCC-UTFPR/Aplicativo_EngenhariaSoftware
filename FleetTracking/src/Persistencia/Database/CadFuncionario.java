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
    @Column(name = "ADMINISTRADOR")
    private boolean adm;
    @Column(name = "AUSENTE")
    private boolean ausente;
    @Column(name = "SENHA")
    private String senha;

    public CadFuncionario() {
    }

    public CadFuncionario(Long id, String nome, String registro, String cpf, String rg, String cnh, String comentarios, boolean adm, boolean ausente, String senha) {
        this.id = id;
        this.nome = nome;
        this.registro = registro;
        this.cpf = cpf;
        this.rg = rg;
        this.cnh = cnh;
        this.comentarios = comentarios;
        this.adm = adm;
        this.ausente = ausente;
        this.senha = senha;
    }

    public boolean isAusente() {
        return ausente;
    }

    public void setAusente(boolean ausente) {
        this.ausente = ausente;
    } 

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public boolean getAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
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
