package aplicacao.dao.generic;
import org.hibernate.HibernateException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAOImpl<T, K extends Serializable> implements GenericDAO<T, K>, Serializable {

    protected static final String ERRO_ACESSO_A_BASE_DADOS = "Ocorreu um erro ao "
            + "acessar a base de dados. Tente novamente mais tarde.";

    protected Class<T> claz;

    public GenericDAOImpl() {
        this.claz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    private EntityManager em = emf.createEntityManager();

    public EntityManager getEntity() {
        return em;
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
    public void salvar(T obj) throws Exception {
        try {
            iniciaTransacao();
            em.persist(obj);
            confirmaTransacao();
        } catch (HibernateException e) {
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
}
