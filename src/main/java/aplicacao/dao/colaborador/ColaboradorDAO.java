package aplicacao.dao.colaborador;
import aplicacao.dao.generic.GenericDAO;
import aplicacao.dominio.Colaborador;

public interface ColaboradorDAO extends GenericDAO<Colaborador, Long> {

    Colaborador recuperaPor(Long id);
}
