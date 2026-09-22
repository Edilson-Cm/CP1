package br.com.fiap.model.dto;

public class Filme {
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;

    public Filme() {
    }

    public Filme(int codigo, String titulo, String genero, String produtora) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.produtora = produtora;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
