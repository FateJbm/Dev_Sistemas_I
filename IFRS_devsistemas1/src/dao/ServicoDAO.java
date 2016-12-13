/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.ServicoVO;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 *
 * @author Juliano Bernardi
 */
public class ServicoDAO {

    private static final String SELECT
            = "SELECT * FROM servico WHERE idservico = ?";

    private static final String INSERT
            = "INSERT INTO servico (nome, descricao, tempopadrao, custopadrao)"
            + "VALUES(?, ?, ?, ?)";

    private static final String UPDATE
            = "UPDATE servico SET nome = ?, descricao = ?, tempopadrao = ?, custopadrao = ?"
            + "WHERE idservico = ?";

    private static final String DELETE
            = "DELETE from servico WHERE idservico = ?";

    /**
     * Método de busca geral
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public ServicoVO buscar(ServicoVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            statement.setInt(1, vo.getServico_id());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setServico_id(resultSet.getInt("idservico"));
            vo.setServico_nome(resultSet.getString("nome"));
            vo.setServico_descricao(resultSet.getString("descricao"));
            vo.setServico_tempo(resultSet.getInt("tempopadrao"));
            vo.setServico_custo(resultSet.getFloat("custopadrao"));

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
    public ServicoVO criar(ServicoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, vo.getServico_nome());
            statement.setString(2, vo.getServico_descricao());
            statement.setInt(3, vo.getServico_tempo());
            statement.setFloat(4, vo.getServico_custo());

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
    public ServicoVO alterar(ServicoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, vo.getServico_nome());
            statement.setString(2, vo.getServico_descricao());
            statement.setInt(3, vo.getServico_tempo());
            statement.setFloat(4, vo.getServico_custo());

            statement.setInt(5, vo.getServico_id());

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
    public ServicoVO excluir(ServicoVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getServico_id());

            statement.executeUpdate();
        }
        return vo;

    }
}
