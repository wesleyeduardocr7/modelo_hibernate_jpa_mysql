package aplicacao.dao.colaborador;
import aplicacao.dao.generic.GenericDAOImpl;
import aplicacao.dominio.Colaborador;

import javax.persistence.Query;
import java.util.List;

public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador, Long> implements ColaboradorDAO {

    @Override
    public Colaborador recuperaPor(Long id) {

        String hql = "FROM Colaborador WHERE id = :id";

        Query query = getEntity().createQuery(hql);
        query.setParameter("id", id);

        List<Colaborador> lista = query.getResultList();
        return lista == null || lista.isEmpty() ? null : lista.get(0);
    }
}
