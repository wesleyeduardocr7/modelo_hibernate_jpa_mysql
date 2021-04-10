package aplicacao.dto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class EmpregadoDTO implements Serializable {

    private Long idEmpresa;
    private String nomeEmpresa;
    private Long idColaborador;
    private String nomeColaborador;
    private BigDecimal salarioColaborador;

    public EmpregadoDTO() {}

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public BigDecimal getSalarioColaborador() {
        return salarioColaborador;
    }

    public void setSalarioColaborador(BigDecimal salarioColaborador) {
        this.salarioColaborador = salarioColaborador;
    }

    @Override
    public String toString() {
        return "EmpregadoDTO{" +
                "idEmpresa=" + idEmpresa +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", idColaborador=" + idColaborador +
                ", nomeColaborador='" + nomeColaborador + '\'' +
                ", salarioColaborador=" + salarioColaborador +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpregadoDTO that = (EmpregadoDTO) o;
        return Objects.equals(idEmpresa, that.idEmpresa) && Objects.equals(nomeEmpresa, that.nomeEmpresa) && Objects.equals(idColaborador, that.idColaborador) && Objects.equals(nomeColaborador, that.nomeColaborador) && Objects.equals(salarioColaborador, that.salarioColaborador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nomeEmpresa, idColaborador, nomeColaborador, salarioColaborador);
    }
}
