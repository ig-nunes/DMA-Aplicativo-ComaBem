package com.comabem;

public class Produto {

    public int id;
    public String nome;
    public String descricao;
    public double preco;


    // Método Construtor
    public Produto(String nome, String descricao, double preco) {
        // this.nome = nome;
        // this.descricao = descricao;
        // this.preco = preco;
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
    }

    // Método Construtor vazio
    public Produto() {
    }


    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    // Para a implementação do teste, foi adicionada algumas características:
    public boolean setNome(String nome) {
        if (nome.length() >= 2) {
            this.nome = nome;
            // Caso o tamanho do nome adicionado seja maior ou igual a dois, o teste terá sucesso
            return true;
        }
        else {
            // Caso contrário, o teste falhará
            return false;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    // Para a implementação do teste, foi adicionada algumas características:
    public boolean setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
            // Caso o valor no teste seja maior ou igual a 0, o teste terá sucesso
            return true;
        } else  {
            // Caso o valor no teste seja menor que zero, o teste falhará
            return false;
        }
    }


    // Métodos
    @Override
    public String toString(){
        return nome;
    }

}
