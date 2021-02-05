package aplicacao.dao.empregado;
import aplicacao.dao.generic.GenericDAOImpl;
import aplicacao.dto.EmpregadoDTO;
import aplicacao.utils.QueryUtils;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDAO extends GenericDAOImpl<EmpregadoDTO, Long> {

    public List<EmpregadoDTO> recuperarEmpregadosDTOSPor(Long idEmpresa) {

        List<EmpregadoDTO> empregadoDTOS =  new ArrayList<>();

        String nomeDoArquivoComExtensao = "query_recupera_empregados_de_uma_empresa.txt";

        String sql = QueryUtils.getQuery(nomeDoArquivoComExtensao);

        Query query = getEntity().createNativeQuery(sql);

        query.setParameter("id_empresa", idEmpresa);

        List<Object[]> resultado = query.getResultList();

        for (Object[] r : resultado) {

            EmpregadoDTO empregadoDTO = new EmpregadoDTO();

            empregadoDTO.setIdEmpresa(((BigInteger) r[0]).longValue());
            empregadoDTO.setNomeEmpresa((String) r[1]);
            empregadoDTO.setIdColaborador(((BigInteger) r[2]).longValue());
            empregadoDTO.setNomeColaborador((String) r[3]);
            empregadoDTO.setSalarioColaborador((BigDecimal) r[4]);

            empregadoDTOS.add(empregadoDTO);
        }

        return empregadoDTOS;

    }


    public List<EmpregadoDTO> recuperarEmpregadosDTOS(){

        List<EmpregadoDTO> empregadoDTOS = new ArrayList<>();

        String sql = " select e.id_empresa as idEmpresa, e.nome_fantasia as nomeEmpresa, c.id as idColaborador, c.nome as nomeColaborador, c.salario as salarioColaborador from empresa e inner join colaborador c on c.id_empresa = e.id_empresa ";

        ResultSetHandler<List<EmpregadoDTO>> relatorioContratoDTOBeanListHandler = new BeanListHandler<>(EmpregadoDTO.class);

        try {
            empregadoDTOS = getRunner().query(sql, relatorioContratoDTOBeanListHandler);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return empregadoDTOS;
    }
}
