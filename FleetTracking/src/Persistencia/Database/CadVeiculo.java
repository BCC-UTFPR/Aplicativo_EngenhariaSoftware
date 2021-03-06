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
@Table(name = "CAD_VEICULO")
public class CadVeiculo implements Serializable, DAOInterface {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ANO")
    private int ano;
    @Column(name = "KM")
    private double quilometragem;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "CATEGORIA_CNH")
    private String categoriaCNH;
    @Column(name = "RENAVAM")
    private String renavam;
    @Column(name = "COMSERVACAO")
    private String conservacao;
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @Column(name = "AUSENTE")
    private boolean ausente;

    public CadVeiculo() {}

    public CadVeiculo(Long id, int ano, double quilometragem, String placa, String marca, String modelo, String categoriaCNH, String renavam, String conservacao, String comentarios, boolean ausente) {
        this.id = id;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.categoriaCNH = categoriaCNH;
        this.renavam = renavam;
        this.conservacao = conservacao;
        this.comentarios = comentarios;
        this.ausente = ausente;
    }

    public boolean isAusente() {
        return ausente;
    }

    public void setAusente(boolean ausente) {
        this.ausente = ausente;
    } 

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
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
        return this.id;
    }

    @Override
    public String[] getColunas() {
        return new String[]{"Id", "Marca", "Modelo", "Ano", "Placa", "Renavam", "Categoria CNH"};
    }

    @Override
    public Object[] toArray() {
        return new Object[]{id, marca, modelo, ano, placa, renavam, categoriaCNH};
    }

    @Override
    public int[] getDefineRenderersColumn() {
        return new int[]{40, 115, 115, 40, 115, 115, 60};}

    @Override
    public String getReferencia() {
        return this.getPlaca();
    }

    @Override
    public boolean validar() {
        return (!renavam.isEmpty() && !placa.isEmpty() && !modelo.isEmpty() && !marca.isEmpty() && (ano != 0) && !categoriaCNH.isEmpty());
    }
}
