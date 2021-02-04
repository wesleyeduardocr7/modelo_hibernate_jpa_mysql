package aplicacao.programa;
import aplicacao.dominio.Pessoa;
import aplicacao.negocio.PessoaNegocio;

public class Programa {


	private static PessoaNegocio pessoaNegocio = new PessoaNegocio();

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa(null,"Gabriel" ,"Andre","São Luís");
		pessoaNegocio.salva(pessoa);

		//Pessoa pessoa = pessoaNegocio.pesquisaPor(Long.valueOf(2));

		//Pessoa novaPessoa = new Pessoa(Long.valueOf(2),"teste","teste","tesate");
		//pessoaNegocio.atualiza(novaPessoa);

		//pessoaNegocio.remove(Long.valueOf(2));

		System.out.println("Transação Concluída");

	}
}
