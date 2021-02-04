package aplicacao.dominio;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="empresa")
public class Empresa implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Long id;

	@Column(name = "nome_fantasia", length=100, nullable = false)
	private String nomeFantasia;

	@Column(name = "cnpj", length=30, nullable = false)
	private String cnpj;

	@Column(name = "endereco", length=100)
	private String endereco;

	public Empresa() {
	}

	public Empresa(Long id) {
		this.id = id;
	}

	public Empresa(Long id, String nomeFantasia, String cnpj, String endereco) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
		Empresa empresa = (Empresa) o;
		return id.equals(empresa.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Empresa{" +
				"id=" + id +
				", nomeFantasia='" + nomeFantasia + '\'' +
				", cnpj='" + cnpj + '\'' +
				", endereco='" + endereco + '\'' +
				'}';
	}
}