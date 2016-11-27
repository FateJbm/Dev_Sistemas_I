/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author Juliano
 */
public class ClienteVO {

    private int cliente_id;
    private String cliente_cpf;
    private String cliente_nome;
    private String cliente_rg;
    private String cliente_endereco;
    private String cliente_cidade;
    private String cliente_estado;
    private String cliente_email;
    private int cliente_fone;
    private String cliente_dataCadastro;
            
    private boolean cliente_ativo;

    /**
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the cliente_cpf
     */
    public String getCliente_cpf() {
        return cliente_cpf;
    }

    /**
     * @param cliente_cpf the cliente_cpf to set
     */
    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    /**
     * @return the cliente_nome
     */
    public String getCliente_nome() {
        return cliente_nome;
    }

    /**
     * @param cliente_nome the cliente_nome to set
     */
    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    /**
     * @return the cliente_rg
     */
    public String getCliente_rg() {
        return cliente_rg;
    }

    /**
     * @param cliente_rg the cliente_rg to set
     */
    public void setCliente_rg(String cliente_rg) {
        this.cliente_rg = cliente_rg;
    }

    /**
     * @return the cliente_endereco
     */
    public String getCliente_endereco() {
        return cliente_endereco;
    }

    /**
     * @param cliente_endereco the cliente_endereco to set
     */
    public void setCliente_endereco(String cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    /**
     * @return the cliente_cidade
     */
    public String getCliente_cidade() {
        return cliente_cidade;
    }

    /**
     * @param cliente_cidade the cliente_cidade to set
     */
    public void setCliente_cidade(String cliente_cidade) {
        this.cliente_cidade = cliente_cidade;
    }

    /**
     * @return the cliente_estado
     */
    public String getCliente_estado() {
        return cliente_estado;
    }

    /**
     * @param cliente_estado the cliente_estado to set
     */
    public void setCliente_estado(String cliente_estado) {
        this.cliente_estado = cliente_estado;
    }

    /**
     * @return the cliente_email
     */
    public String getCliente_email() {
        return cliente_email;
    }

    /**
     * @param cliente_email the cliente_email to set
     */
    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    /**
     * @return the cliente_fone
     */
    public int getCliente_fone() {
        return cliente_fone;
    }

    /**
     * @param cliente_fone the cliente_fone to set
     */
    public void setCliente_fone(int cliente_fone) {
        this.cliente_fone = cliente_fone;
    }

    /**
     * @return the cliente_dataCadastro
     */
    public String getCliente_dataCadastro() {
        return cliente_dataCadastro;
    }

    /**
     * @param cliente_dataCadastro the cliente_dataCadastro to set
     */
    public void setCliente_dataCadastro(String cliente_dataCadastro) {
        this.cliente_dataCadastro = cliente_dataCadastro;
    }

    /**
     * @return the cliente_ativo
     */
    public boolean isCliente_ativo() {
        return cliente_ativo;
    }

    /**
     * @param cliente_ativo the cliente_ativo to set
     */
    public void setCliente_ativo(boolean cliente_ativo) {
        this.cliente_ativo = cliente_ativo;
    }


}