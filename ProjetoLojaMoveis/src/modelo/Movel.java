/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author vinicius
 */
public class Movel {
    private long idMovel;
    private String nome;
    private double preco;
    private int quantidade;
    private String tipo;
    private double altura;
    private double largura;
    private double comprimento;

    public Movel() {
    }

    public Movel(long idMovel, String nome, double preco, int quantidade, String tipo, double altura, double largura, double comprimento) {
        this.idMovel = idMovel;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public long getIdMovel() {
        return idMovel;
    }

    public void setIdMovel(long idMovel) {
        this.idMovel = idMovel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    @Override
    public String toString() {
        return "Movel{" + "idMovel=" + idMovel + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade + ", tipo=" + tipo + ", altura=" + altura + ", largura=" + largura + ", comprimento=" + comprimento + '}';
    }
    
}
