package Cadastro.dominio;

public class Pet {
    private String nome;
    private String tipo;
    private String sexo;
    private double idade;
    private double peso;
    private String raca;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}
