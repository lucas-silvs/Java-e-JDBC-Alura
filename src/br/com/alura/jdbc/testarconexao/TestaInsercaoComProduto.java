package br.com.alura.jdbc.testarconexao;

import dao.ProdutoDAO;
import factory.ConnectionFactory;
import modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestaInsercaoComProduto {

    public static void main(String[] args) throws SQLException {
        Produto produto = new Produto("guarda", "roupa");
        try(Connection connection = new ConnectionFactory().executar()) {
            ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
            persistenciaProduto.salvar(produto);
            ArrayList<Produto> lista = (ArrayList<Produto>) persistenciaProduto.listar();

            lista.forEach(System.out::println);
        }



    }





}
