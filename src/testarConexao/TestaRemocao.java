package testarConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.executar();

        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM PRODUTO WHERE ID > 2");

        Integer linhasModificadas = statement.getUpdateCount();
        ;
        System.out.println("linhas modificadas: " + linhasModificadas);




        connection.close();
    }
}
