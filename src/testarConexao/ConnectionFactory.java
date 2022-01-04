package testarConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection executar() throws SQLException {
       return  DriverManager
                .getConnection("jdbc:mysql://localhost/loja_virtual?useTimeZone=true&serverTimeZone=UTC","root","Parkl1835*");
    }

}
