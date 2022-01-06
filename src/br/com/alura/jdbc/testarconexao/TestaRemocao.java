package br.com.alura.jdbc.testarconexao;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.executar();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        statement.setString(1,"2");
        statement.execute();

        Integer linhasModificadas = statement.getUpdateCount();
        System.out.println("linhas modificadas: " + linhasModificadas);




        connection.close();
    }
}
