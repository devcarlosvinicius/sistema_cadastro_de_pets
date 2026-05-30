package Cadastro.dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Criterios {
    File petsCadastrados = new File("src/petsCadastrados");
    public static int I = 0;

    public void buscaTipo(String tipo) {
        File[] files = petsCadastrados.listFiles();
        if (files != null) {
            int i = 1;
            for (File file : files) {
                try (BufferedReader lerLinha2 = new BufferedReader(new FileReader(file));
                     BufferedReader resetLinha = new BufferedReader(new FileReader(file))) {
                    String linhas;
                    StringBuilder lerPet = new StringBuilder();
                    lerLinha2.readLine();
                    if (lerLinha2.readLine().toLowerCase().contains(tipo.toLowerCase())) {
                        while ((linhas = resetLinha.readLine()) != null) {
                            lerPet.append(linhas.split("- ")[1]).append(" - ");
                        }
                        System.out.println(i + ". " + lerPet.delete(lerPet.length() - 3, lerPet.length()));
                        i++;
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void imprimeCriterios() {
        System.out.println("---- Criterios de busca ----");
        System.out.println("1. Nome ou sobrenome");
        System.out.println("2. Sexo");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raça");
        System.out.println("6. Endereço");
    }

    public void buscaCriterios(String tipo, int numeroLinha, String valor) {
        File[] files = petsCadastrados.listFiles();
        if (files != null) {
            for (File file : files) {
                try (BufferedReader criteriosDoPet = new BufferedReader(new FileReader(file));
                     BufferedReader linhaPet = new BufferedReader(new FileReader(file));
                     BufferedReader resetLinha = new BufferedReader(new FileReader(file))) {
                    String linhas;
                    String valorLinha = " ";
                    String valorLinha2 = " ";
                    StringBuilder listaPet = new StringBuilder();
                    for (int j = 0; j < 2; j++) {
                        valorLinha = criteriosDoPet.readLine();
                    }
                    if (valorLinha.toLowerCase().contains(tipo.toLowerCase())) {
                        for (int j = 0; j < numeroLinha; j++) {
                            valorLinha2 = linhaPet.readLine();
                        }
                        if (valorLinha2.toLowerCase().contains(valor.toLowerCase())) {
                            while ((linhas = resetLinha.readLine()) != null) {
                                listaPet.append(linhas.split("- ")[1]).append(" - ");
                            }
                            I++;
                            System.out.println(I + ". " + listaPet.delete(listaPet.length() - 3, listaPet.length()));
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}