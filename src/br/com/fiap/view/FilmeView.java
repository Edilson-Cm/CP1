package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;

import javax.swing.*;
import java.util.Scanner;

public class FilmeView {
    static void main() {
        Scanner scan = new Scanner(System.in);
        FilmeController filmeController = new FilmeController();

        String auxiliar;

        try {
            System.out.println("---- BEM-VINDO PROFESSOR GILBERTO! ----");

            while(true){
                System.out.println("Com qual opção deseja seguir?");
                System.out.println("[1] Inserir filme \n[2] Alterar filme \n[3] Excluir filme \n[4] Listar filmes");
                auxiliar = scan.nextLine();

                if(auxiliar.equalsIgnoreCase("1")){
                    System.out.println("---- INSERINDO FILME ----");
                    System.out.print("Digite o título do filme: ");
                    String titulo = scan.nextLine();

                    System.out.print("Digite o gênero do filme: ");
                    String genero = scan.nextLine();

                    System.out.print("Digite a produtora do filme: ");
                    String produtora = scan.nextLine();

                    System.out.print(filmeController.inserirFilme(titulo, genero, produtora));
                } else if(auxiliar.equalsIgnoreCase("2")){
                    System.out.println("---- ALTERANDO FILME ----");
                    System.out.print("Digite o código do filme: ");
                    int codigo = Integer.parseInt(scan.nextLine());

                    System.out.print("Digite o título do filme: ");
                    String titulo = scan.nextLine();

                    System.out.print("Digite o gênero do filme: ");
                    String genero = scan.nextLine();

                    System.out.print("Digite a produtora do filme: ");
                    String produtora = scan.nextLine();

                    System.out.print(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                } else if(auxiliar.equalsIgnoreCase("3")){
                    System.out.println("---- EXCLUINDO FILME ----");
                    System.out.print("Digite o código do filme: ");
                    int codigo = Integer.parseInt(scan.nextLine());

                    System.out.print(filmeController.excluirFilme(codigo));
                } else if(auxiliar.equalsIgnoreCase("4")){
                    String resultado = filmeController.listarTodosFilmes();
                    JOptionPane.showMessageDialog(null, resultado, "Listagem de Filmes", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("OPERAÇÃO INVÁLIDA");
                    continue;
                }

                System.out.println("Deseja continuar o processo? \n[1] SIM \n[2] NÃO");
                auxiliar = scan.nextLine();

                if(auxiliar.equalsIgnoreCase("1")) System.out.println("Retornando ao sistema...");
                else if(auxiliar.equalsIgnoreCase("2")){
                    System.out.println("Adeus! Encerrando o sistema...");
                    break;
                } else System.out.println("Opção inválida, retornando ao sistema...");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
