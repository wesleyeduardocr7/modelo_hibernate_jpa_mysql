package aplicacao.dao.generic;
import org.apache.commons.dbutils.QueryRunner;
import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, K extends Serializable> {

    void salvar(T obj) throws Exception;

    List<T> recuperar() throws Exception;

    void alterar(T obj) throws Exception;

    void excluir(Long obj) throws Exception;

    DataSource getDataSource();

    QueryRunner getRunner();
}
