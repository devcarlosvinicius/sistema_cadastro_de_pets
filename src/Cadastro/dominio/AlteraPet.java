package Cadastro.dominio;

import java.io.*;

public class AlteraPet {
    public void alteraPet(File arquivo, int escolha, String alteracao) {
        String linhaFormatada;
        if (arquivo != null) {
            File arquivoTemporario = new File(arquivo.getParent(), "temp_" + arquivo.getName());
            try (BufferedReader bfReadLinha = new BufferedReader(new FileReader(arquivo));
                 BufferedWriter bwWriteLinha = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                int contador = 1;
                if (escolha > 1 && escolha < 6) {
                    escolha += 2;
                }
                while ((linha = bfReadLinha.readLine()) != null) {
                    if (contador == escolha) {
                        if (escolha == 5) {
                            linhaFormatada = contador + " - " + alteracao + " anos";
                            bwWriteLinha.write(linhaFormatada);
                            contador++;
                            bwWriteLinha.newLine();
                            continue;
                        }
                        if (escolha == 6) {
                            linhaFormatada = contador + " - " + alteracao + "Kg";
                            bwWriteLinha.write(linhaFormatada);
                            contador++;
                            bwWriteLinha.newLine();
                            continue;
                        }
                        linhaFormatada = contador + " - " + alteracao;
                        bwWriteLinha.write(linhaFormatada);
                    } else {
                        bwWriteLinha.write(linha);
                    }
                    bwWriteLinha.newLine();
                    contador++;
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar: " + e.getMessage());
            }
            if (arquivo.delete()) {
                if (arquivoTemporario.renameTo(arquivo)) {
                    System.out.println("Pet Alterado com Sucesso!");
                } else {
                    System.out.println("Erro ao renomear o arquivo temporario");
                }
            } else {
                System.out.println("Erro ao deletar arquivo");
            }
        }
    }
}
