package testarConexao;

import java.sql.Connection;
import java.sql.SQLException;


public class TestarConexao {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.executar();

        connection.close();
        System.out.println("conexão fechada");
    }
}
