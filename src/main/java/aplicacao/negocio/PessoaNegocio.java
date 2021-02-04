package aplicacao.negocio;
import aplicacao.dao.PessoaDAO;
import aplicacao.dominio.Pessoa;

public class PessoaNegocio {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void salva(Pessoa pessoa) {
        pessoaDAO.salva(pessoa);
    }

    public Pessoa pesquisaPor(Long id) {
       return pessoaDAO.pesquisaPor(id);
    }

    public void atualiza(Pessoa novaPessoa){
        pessoaDAO.atualiza(novaPessoa);
    }

    public void remove(Long id){
        pessoaDAO.remove(id);
    }
}
