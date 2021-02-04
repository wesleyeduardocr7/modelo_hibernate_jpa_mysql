package aplicacao.negocio;

import aplicacao.dao.PessoaDAO;
import dominio.Pessoa;

public class PessoaNegocio {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void salva(Pessoa pessoa) {
        pessoaDAO.salva(pessoa);
    }
}
