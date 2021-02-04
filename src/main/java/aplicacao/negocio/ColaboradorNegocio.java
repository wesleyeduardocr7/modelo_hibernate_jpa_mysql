package aplicacao.negocio;
import aplicacao.dominio.Colaborador;
import java.util.List;

public interface ColaboradorNegocio {

    Colaborador recuperarPor(Long id);

    List<Colaborador> recuperar();
}
