package Cadastro.dominio;

public enum Sexo {
    MACHO("Macho"),
    FEMEA("Femea"),
    INDEFINIDO("Indefinido");

    public final String SEXO;

    Sexo(String sexo) {
        this.SEXO = sexo;
    }
}
