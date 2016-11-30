/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.AgendaVO;

/**
 *
 * @author Fate
 */
public class AgendaDAO {

    private static final String SELECT
            = "SELECT * FROM agenda WHERE idagenda = ?";

    private static final String INSERT
            = "INSERT INTO agenda (cliente_idcliente, funcionario_idfuncionario, data, hora_inicio, hora_fim, status)"
            + "VALUES(?, ?, ?, ?, ?, ?)";

    private static final String UPDATE
            = "UPDATE agenda SET cliente_idcliente = ?, funcionario_idfuncionario = ?, data = ?, hora_inicio = ?, hora_fim = ?, status = ?"
            + "WHERE idagenda = ?";

    private static final String DELETE
            = "DELETE from agenda WHERE idagenda = ?";

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

    public AgendaVO excluir(AgendaVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getAgenda_id());
            
            statement.executeUpdate();
        }
        return vo;

    }
}