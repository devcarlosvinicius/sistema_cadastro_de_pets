package Cadastro.dominio;

import Cadastro.regras.Validar;

import java.util.Scanner;

public class Endereco {
    private String numeroDaCasa;
    private String cidade;
    private String rua;

    public void validaEndereco(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Qual numero da casa: ");
            setNumeroDaCasa(scanner.nextLine());
            if (numeroDaCasa.isEmpty()){
                setNumeroDaCasa(Validar.NAO_INFORMADO);
            }
            System.out.print("Qual a cidade: ");
            setCidade(scanner.nextLine());
            System.out.print("Qual a rua: ");
            setRua(scanner.nextLine());
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }
}
