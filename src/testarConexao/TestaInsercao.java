package testarConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.executar();

        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse Wireless')"
        ,Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = statement.getGeneratedKeys();

        while (rst.next()){
            Integer id = rst.getInt(1);

            System.out.println("O id criado foi o: "+id);


        }

        connection.close();
    }
}
