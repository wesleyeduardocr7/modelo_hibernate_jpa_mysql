package aplicacao.dao;
import dominio.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    private EntityManager em = emf.createEntityManager();

    public void salva(Pessoa pessoa) {

        em.getTransaction().begin();

        em.persist(pessoa);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
