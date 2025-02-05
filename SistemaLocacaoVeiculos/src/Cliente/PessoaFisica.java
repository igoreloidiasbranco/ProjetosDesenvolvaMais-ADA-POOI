package Cliente;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisica extends Cliente {

    private String cpf;
    public static List<PessoaFisica> listaClientesPF = new ArrayList<>();

    public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }


    public String cadastrarCliente(PessoaFisica cliente) {
        this.listaClientesPF.add(cliente);
        return "Cliente PF cadastrado";
    }

    public String getCpf() {
        return cpf;
    }
}
