/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.ProdutoVO;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 *
 * @author Juliano Bernardi
 */
public class ProdutoDAO {

    private static final String SELECT
            = "SELECT * FROM produto WHERE idproduto = ?";

    private static final String INSERT
            = "INSERT INTO produto (nome, descricao, preco)"
            + "VALUES(?, ?, ?)";

    private static final String UPDATE
            = "UPDATE produto SET nome = ?, descricao = ?, preco = ?"
            + "WHERE idproduto = ?";

    private static final String DELETE
            = "DELETE from produto WHERE idproduto = ?";

    /**
     * Método de busca geral
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public ProdutoVO buscar(ProdutoVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            statement.setInt(1, vo.getProduto_id());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setProduto_id(resultSet.getInt("idcliente"));
            vo.setProduto_nome(resultSet.getString("nome"));
            vo.setProduto_descricao(resultSet.getString("rg"));
            vo.setProduto_custo(resultSet.getFloat("endereco"));

            resultSet.close();
            statement.close();
        }

        return vo;
    }

    /**
     * Método de criação / inclusão na tabela
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public ProdutoVO criar(ProdutoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, vo.getProduto_nome());
            statement.setString(2, vo.getProduto_descricao());
            statement.setFloat(3, vo.getProduto_custo());

            statement.executeUpdate();
        }
        return vo;
    }

    /**
     * Método de Alteração do registro
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public ProdutoVO alterar(ProdutoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, vo.getProduto_nome());
            statement.setString(2, vo.getProduto_descricao());
            statement.setFloat(3, vo.getProduto_custo());

            statement.setInt(4, vo.getProduto_id());

            statement.executeUpdate();
        }
        return vo;

    }

    /**
     * Método de exclusão com id
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public ProdutoVO excluir(ProdutoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getProduto_id());

            statement.executeUpdate();
        }
        return vo;

    }
}
