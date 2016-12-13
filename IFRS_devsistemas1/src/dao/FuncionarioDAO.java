/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.FuncionarioVO;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 *
 * @author Juliano Bernardi
 */
public class FuncionarioDAO {

    private static final String SELECT
            = "SELECT * FROM funcionario WHERE idfuncionario = ?";

    private static final String SELECTLOGIN
            = "SELECT cpf, senha, nome FROM funcionario WHERE cpf = ?";

    private static final String INSERT
            = "INSERT INTO funcionario (cpf, nome, rg, endereco, cidade, estado, email, fone, senha)"
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE
            = "UPDATE funcionario SET cpf = ?, nome = ?, rg = ?, endereco = ?, cidade = ?, estado = ?, email = ?, fone = ?, senha = ?"
            + "WHERE idfuncionario = ?";

    private static final String DELETE
            = "DELETE from funcionario WHERE idfuncionario = ?";

    /**
     * Método de busca geral
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public FuncionarioVO buscar(FuncionarioVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
            statement.setInt(1, vo.getFuncionario_id());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setFuncionario_id(resultSet.getInt("idfuncionario"));
            vo.setFuncionario_cpf(resultSet.getString("cpf"));
            vo.setFuncionario_nome(resultSet.getString("nome"));
            vo.setFuncionario_rg(resultSet.getString("rg"));
            vo.setFuncionario_endereco(resultSet.getString("endereco"));
            vo.setFuncionario_cidade(resultSet.getString("cidade"));
            vo.setFuncionario_estado(resultSet.getString("estado"));
            vo.setFuncionario_email(resultSet.getString("email"));
            vo.setFuncionario_fone(resultSet.getString("fone"));
            vo.setFuncionario_senha(resultSet.getString("senha"));

            resultSet.close();
            statement.close();
        }

        return vo;
    }

    /**
     * Método de busca do login para validação do funcionario
     *
     * @param vo - Objeto
     * @return Objeto vo
     * @throws SQLException - Exceção
     * @throws ClassNotFoundException - Classe não encontrada
     */
    public FuncionarioVO buscarLogin(FuncionarioVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();
        System.out.println("aberto");
        try (PreparedStatement statement = connection.prepareStatement(SELECTLOGIN)) {
            statement.setString(1, vo.getFuncionario_cpf());
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            vo.setFuncionario_cpf(resultSet.getString("cpf"));
            vo.setFuncionario_senha(resultSet.getString("senha"));
            vo.setFuncionario_nome(resultSet.getString("nome"));

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
    public FuncionarioVO criar(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, vo.getFuncionario_cpf());
            statement.setString(2, vo.getFuncionario_nome());
            statement.setString(3, vo.getFuncionario_rg());
            statement.setString(4, vo.getFuncionario_endereco());
            statement.setString(5, vo.getFuncionario_cidade());
            statement.setString(6, vo.getFuncionario_estado());
            statement.setString(7, vo.getFuncionario_email());
            statement.setString(8, vo.getFuncionario_fone());
            statement.setString(9, vo.getFuncionario_senha());

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
    public FuncionarioVO alterar(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, vo.getFuncionario_cpf());
            statement.setString(2, vo.getFuncionario_nome());
            statement.setString(3, vo.getFuncionario_rg());
            statement.setString(4, vo.getFuncionario_endereco());
            statement.setString(5, vo.getFuncionario_cidade());
            statement.setString(6, vo.getFuncionario_estado());
            statement.setString(7, vo.getFuncionario_email());
            statement.setString(8, vo.getFuncionario_fone());
            statement.setString(9, vo.getFuncionario_senha());

            statement.setInt(10, vo.getFuncionario_id());

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
    public FuncionarioVO excluir(FuncionarioVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getFuncionario_id());

            statement.executeUpdate();
        }
        return vo;
    }
}
