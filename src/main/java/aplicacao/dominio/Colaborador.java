package aplicacao.dominio;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="colaborador")
public class Colaborador implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length=100, nullable = false)
	private String nome;

	@Column(name = "matricula", length=30, nullable = false)
	private String matricula;

	@Column(name = "salario", scale = 6)
	private BigDecimal salario;

	@Column(name = "tipo_colaborador")
	private TipoColaborador tipoColaborador;

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	public Colaborador() {
	}

	public Colaborador(Long id, String nome, String matricula, BigDecimal salario, TipoColaborador tipoColaborador) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.salario = salario;
		this.tipoColaborador = tipoColaborador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public TipoColaborador getTipoColaborador() {
		return tipoColaborador;
	}

	public void setTipoColaborador(TipoColaborador tipoColaborador) {
		this.tipoColaborador = tipoColaborador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Colaborador pessoa = (Colaborador) o;
		return id.equals(pessoa.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Colaborador{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", matricula='" + matricula + '\'' +
				", salario=" + salario +
				'}';
	}
}