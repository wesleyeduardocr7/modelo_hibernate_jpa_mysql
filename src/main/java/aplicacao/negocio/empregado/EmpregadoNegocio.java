package aplicacao.negocio.empregado;
import aplicacao.dto.EmpregadoDTO;
import java.util.List;

public interface EmpregadoNegocio {

    List<EmpregadoDTO> recuperarEmpregadosDTOSPor(Long idEmpresa);
}
