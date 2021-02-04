package aplicacao.dao.empresa;
import aplicacao.dao.generic.GenericDAO;
import aplicacao.dominio.Empresa;

public interface EmpresaDAO extends GenericDAO<Empresa, Long> {

    Empresa recuperaPor(Long id);
}
