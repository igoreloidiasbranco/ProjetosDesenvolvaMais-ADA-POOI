package Cliente;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisica extends Cliente implements CadastroCliente {

    private String cpf;
    public static List<Cliente> listaClientesPF = new ArrayList<>();

    public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String cadastrarCliente(Cliente cliente) {
        this.listaClientesPF.add(cliente);
        return "Cliente PF cadastrado";
    }

    @Override
    public String toString() {
        return super.toString() + " PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                "} " ;
    }
}
