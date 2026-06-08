package Cadastro.dominio;

import java.io.*;

public class Criterios {
    File petsCadastrados = new File("src/petsCadastrados");
    public static int I = 0;
    public static String[] PETS = new String[10];
    public static File[] FILES = new File[10];

    public void buscaTipo(String tipo) {
        File[] files = petsCadastrados.listFiles();
        if (files != null) {
            int i = 0;
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
                        FILES[I] = file;
                        i++;
                        PETS[I] = i + ". " + lerPet.delete(lerPet.length() - 3, lerPet.length());
                        System.out.println(PETS[I]);
                        I++;
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
        int i = 0;
        I = 0;
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
                            FILES[I] = file;
                            while ((linhas = resetLinha.readLine()) != null) {
                                listaPet.append(linhas.split("- ")[1]).append(" - ");
                            }
                            i++;
                            PETS[I] = i + ". " + listaPet.delete(listaPet.length() - 3, listaPet.length());
                            System.out.println(PETS[I]);
                            I++;
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}