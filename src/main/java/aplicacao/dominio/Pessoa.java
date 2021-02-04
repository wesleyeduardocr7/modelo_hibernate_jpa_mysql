package aplicacao.dominio;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "primero_nome", nullable = false, length = 80)
	private String primeiroNome;
	
	@Column(name = "ultimo_nome", nullable = false, length = 80)
	private String ultimoNome;
	
	@Column(nullable = false, length = 100)
	private String endereco;

	public Pessoa() {
	}

	public Pessoa(Long id, String primeiroNome, String ultimoNome, String endereco) {
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pessoa pessoa = (Pessoa) o;
		return id.equals(pessoa.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Pessoa{" +
				"id=" + id +
				", primeiroNome='" + primeiroNome + '\'' +
				", ultimoNome='" + ultimoNome + '\'' +
				", endereco='" + endereco + '\'' +
				'}';
	}
}