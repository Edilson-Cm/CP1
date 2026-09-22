package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    private Connection con;
    public FilmeDAO(Connection con) {
        this.con = con;
    }

    public String inserir(Filme filme) throws SQLException {
        String sql = "INSERT INTO ddd_filme (titulo, genero, produtora) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.executeUpdate();
            return "Filme inserido com sucesso!\n";
        }
    }

    public String alterar(Filme filme) throws SQLException {
        String sql = "UPDATE ddd_filme SET titulo = ?, genero = ?, produtora = ? WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());
            int linhas = ps.executeUpdate();
            return linhas > 0 ? "Filme alterado com sucesso!\n" : "Filme não encontrado.\n";
        }
    }

    public String excluir(int codigo) throws SQLException {
        String sql = "DELETE FROM ddd_filme WHERE codigo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            int linhas = ps.executeUpdate();
            return linhas > 0 ? "Filme excluído com sucesso!\n" : "Filme não encontrado.\n";
        }
    }

    public ArrayList<Filme> listarTodos() throws SQLException {
        ArrayList<Filme> lista = new ArrayList<>();
        String sql = "SELECT * FROM ddd_filme";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Filme f = new Filme();
                f.setCodigo(rs.getInt("codigo"));
                f.setTitulo(rs.getString("titulo"));
                f.setGenero(rs.getString("genero"));
                f.setProdutora(rs.getString("produtora"));
                lista.add(f);
            }
        }
        return lista;
    }
}
