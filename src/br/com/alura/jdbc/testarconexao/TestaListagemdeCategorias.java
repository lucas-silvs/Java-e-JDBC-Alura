package br.com.alura.jdbc.testarconexao;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestaListagemdeCategorias {

    public static void main(String[] args) throws SQLException {

        try(Connection connection = new ConnectionFactory().executar()){

            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            ArrayList<Categoria> categorias = (ArrayList<Categoria>) categoriaDAO.listar();

            categorias.forEach(categoria -> {

                System.out.println("produtos da categoria: "+ categoria.getNome());
                categoria.getProdutos().forEach(produto -> System.out.println(categoria.getNome()+ ": "+ produto.getNome()));
//                ArrayList<Produto> produtoscategoria = null;
//                try {
//                    produtoscategoria = new ProdutoDAO(connection).buscarporCategoria(categoria);
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                produtoscategoria.forEach(produto -> System.out.println(categoria.getNome()+ ": "+ produto.getNome()));
            });


        }

    }


}
