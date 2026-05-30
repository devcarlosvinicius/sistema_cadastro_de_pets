package Cadastro.dominio;

public enum TipoDeAnimal {
    CACHORRO("Cachorro"),
    GATO("Gato"),
    OUTRO("Outro");

    public final String TIPO;

    TipoDeAnimal(String tipo){
        this.TIPO = tipo;
    }
}
