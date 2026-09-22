package br.com.fiap.controller;

import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;
import br.com.fiap.model.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {

    public String inserirFilme(String titulo, String genero, String produtora) throws SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) throws SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirFilme(int codigo) throws SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

        filme.setCodigo(codigo);

        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(codigo);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarTodosFilmes() throws SQLException {
        String resultado = "";
        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> filmesEncontrados = filmeDAO.listarTodos();

        if(filmesEncontrados.isEmpty()) return "Lista de filmes vazia";

        for(Filme filme : filmesEncontrados){
            String filmeEncontrado = String.format("CÓDIGO: %d, TÍTULO: %s, GENERO: %s, PRODUTORA: %s", filme.getCodigo(), filme.getTitulo(), filme.getGenero(), filme.getProdutora());

            resultado += "\n" + filmeEncontrado;
        }

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}