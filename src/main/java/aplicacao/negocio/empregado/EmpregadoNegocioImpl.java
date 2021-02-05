package aplicacao.negocio.empregado;
import aplicacao.dao.empregado.EmpregadoDAO;
import aplicacao.dto.EmpregadoDTO;
import java.util.List;

public class EmpregadoNegocioImpl implements EmpregadoNegocio{

    private EmpregadoDAO empregadoDAO = new EmpregadoDAO();

    @Override
    public List<EmpregadoDTO> recuperarEmpregadosDTOSPor(Long idEmpresa) {
        return empregadoDAO.recuperarEmpregadosDTOSPor(idEmpresa) ;
    }

    @Override
    public List<EmpregadoDTO> recuperarEmpregadosDTOS() {
        return empregadoDAO.recuperarEmpregadosDTOS();
    }
}
