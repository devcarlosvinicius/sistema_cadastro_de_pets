package Cadastro.test;

import Cadastro.dominio.*;
import Cadastro.regras.Validar;

import java.io.*;
import java.util.Scanner;

public class CadastroTest01 {
    public static void main(String[] args) {
        File formulario = new File("C:/Users/User/IdeaProjects/SistemaCadastroPets/src/formulario.txt");
        File petsCadastrados = new File("src/petsCadastrados");
        PetRepositorio petRepositorio = new PetRepositorio();
        CadastroImprime cadastro = new CadastroImprime();
        Validar valida = new Validar();
        Endereco endereco = new Endereco();
        Pet pet = new Pet();
        Criterios criterios = new Criterios();

        try (Scanner scanner = new Scanner(System.in)) {
            cadastro.imprime();

            System.out.print("Selecione uma das opções acima: ");
            int escolha = Integer.parseInt(scanner.nextLine());
            if (!petsCadastrados.exists()) {
                petsCadastrados.mkdir();
            }
            switch (escolha) {
                case 1:
                    try (BufferedReader brFormulario = new BufferedReader(new FileReader(formulario))) {
                        String linha;
                        int i = 1;
                        while ((linha = brFormulario.readLine()) != null) {
                            if (linha.isEmpty()) {
                                continue;
                            }
                            System.out.println(linha);
                            String resposta = "";
                            if (i != 4) {
                                resposta = scanner.nextLine();
                            }
                            if (i == 1) {
                                String validouNome = valida.validarNome(resposta);
                                pet.setNome(validouNome);
                            }
                            if (i == 2) {
                                String validouTipo = valida.validarTipo(resposta);
                                pet.setTipo(validouTipo);
                            }
                            if (i == 3) {
                                String validouSexo = valida.validarSexo(resposta);
                                pet.setSexo(validouSexo);
                            }
                            if (i == 4) {
                                endereco.validaEndereco();
                            }
                            if (i == 5) {
                                String validouIdade = valida.validarIdade(resposta);
                                double idade = Double.parseDouble(validouIdade);
                                System.out.println("Está em meses?");
                                String resp = scanner.nextLine();
                                double idadeConvertida = valida.converteAnos(resp, idade);
                                pet.setIdade(idadeConvertida);
                            }
                            if (i == 6) {
                                String validouPeso = valida.validarPeso(resposta);
                                double peso = Double.parseDouble(validouPeso);
                                pet.setPeso(peso);
                            }
                            if (i == 7) {
                                String validouRaca = valida.validarRaca(resposta);
                                while (validouRaca == null) {
                                    resposta = scanner.nextLine();
                                    validouRaca = valida.validarRaca(resposta);
                                }
                                pet.setRaca(validouRaca);
                            }
                            i++;
                        }
                    }
                    petRepositorio.salvar(pet, endereco);
                    break;
                case 2:
                    System.out.print("Tipo que deseja procurar: ");
                    String tipo = scanner.nextLine();
                    criterios.buscaTipo(tipo);
                    System.out.println("Deseja adicionar outro critério de busca?");
                    if (scanner.nextLine().equalsIgnoreCase("sim")) {
                        int escolhaCriterios;
                        do {
                            criterios.imprimeCriterios();
                            escolhaCriterios = scanner.nextInt();
                            scanner.nextLine();
                            switch (escolhaCriterios) {
                                case 1:
                                    System.out.print("Nome ou Sobrenome do pet: ");
                                    String nomeOuSobrenome = scanner.nextLine();
                                    criterios.buscaCriterios(tipo, 1, nomeOuSobrenome);
                                    break;
                                case 2:
                                    System.out.print("Sexo do pet: ");
                                    String sexo = scanner.nextLine();
                                    criterios.buscaCriterios(tipo, 3, sexo);
                                    break;
                                case 3:
                                    System.out.println("Idade do pet: ");
                                    String idade = scanner.nextLine();
                                    criterios.buscaCriterios(tipo, 5, idade);
                                    break;
                                case 4:
                                    System.out.println("Peso do pet: ");
                                    String peso = scanner.nextLine();
                                    criterios.buscaCriterios(tipo, 6, peso);
                                    break;
                                case 5:
                                    System.out.println("Raça do pet: ");
                                    String raca = scanner.nextLine();
                                    criterios.buscaCriterios(tipo, 7, raca);
                                    break;
                                case 6:
                                    System.out.println("Endereço do pet: ");
                                    String enderecoPet = scanner.nextLine();
                                    criterios.buscaCriterios(tipo, 4, enderecoPet);
                                    break;
                            }
                        } while (escolhaCriterios < 1 || escolhaCriterios > 6);
                        System.out.print("Qual pet deseja alterar: ");
                        int numeroDoPet= scanner.nextInt();
                    }
                default:
                    throw new IllegalArgumentException("Coloca os numeros certos bobao");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}