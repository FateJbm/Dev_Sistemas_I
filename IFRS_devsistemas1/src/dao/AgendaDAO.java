/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.AgendaVO;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 *
 * @author Juliano Bernardi
 */
public class AgendaDAO {

    private static final String SELECT
            = "SELECT * FROM agenda WHERE idagenda = ?";

    private static final String SELECTCLIENTE
            = "SELECT * FROM agenda WHERE cliente_idcliente = ?";

    private static final String INSERT
            = "INSERT INTO agenda (cliente_idcliente, funcionario_idfuncionario, data, hora_inicio, hora_fim, status)"
            + "VALUES(?, ?, ?, ?, ?, ?)";

    private static final String UPDATE
            = "UPDATE agenda SET cliente_idcliente = ?, funcionario_idfuncionario = ?, data = ?, hora_inicio = ?, hora_fim = ?, status = ?"
            + "WHERE idagenda = ?";

    private static final String DELETE
            = "DELETE from agenda WHERE idagenda = ?";

    /**
     * Método de busca geral
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public AgendaVO buscar(AgendaVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            statement.setInt(1, vo.getAgenda_id());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setAgenda_id(resultSet.getInt("idagenda"));
            vo.setAgenda_cliente(resultSet.getInt("cliente_idcliente"));
            vo.setAgenda_funcionario(resultSet.getInt("funcionario_idfuncionario"));
            vo.setAgenda_data(resultSet.getString("data"));
            vo.setAgenda_inicio(resultSet.getString("hora_inicio"));
            vo.setAgenda_fim(resultSet.getString("hora_fim"));
            vo.setAgenda_status(resultSet.getString("status"));

            resultSet.close();
            statement.close();
        }

        return vo;
    }

    /**
     * Método de busca por id do cliente
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public AgendaVO buscarCliente(AgendaVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECTCLIENTE)) {
            statement.setInt(1, vo.getAgenda_cliente());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setAgenda_id(resultSet.getInt("idagenda"));
            vo.setAgenda_cliente(resultSet.getInt("cliente_idcliente"));
            vo.setAgenda_funcionario(resultSet.getInt("funcionario_idfuncionario"));
            vo.setAgenda_data(resultSet.getString("data"));
            vo.setAgenda_inicio(resultSet.getString("hora_inicio"));
            vo.setAgenda_fim(resultSet.getString("hora_fim"));
            vo.setAgenda_status(resultSet.getString("status"));

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
    public AgendaVO criar(AgendaVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, vo.getAgenda_cliente());
            statement.setInt(2, vo.getAgenda_funcionario());
            statement.setString(3, vo.getAgenda_data());
            statement.setString(4, vo.getAgenda_inicio());
            statement.setString(5, vo.getAgenda_fim());
            statement.setString(6, vo.getAgenda_status());

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
    public AgendaVO alterar(AgendaVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setInt(1, vo.getAgenda_cliente());
            statement.setInt(2, vo.getAgenda_funcionario());
            statement.setString(3, vo.getAgenda_data());
            statement.setString(4, vo.getAgenda_inicio());
            statement.setString(5, vo.getAgenda_fim());
            statement.setString(6, vo.getAgenda_status());

            statement.setInt(7, vo.getAgenda_id());

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
    public AgendaVO excluir(AgendaVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getAgenda_id());

            statement.executeUpdate();
        }
        return vo;

    }
}
