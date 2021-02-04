package aplicacao.negocio;
import aplicacao.dao.pessoa.PessoaDAOImpl;
import aplicacao.dominio.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaNegocioImpl implements PessoaNegocio {

    private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();

    public void salva(Pessoa pessoa) {
        try {
            pessoaDAOImpl.salvar(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pessoa recuperarPor(Long id) {
        return pessoaDAOImpl.recuperaPor(id);
    }

    @Override
    public List<Pessoa> recuperar() {

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            pessoas =  pessoaDAOImpl.recuperar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pessoas;
    }

    public void altera(Pessoa novaPessoa){
        try {
            pessoaDAOImpl.alterar(novaPessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Long id){
        try {
            pessoaDAOImpl.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
