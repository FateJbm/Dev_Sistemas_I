/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import util.ConectaBD;
import vo.ReciboVO;

/**
 *
 * @author Fate
 */
public class ReciboDAO {

    private static final String SELECT
            = "SELECT * FROM recibo WHERE idrecibo = ?";

    private static final String INSERT
            = "INSERT INTO recibo (cliente_idcliente, data_emissao, hora_emissao, valorfinal, resumo)"
            + "VALUES(?, ?, ?, ?, ?)";

    private static final String UPDATE
            = "UPDATE recibo SET cliente_idcliente = ?, data_emissao = ?, hora_emissao = ?, valorfinal = ?, resumo = ? "
            + "WHERE idcliente = ?";

    private static final String DELETE
            = "DELETE from recibo WHERE idrecibo = ?";

    public ReciboVO buscar(ReciboVO vo) throws SQLException, ClassNotFoundException {
        Connection connection = ConectaBD.getConnection();
        
        try (PreparedStatement statement = connection.prepareStatement(SELECT)) {
        statement.setInt(1, vo.getRecibo_id());
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
     
        vo.setRecibo_id(resultSet.getInt("idrecibo"));
        vo.setRecibo_cliente(resultSet.getInt("cliente_idcliente"));
        vo.setRecibo_dataemissao(resultSet.getString("data_emissao"));
        vo.setRecibo_horaemissao(resultSet.getString("hora_emissao"));
        vo.setRecibo_valorfinal(resultSet.getFloat("valorfinal"));
        vo.setRecibo_resumo(resultSet.getString("resumo"));
       
        resultSet.close();
        statement.close();
        }

        return vo;
    }

    public ReciboVO criar(ReciboVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setInt(1, vo.getRecibo_cliente());
            statement.setString(2, vo.getRecibo_dataemissao());
            statement.setString(3, vo.getRecibo_horaemissao());
            statement.setFloat(4, vo.getRecibo_valorfinal());
            statement.setString(5, vo.getRecibo_resumo());
            
            statement.executeUpdate();
        }
        return vo;
    }

    public ReciboVO alterar(ReciboVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            
            statement.setInt(1, vo.getRecibo_cliente());
            statement.setString(2, vo.getRecibo_dataemissao());
            statement.setString(3, vo.getRecibo_horaemissao());
            statement.setFloat(4, vo.getRecibo_valorfinal());
            statement.setString(5, vo.getRecibo_resumo());
            
            statement.setInt(6, vo.getRecibo_id());
            
            statement.executeUpdate();
        }
        return vo;

    }

    public ReciboVO excluir(ReciboVO vo) throws ClassNotFoundException, SQLException {
        Connection connection = ConectaBD.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, vo.getRecibo_id());
            
            statement.executeUpdate();
        }
        return vo;

    }
}