package testarConexao;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "sopa";
        String descricao = "de carangueijo'";
        String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES ('"+nome+"', '"+descricao+"')";

        Connection connection = ConnectionFactory.executar();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS);

        statement.setString(1,nome);
        statement.setString(2,descricao);

        statement.execute();
        ResultSet rst = statement.getGeneratedKeys();

        while (rst.next()){
            Integer id = rst.getInt(1);

            System.out.println("O id criado foi o: "+id);


        }

        connection.close();
    }
}
