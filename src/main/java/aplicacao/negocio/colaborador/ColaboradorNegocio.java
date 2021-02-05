package aplicacao.negocio.colaborador;
import aplicacao.dominio.Colaborador;
import java.util.List;

public interface ColaboradorNegocio {

    Colaborador recuperarPor(Long id) throws Exception;

    List<Colaborador> recuperar() throws Exception;
}
