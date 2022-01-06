package dao;

import modelo.Categoria;
import modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private Connection connection;


    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listar() throws SQLException {
        Categoria ultima = null;
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT C.ID,C.NOME, P.ID, P.NOME, P.DESCRICAO  FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID")) {
            statement.execute();
            ResultSet rst = statement.getResultSet();

            while (rst.next()) {
                Categoria categoria;
                if(ultima==null || !ultima.getNome().equals(rst.getNString(2))){
                    Integer id = rst.getInt(1);
                    String nome = rst.getNString(2);
                     categoria = new Categoria(id, nome);
                    ultima= categoria;
                    listaCategoria.add(categoria);

                }
                Produto produto = new Produto(rst.getInt(3), rst.getNString(4),rst.getNString(5));

                ultima.inserirProduto(produto);

            }

        }
        return listaCategoria;

    }
}
