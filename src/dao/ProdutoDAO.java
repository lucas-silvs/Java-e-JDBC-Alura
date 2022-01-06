package dao;

import modelo.Categoria;
import modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// codigo isolado responsavel com papel de acessa o seu repositório de dados - função do DAO (Data Acess Object)
public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }


    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)";



            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1,produto.getNome());
                preparedStatement.setString(2,produto.getDescricao());
                preparedStatement.execute();
                System.out.println("inserido no banco de dados");

                try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                    while (resultSet.next()){
                        produto.setId(resultSet.getInt(1));

                    }
                }
            }

        System.out.println(produto.toString());
    }

    public List<Produto> listar() throws SQLException {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUTO")) {
            Boolean resultados = statement.execute();
            System.out.println(resultados);
            ResultSet rst = statement.getResultSet();

            while (rst.next()) {
                Integer id = rst.getInt("ID");
                String nome = rst.getNString("NOME");
                String descricao = rst.getNString("DESCRICAO");
                Produto produto = new Produto(id, nome, descricao);
                produto.setId(id);
                listaProduto.add(produto);

            }

        }
        return  listaProduto;
    }

    public ArrayList<Produto> buscarporCategoria(Categoria categoria) throws SQLException {
        ArrayList<Produto> listaProduto = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?")) {
            statement.setInt(1,categoria.getId());
            statement.execute();
            ResultSet rst = statement.getResultSet();

            while (rst.next()) {
                Integer id = rst.getInt("ID");
                String nome = rst.getNString("NOME");
                String descricao = rst.getNString("DESCRICAO");
                Produto produto = new Produto(id, nome, descricao);
                produto.setId(id);
                listaProduto.add(produto);

            }

        }
        return listaProduto;
    }

}
