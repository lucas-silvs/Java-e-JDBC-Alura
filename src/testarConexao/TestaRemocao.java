package testarConexao;

import java.sql.*;

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
