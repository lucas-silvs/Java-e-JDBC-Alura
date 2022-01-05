package testarConexao;

import java.sql.SQLException;

public class TestaPooldeConexoes {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        for (int i=0; i<20;i++){
            connectionFactory.executar();
            System.out.println("conexão de número: "+(i+1));
        }
    }
}
