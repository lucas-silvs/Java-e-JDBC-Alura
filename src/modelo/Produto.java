package modelo;


public class Produto {

    private int id;
    private String nome;
    private String descricao;


    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(Integer id, String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return String.format("O produto criado foi: %d %s %s", this.id,this.nome,this.descricao);
    }
}
