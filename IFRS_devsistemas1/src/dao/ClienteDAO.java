/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.ClienteVO;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 *
 * @author Juliano Bernardi
 */
public class ClienteDAO {

    private static final String SELECT
            = "SELECT * FROM cliente WHERE idcliente = ?";

    private static final String INSERT
            = "INSERT INTO cliente (cpf, nome, rg, endereco, cidade, estado, email, fone)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE
            = "UPDATE cliente SET cpf = ?, nome = ?, rg = ?, endereco = ?, cidade = ?, estado = ?, email = ?, fone = ?"
            + "WHERE idcliente = ?";

    private static final String DELETE
            = "DELETE from cliente WHERE idcliente = ?";

    /**
     * Método de busca geral
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public ClienteVO buscar(ClienteVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            statement.setInt(1, vo.getCliente_id());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setCliente_id(resultSet.getInt("idcliente"));
            vo.setCliente_cpf(resultSet.getString("cpf"));
            vo.setCliente_nome(resultSet.getString("nome"));
            vo.setCliente_rg(resultSet.getString("rg"));
            vo.setCliente_endereco(resultSet.getString("endereco"));
            vo.setCliente_cidade(resultSet.getString("cidade"));
            vo.setCliente_estado(resultSet.getString("estado"));
            vo.setCliente_email(resultSet.getString("email"));
            vo.setCliente_fone(resultSet.getString("fone"));
            vo.setCliente_dataCadastro(resultSet.getString("datacadastro"));

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
    public ClienteVO criar(ClienteVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, vo.getCliente_cpf());
            statement.setString(2, vo.getCliente_nome());
            statement.setString(3, vo.getCliente_rg());
            statement.setString(4, vo.getCliente_endereco());
            statement.setString(5, vo.getCliente_cidade());
            statement.setString(6, vo.getCliente_estado());
            statement.setString(7, vo.getCliente_email());
            statement.setString(8, vo.getCliente_fone());

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
    public ClienteVO alterar(ClienteVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, vo.getCliente_cpf());
            statement.setString(2, vo.getCliente_nome());
            statement.setString(3, vo.getCliente_rg());
            statement.setString(4, vo.getCliente_endereco());
            statement.setString(5, vo.getCliente_cidade());
            statement.setString(6, vo.getCliente_estado());
            statement.setString(7, vo.getCliente_email());
            statement.setString(8, vo.getCliente_fone());

            statement.setInt(9, vo.getCliente_id());

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
    public ClienteVO excluir(ClienteVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getCliente_id());

            statement.executeUpdate();
        }
        return vo;

    }
}
