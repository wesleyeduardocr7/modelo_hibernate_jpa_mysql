package aplicacao.negocio.colaborador;
import aplicacao.dao.colaborador.ColaboradorDAOImpl;
import aplicacao.dominio.Colaborador;
import java.util.List;

public class ColaboradorNegocioImpl implements ColaboradorNegocio {

    private ColaboradorDAOImpl colaboradorDAOImpl = new ColaboradorDAOImpl();

    public void salva(Colaborador colaborador) throws Exception {
        if (colaborador.getId() == null) {
            colaboradorDAOImpl.salvar(colaborador);
        } else {
            colaboradorDAOImpl.alterar(colaborador);
        }
    }

    @Override
    public Colaborador recuperarPor(Long id) {
        return colaboradorDAOImpl.recuperaPor(id);
    }

    @Override
    public List<Colaborador> recuperar() throws Exception {
        List<Colaborador> colaboradores;
        colaboradores = colaboradorDAOImpl.recuperar();
        return colaboradores;
    }

    public void excluir(Long id) throws Exception {
        colaboradorDAOImpl.excluir(id);
    }
}
