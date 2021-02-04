package aplicacao.dao.generic;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, K extends Serializable> {

    void alterar(T obj) throws Exception;

    void excluir(Long obj) throws Exception;

    void salvar(T obj) throws Exception;

    List<T> recuperar() throws Exception;
}
