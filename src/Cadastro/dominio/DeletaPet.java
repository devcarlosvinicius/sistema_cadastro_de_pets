package Cadastro.dominio;

import java.io.*;
import java.util.Scanner;

public class DeletaPet {
    File petsCadastrados = new File("src/petsCadastrados");
    private static int I = 0;
    private static final String[] PETS = new String[10];
    public static final File[] FILES = new File[10];
    Scanner scanner = new Scanner(System.in);

    public void pesquisa() {
        File[] files = petsCadastrados.listFiles();
        if (files != null) {
            int i = 0;
            for (File file : files) {
                try (BufferedReader lerLinha2 = new BufferedReader(new FileReader(file));
                     BufferedReader resetLinha = new BufferedReader(new FileReader(file))) {
                    String linhas;
                    StringBuilder lerPet = new StringBuilder();
                    lerLinha2.readLine();
                        while ((linhas = resetLinha.readLine()) != null) {
                            lerPet.append(linhas.split("- ")[1]).append(" - ");
                        }
                        FILES[I] = file;
                        i++;
                        PETS[I] = i + ". " + lerPet.delete(lerPet.length() - 3, lerPet.length());
                        System.out.println(PETS[I]);
                        I++;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void deletar(File deletarArquivo, int escolhaDeleta){
        if (deletarArquivo != null){
            System.out.println("Tem certeza que deseja deletar o " + (escolhaDeleta + 1) + "° pet?");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("sim")){
               if(deletarArquivo.delete()) {
                   System.out.println("Deletado com sucesso");
               }
            } else {
                System.out.println("Não foi possivel deletar");
            }
        }
    }
}