package aplicacao.dao.empresa;
import aplicacao.dao.generic.GenericDAOImpl;
import aplicacao.dominio.Empresa;
import javax.persistence.Query;
import java.util.List;

public class EmpresaDAOImpl extends GenericDAOImpl<Empresa, Long> implements EmpresaDAO {

    @Override
    public Empresa recuperaPor(Long id) {

        String hql = "FROM Empresa WHERE id = :id";

        Query query = getEntity().createQuery(hql);

        query.setParameter("id", id);

        List<Empresa> lista = query.getResultList();

        return lista == null || lista.isEmpty() ? null : lista.get(0);
    }
}
