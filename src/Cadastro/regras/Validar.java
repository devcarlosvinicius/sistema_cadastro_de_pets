package Cadastro.regras;

import Cadastro.dominio.*;

public class Validar {
    public static final String NAO_INFORMADO = "Não Informado";

    public String validarNome(String resposta) {
        String[] validar = resposta.split("(\\s)+");
        if (validar.length < 2) {
            throw new RuntimeException("O pet deve ter nome e sobrenome");
        }
        return resposta;
    }

    public String validarTipo(String resposta) {
        if (resposta.isEmpty()) {
            return NAO_INFORMADO;
        }
        if (resposta.trim().equalsIgnoreCase(TipoDeAnimal.CACHORRO.TIPO)) {
            return TipoDeAnimal.CACHORRO.TIPO;

        } else if (resposta.trim().equalsIgnoreCase(TipoDeAnimal.GATO.TIPO)) {
            return TipoDeAnimal.GATO.TIPO;
        } else {
            return TipoDeAnimal.OUTRO.TIPO;
        }
    }

    public String validarSexo(String resposta) {
        if (resposta.isEmpty()) {
            return NAO_INFORMADO;
        }
        if (resposta.trim().equalsIgnoreCase(Sexo.MACHO.SEXO)) {
            return Sexo.MACHO.SEXO;
        } else if (resposta.trim().equalsIgnoreCase(Sexo.FEMEA.SEXO)) {
            return Sexo.FEMEA.SEXO;
        } else {
            return Sexo.INDEFINIDO.SEXO;
        }
    }

    public String validarIdade(String resposta) {
        if (resposta.isEmpty()) {
            return NAO_INFORMADO;
        }
        double idade = Double.parseDouble(resposta);
        if (idade > 20) {
            throw new IdadeIrrealExcepetion("Coloque uma idade real");
        }
        return String.valueOf(idade);
    }

    public double converteAnos(String resp, double idade) {
        if (resp.trim().equalsIgnoreCase("sim")) {
            idade = idade / 12;
        }
        return idade;
    }

    public String validarPeso(String resposta) {
        if (resposta.isEmpty()) {
            return NAO_INFORMADO;
        }
        double peso = Double.parseDouble(resposta);
        if (peso > 60 || peso < 0.5) {
            throw new IllegalArgumentException("Peso Irreal!");
        }
        return String.valueOf(peso);
    }

    public String validarRaca(String resposta) {
        if (resposta.isEmpty()) {
            return NAO_INFORMADO;
        }
        boolean validaRaca;
        validaRaca = resposta.matches("^[a-zA-Z\\-]+$");
        if (!validaRaca) {
            return null;
        }
        return resposta;
    }
}