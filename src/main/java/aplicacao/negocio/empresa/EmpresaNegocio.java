package aplicacao.negocio.empresa;
import aplicacao.dominio.Empresa;
import java.util.List;

public interface EmpresaNegocio {

    Empresa recuperarPor(Long id);

    List<Empresa> recuperar();
}
