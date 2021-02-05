package aplicacao.dao.generic;
import org.apache.commons.dbutils.QueryRunner;
import org.hibernate.HibernateException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public class GenericDAOImpl<T, K extends Serializable> implements GenericDAO<T, K>, Serializable {

    protected static final String ERRO_ACESSO_A_BASE_DADOS = "Ocorreu um erro ao "
            + "acessar a base de dados.";

    protected Class<T> claz;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste_tecnico_java");
    private EntityManager em = emf.createEntityManager();

    public GenericDAOImpl() {
        this.claz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntity() {
        return em;
    }

    @Override
    public void salvar(T obj) throws Exception {
        try {
            iniciaTransacao();
            em.persist(obj);
            confirmaTransacao();
        } catch (HibernateException e) {
            throw new Exception(ERRO_ACESSO_A_BASE_DADOS, e);
        }
    }

    @Override
    public List<T> recuperar() throws Exception {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claz));
            return em.createQuery(cq).getResultList();
        } catch (HibernateException e) {
            throw new Exception(ERRO_ACESSO_A_BASE_DADOS, e);
        }
    }

    @Override
    public void alterar(T obj) throws Exception {
        try {
            iniciaTransacao();
            em.merge(obj);
            confirmaTransacao();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new Exception(ERRO_ACESSO_A_BASE_DADOS, e);
        }
    }

    @Override
    public void excluir(Long obj) throws Exception {
        try {
            iniciaTransacao();
            em.remove(em.getReference(claz, obj));
            confirmaTransacao();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new Exception(ERRO_ACESSO_A_BASE_DADOS, e);
        }
    }

    private void iniciaTransacao() {
        em.getTransaction().begin();
    }

    private void confirmaTransacao() {
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public DataSource getDataSource() {

        EntityManagerFactory entityManagerFactory = getEntity().getEntityManagerFactory();

        Map<String, Object> properties = entityManagerFactory.getProperties();

        System.out.println(properties.toString());

        return  (DataSource) properties.get("javax.persistence.jdbc.driver");
    }

    @Override
    public QueryRunner getRunner() {
        QueryRunner runner = new QueryRunner(getDataSource());
        return runner;
    }
}
