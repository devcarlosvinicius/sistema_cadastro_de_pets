package Cadastro.dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuscaPet {
    File petsCadastrados = new File("src/petsCadastrados");
    public static int I = 0;
    public static String[] PETS = new String[10];
    public static File[] FILES = new File[10];


    public void buscaPet(String pet) {
        File[] files = petsCadastrados.listFiles();
        if (files != null) {
            int i = 0;
            for (File file : files) {
                try (BufferedReader lerLinha2 = new BufferedReader(new FileReader(file));
                     BufferedReader resetLinha = new BufferedReader(new FileReader(file))) {
                    String linhas;
                    StringBuilder lerPet = new StringBuilder();
                    do {
                        if (lerLinha2.readLine().toLowerCase().contains(pet.toLowerCase())) {
                            while ((linhas = resetLinha.readLine()) != null) {
                                lerPet.append(linhas.split("- ")[1]).append(" - ");
                            }
                            FILES[I] = file;
                            i++;
                            PETS[I] = i + ". " + lerPet.delete(lerPet.length() - 3, lerPet.length());
                            System.out.println(PETS[I]);
                            I++;
                        }
                    } while (lerLinha2.readLine() != null);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
