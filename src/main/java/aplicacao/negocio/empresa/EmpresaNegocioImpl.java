package aplicacao.negocio.empresa;
import aplicacao.dao.empresa.EmpresaDAOImpl;
import aplicacao.dominio.Empresa;
import java.util.List;

public class EmpresaNegocioImpl implements EmpresaNegocio {

    private EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();

    public void salva(Empresa empresa) throws Exception {
        if (empresa.getId() == null) {
            empresaDAOImpl.salvar(empresa);
        } else {
            empresaDAOImpl.alterar(empresa);
        }
    }

    @Override
    public Empresa recuperarPor(Long id) {
        return empresaDAOImpl.recuperaPor(id);
    }

    @Override
    public List<Empresa> recuperar() throws Exception {
        List<Empresa> empresas = empresaDAOImpl.recuperar();
        return empresas;
    }

    public void excluir(Long id) throws Exception {
        empresaDAOImpl.excluir(id);
    }
}
