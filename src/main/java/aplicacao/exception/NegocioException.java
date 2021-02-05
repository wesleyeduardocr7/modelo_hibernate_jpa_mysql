package aplicacao.exception;
import java.util.List;

public class NegocioException extends Exception {

    private List<String> erros;

    public NegocioException(String message) {
        super(message);
    }

    public NegocioException(String message, List<String> erros) {
        super(message);
        this.erros = erros;
    }

    public NegocioException(String message, Throwable causa) {
        super(message, causa);
    }

    public NegocioException(Throwable causa) {
        super(causa);
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

}