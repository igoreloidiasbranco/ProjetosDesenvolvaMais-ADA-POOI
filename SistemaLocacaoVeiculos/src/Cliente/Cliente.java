package Cliente;

public abstract class Cliente {

    private String nome;
    private String endereco;
    private String telefone;


    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}
