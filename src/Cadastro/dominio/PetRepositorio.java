package Cadastro.dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PetRepositorio {
    private static final String DTF = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm").withZone(ZoneId.systemDefault()).format(Instant.now());
    File petsCadastrados = new File("src//petsCadastrados");

    public void salvar(Pet pet, Endereco endereco) {

        String nomePet = pet.getNome().replace(" ", "").toUpperCase();
        String nomeArquivo = DTF + "-" + nomePet + ".txt";
        File petArquivo = new File(petsCadastrados, nomeArquivo);
        try (BufferedWriter bwFormulario = new BufferedWriter(new FileWriter(petArquivo))) {
            int i = 1;
            while (i <= 7) {
                bwFormulario.write( i + " - " + pet.getNome());
                bwFormulario.newLine();
                i++;

                bwFormulario.write( i + " - " + pet.getTipo());
                bwFormulario.newLine();
                i++;

                bwFormulario.write( i + " - " + pet.getSexo());
                bwFormulario.newLine();
                i++;

                bwFormulario.write( i + " - " + endereco.getRua() + ", " + endereco.getNumeroDaCasa() + ", " + endereco.getCidade());
                bwFormulario.newLine();
                i++;

                bwFormulario.write( i + " - " + pet.getIdade() + " anos");
                bwFormulario.newLine();
                i++;

                bwFormulario.write( i + " - " + pet.getPeso() + "Kg");
                bwFormulario.newLine();
                i++;

                bwFormulario.write( i + " - " + pet.getRaca());
                i++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
