package aplicacao.negocio;

import aplicacao.dominio.Pessoa;

import java.util.List;

public interface PessoaNegocio {

    Pessoa recuperarPor(Long id);

    List<Pessoa> recuperar();
}
