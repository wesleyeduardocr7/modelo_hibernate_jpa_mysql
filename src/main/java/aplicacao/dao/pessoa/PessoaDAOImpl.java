package aplicacao.dao.pessoa;
import aplicacao.dao.generic.GenericDAOImpl;
import aplicacao.dominio.Pessoa;

import javax.persistence.Query;
import java.util.List;

public class PessoaDAOImpl extends GenericDAOImpl<Pessoa, Long> implements PessoaDAO {

    @Override
    public Pessoa recuperaPor(Long id) {

        String hql = "FROM Pessoa WHERE id = :id";

        Query query = getEntity().createQuery(hql);
        query.setParameter("id", id);

        List<Pessoa> lista = query.getResultList();
        return lista == null || lista.isEmpty() ? null : lista.get(0);
    }
}
