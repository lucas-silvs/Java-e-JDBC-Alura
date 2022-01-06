package br.com.alura.jdbc.testarconexao;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;


public class TestarConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.executar();

        connection.close();
        System.out.println("conexão fechada");
    }
}
