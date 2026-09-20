package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection abrirConexão(){
        Connection con = null;
        try {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
                final String USER = "rm (JDBC é chato pra krl pqp)";
                final String PASS = "senha";
                con = DriverManager.getConnection(url, USER, PASS);
                System.out.println("Conexão aberta.");
            } catch (ClassNotFoundException e) {
                System.out.println("Erro: A classe de conexão não foi encontrada!\n" +
                        e.getMessage());
            } catch (SQLException e) {
                System.out.println("Erro de SQL!\n" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            return con;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection fecharConexão(Connection con){
        try {
            con.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            System.out.println("Erro de SQL!\n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return con;
    }


}
