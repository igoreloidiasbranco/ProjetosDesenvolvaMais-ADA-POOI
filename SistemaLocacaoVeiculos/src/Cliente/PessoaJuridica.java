package Cliente;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridica extends Cliente {

    private String cnpj;
    public static List<PessoaJuridica> listaClientesPJ = new ArrayList<>();

    public PessoaJuridica(String nome, String endereco, String telefone, String cnpj) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
    }

    public String cadastrarCliente(PessoaJuridica cliente) {
        listaClientesPJ.add(cliente);
        return "Cliente PJ cadastrado";
    }

    public String getCnpj() {
        return cnpj;
    }
}
