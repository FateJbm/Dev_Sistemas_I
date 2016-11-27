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
public class ServicoVO {
    
    private int servico_id;
    private String servico_nome;
    private int servico_tempo;
    private float servico_custo;

    /**
     * @return the servico_id
     */
    public int getServico_id() {
        return servico_id;
    }

    /**
     * @param servico_id the servico_id to set
     */
    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }

    /**
     * @return the servico_nome
     */
    public String getServico_nome() {
        return servico_nome;
    }

    /**
     * @param servico_nome the servico_nome to set
     */
    public void setServico_nome(String servico_nome) {
        this.servico_nome = servico_nome;
    }

    /**
     * @return the servico_tempo
     */
    public int getServico_tempo() {
        return servico_tempo;
    }

    /**
     * @param servico_tempo the servico_tempo to set
     */
    public void setServico_tempo(int servico_tempo) {
        this.servico_tempo = servico_tempo;
    }

    /**
     * @return the servico_custo
     */
    public float getServico_custo() {
        return servico_custo;
    }

    /**
     * @param servico_custo the servico_custo to set
     */
    public void setServico_custo(float servico_custo) {
        this.servico_custo = servico_custo;
    }
    
}
