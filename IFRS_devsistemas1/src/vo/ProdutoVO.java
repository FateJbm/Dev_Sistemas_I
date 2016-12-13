/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package vo;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 * @author Juliano Bernardi
 */

public class ProdutoVO {
    
    private int produto_id;
    private String produto_nome;
    private String produto_descricao;
    private float produto_custo;

    /**
     * @return the produto_id
     */
    public int getProduto_id() {
        return produto_id;
    }

    /**
     * @param produto_id the produto_id to set
     */
    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    /**
     * @return the produto_nome
     */
    public String getProduto_nome() {
        return produto_nome;
    }

    /**
     * @param produto_nome the produto_nome to set
     */
    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    /**
     * @return the produto_descricao
     */
    public String getProduto_descricao() {
        return produto_descricao;
    }

    /**
     * @param produto_descricao the produto_descricao to set
     */
    public void setProduto_descricao(String produto_descricao) {
        this.produto_descricao = produto_descricao;
    }

    /**
     * @return the produto_custo
     */
    public float getProduto_custo() {
        return produto_custo;
    }

    /**
     * @param produto_custo the produto_custo to set
     */
    public void setProduto_custo(float produto_custo) {
        this.produto_custo = produto_custo;
    }
    
}
