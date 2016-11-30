/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.ProdutoVO;

/**
 *
 * @author Fate
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

    public ProdutoVO excluir(ProdutoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getProduto_id());

            statement.executeUpdate();
        }
        return vo;

    }
}
