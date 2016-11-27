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
public class AgendaVO {
    
    private String agenda_cliente;
    private int agenda_funcionario;
    private String agenda_data;
    private String agenda_inicio;
    private String agenda_fim;

    /**
     * @return the agenda_cliente
     */
    public String getAgenda_cliente() {
        return agenda_cliente;
    }

    /**
     * @param agenda_cliente the agenda_cliente to set
     */
    public void setAgenda_cliente(String agenda_cliente) {
        this.agenda_cliente = agenda_cliente;
    }

    /**
     * @return the agenda_funcionario
     */
    public int getAgenda_funcionario() {
        return agenda_funcionario;
    }

    /**
     * @param agenda_funcionario the agenda_funcionario to set
     */
    public void setAgenda_funcionario(int agenda_funcionario) {
        this.agenda_funcionario = agenda_funcionario;
    }

    /**
     * @return the agenda_data
     */
    public String getAgenda_data() {
        return agenda_data;
    }

    /**
     * @param agenda_data the agenda_data to set
     */
    public void setAgenda_data(String agenda_data) {
        this.agenda_data = agenda_data;
    }

    /**
     * @return the agenda_inicio
     */
    public String getAgenda_inicio() {
        return agenda_inicio;
    }

    /**
     * @param agenda_inicio the agenda_inicio to set
     */
    public void setAgenda_inicio(String agenda_inicio) {
        this.agenda_inicio = agenda_inicio;
    }

    /**
     * @return the agenda_fim
     */
    public String getAgenda_fim() {
        return agenda_fim;
    }

    /**
     * @param agenda_fim the agenda_fim to set
     */
    public void setAgenda_fim(String agenda_fim) {
        this.agenda_fim = agenda_fim;
    }
    
}
