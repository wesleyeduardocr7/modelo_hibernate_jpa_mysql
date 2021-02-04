package aplicacao.negocio.empresa;
import aplicacao.dao.empresa.EmpresaDAOImpl;
import aplicacao.dominio.Empresa;
import java.util.ArrayList;
import java.util.List;

public class EmpresaNegocioImpl implements EmpresaNegocio {

    private EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();

    public void salva(Empresa empresa) {
        try {
            if (empresa.getId() == null) {
                empresaDAOImpl.salvar(empresa);
            } else {
                empresaDAOImpl.alterar(empresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Empresa recuperarPor(Long id) {
        return empresaDAOImpl.recuperaPor(id);
    }

    @Override
    public List<Empresa> recuperar() {

        List<Empresa> empresas = new ArrayList<>();

        try {
            empresas = empresaDAOImpl.recuperar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empresas;
    }

    public void altera(Empresa novEmpresa) {
        try {
            empresaDAOImpl.alterar(novEmpresa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Long id) {
        try {
            empresaDAOImpl.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
