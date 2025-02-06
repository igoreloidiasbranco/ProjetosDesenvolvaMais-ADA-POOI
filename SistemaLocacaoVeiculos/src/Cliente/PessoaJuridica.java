package Cliente;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridica extends Cliente implements CadastroCliente{

    private String cnpj;
    public static List<Cliente> listaClientesPJ = new ArrayList<>();

    public PessoaJuridica(String nome, String endereco, String telefone, String cnpj) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String cadastrarCliente(Cliente cliente) {
        listaClientesPJ.add(cliente);
        return "Cliente PJ cadastrado";
    }

    @Override
    public String toString() {
        return super.toString() + " PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                "} " ;
    }
}
