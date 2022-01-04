package testarConexao;

import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        Connection connection = ConnectionFactory.executar();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUTO");
        Boolean resultados = statement.execute();
        System.out.println(resultados);
        ResultSet rst = statement.getResultSet();

        while(rst.next()){
            Integer id = rst.getInt("ID");
            String nome = rst.getNString("NOME");
            String descricao = rst.getNString("DESCRICAO");
            System.out.println(id);
            System.out.println(nome);
            System.out.println(descricao);

        }
        connection.close();

    }

}
