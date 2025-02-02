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
}
