package aplicacao.dao;
import aplicacao.dominio.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
    private EntityManager em = emf.createEntityManager();

    public void salva(Pessoa pessoa) {
        iniciaTransacao();
        em.persist(pessoa);
        confirmaTransacao();
    }

    public Pessoa pesquisaPor(Long id) {
        iniciaTransacao();

        Pessoa pessoa = em.find(Pessoa.class,id);
        confirmaTransacao();

        return pessoa;
    }


    public void atualiza(Pessoa novaPessoa){
        iniciaTransacao();

        Pessoa pessoa = em.find(Pessoa.class,novaPessoa.getId());
        pessoa.setPrimeiroNome(novaPessoa.getPrimeiroNome());
        pessoa.setUltimoNome(novaPessoa.getUltimoNome());
        pessoa.setEndereco(novaPessoa.getEndereco());

        em.merge(pessoa);
        confirmaTransacao();
    }

    public void remove(Long id){
        iniciaTransacao();

        Pessoa pessoa = em.find(Pessoa.class,id);
        em.remove(pessoa);

        confirmaTransacao();
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
