package aplicacao.dao.pessoa;
import aplicacao.dao.generic.GenericDAO;
import aplicacao.dominio.Pessoa;

public interface PessoaDAO extends GenericDAO<Pessoa, Long> {

    Pessoa recuperaPor(Long id);
}
