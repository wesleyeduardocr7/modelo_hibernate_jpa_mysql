package aplicacao.negocio.empregado;
import aplicacao.dao.empregado.EmpregadoDAOImpl;
import aplicacao.dto.EmpregadoDTO;
import java.util.List;

public class EmpregadoNegocioImpl implements EmpregadoNegocio{

    private EmpregadoDAOImpl empregadoDAO = new EmpregadoDAOImpl();

    @Override
    public List<EmpregadoDTO> recuperarEmpregadosDTOSPor(Long idEmpresa) {
        return empregadoDAO.recuperarEmpregadosDTOSPor(idEmpresa) ;
    }
}
