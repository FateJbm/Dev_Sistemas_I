/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author Fate
 */
public class ReciboVO {
    private int recibo_id;
    private int recibo_cliente;
    private String recibo_dataemissao;
    private String recibo_horaemissao;
    private float recibo_valorfinal;
    private String recibo_resumo;

    /**
     * @return the recibo_id
     */
    public int getRecibo_id() {
        return recibo_id;
    }

    /**
     * @param recibo_id the recibo_id to set
     */
    public void setRecibo_id(int recibo_id) {
        this.recibo_id = recibo_id;
    }

    /**
     * @return the recibo_cliente
     */
    public int getRecibo_cliente() {
        return recibo_cliente;
    }

    /**
     * @param recibo_cliente the recibo_cliente to set
     */
    public void setRecibo_cliente(int recibo_cliente) {
        this.recibo_cliente = recibo_cliente;
    }

    /**
     * @return the recibo_dataemissao
     */
    public String getRecibo_dataemissao() {
        return recibo_dataemissao;
    }

    /**
     * @param recibo_dataemissao the recibo_dataemissao to set
     */
    public void setRecibo_dataemissao(String recibo_dataemissao) {
        this.recibo_dataemissao = recibo_dataemissao;
    }

    /**
     * @return the recibo_horaemissao
     */
    public String getRecibo_horaemissao() {
        return recibo_horaemissao;
    }

    /**
     * @param recibo_horaemissao the recibo_horaemissao to set
     */
    public void setRecibo_horaemissao(String recibo_horaemissao) {
        this.recibo_horaemissao = recibo_horaemissao;
    }

    /**
     * @return the recibo_valorfinal
     */
    public float getRecibo_valorfinal() {
        return recibo_valorfinal;
    }

    /**
     * @param recibo_valorfinal the recibo_valorfinal to set
     */
    public void setRecibo_valorfinal(float recibo_valorfinal) {
        this.recibo_valorfinal = recibo_valorfinal;
    }

    /**
     * @return the recibo_resumo
     */
    public String getRecibo_resumo() {
        return recibo_resumo;
    }

    /**
     * @param recibo_resumo the recibo_resumo to set
     */
    public void setRecibo_resumo(String recibo_resumo) {
        this.recibo_resumo = recibo_resumo;
    }
    
}
