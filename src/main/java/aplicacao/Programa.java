package aplicacao;
import aplicacao.negocio.PessoaNegocio;
import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		PessoaNegocio pessoaNegocio = new PessoaNegocio();

		Pessoa pessoa = new Pessoa(null, "Fernanda", "fernanda@gmail.com");

		pessoaNegocio.salva(pessoa);

	}
}
