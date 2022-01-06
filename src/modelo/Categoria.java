package modelo;

import java.util.ArrayList;

public class Categoria {
    private int id;
    private String nome;
    private ArrayList<Produto> produtos;

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Categoria: " +"id: " + id + ", nome: " + nome;
    }

    public void inserirProduto(Produto produto){
        this.produtos.add(produto);
    }
}

