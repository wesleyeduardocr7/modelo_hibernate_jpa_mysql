package aplicacao.negocio.colaborador;
import aplicacao.dao.colaborador.ColaboradorDAOImpl;
import aplicacao.dominio.Colaborador;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorNegocioImpl implements ColaboradorNegocio {

    private ColaboradorDAOImpl colaboradorDAOImpl = new ColaboradorDAOImpl();

    public void salva(Colaborador colaborador) {
        try {
            if (colaborador.getId() == null) {
                colaboradorDAOImpl.salvar(colaborador);
            } else {
                colaboradorDAOImpl.alterar(colaborador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Colaborador recuperarPor(Long id) {
        return colaboradorDAOImpl.recuperaPor(id);
    }

    @Override
    public List<Colaborador> recuperar() {

        List<Colaborador> colaboradores = new ArrayList<>();

        try {
            colaboradores = colaboradorDAOImpl.recuperar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return colaboradores;
    }

    public void altera(Colaborador novoColaborador) {
        try {
            colaboradorDAOImpl.alterar(novoColaborador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Long id) {
        try {
            colaboradorDAOImpl.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
