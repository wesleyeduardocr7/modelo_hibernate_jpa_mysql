package aplicacao.programa;
import aplicacao.dominio.Pessoa;
import aplicacao.negocio.PessoaNegocioImpl;
import java.util.List;

public class Programa {


	private static PessoaNegocioImpl pessoaNegocioImpl = new PessoaNegocioImpl();

	public static void main(String[] args) {


		Pessoa pessoa = new Pessoa(null,"Teste3" ,"teste3","teste3");
		pessoaNegocioImpl.salva(pessoa);

		//Pessoa pessoa = pessoaNegocioImpl.recuperarPor(Long.valueOf(1));

		//List<Pessoa> pessoas = pessoaNegocioImpl.recuperar();

		//Pessoa novaPessoa = new Pessoa(Long.valueOf(1),"Updata","Update","Update");
		//pessoaNegocioImpl.altera(novaPessoa);

		//pessoaNegocioImpl.excluir(Long.valueOf(3));

		System.out.println("Transação Concluída");
	}
}
