package br.com.alura.jdbc.testarconexao;

import factory.ConnectionFactory;

import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "sopa";
        String descricao = "de carangueijo'";
        String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES ('" + nome + "', '" + descricao + "')";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.executar();) {
            connection.setAutoCommit(false);
            //try with resources: isso garante que ao final do try, a conexão com o banco será fechada
            try (
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ) {
                adicionarVariavel("sopa", "de camaron'", statement);
                //pedido que daria erro
                //adicionarVariavel("error", "error", statement);
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Rollback foi executado");
                connection.rollback();
            }

        }


    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
        if (nome.equals("error") || descricao.equals("error")) {
            throw new RuntimeException("Não possivel adicionar o produto");
        }

        statement.setString(1, nome);
        statement.setString(2, descricao);

        statement.execute();
        try (ResultSet rst = statement.getGeneratedKeys();) {

            while (rst.next()) {
                Integer id = rst.getInt(1);

                System.out.println("O id criado foi o: " + id);
            }
        }

    }
}
