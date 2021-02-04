package aplicacao.programa;
import aplicacao.dominio.Colaborador;
import aplicacao.negocio.ColaboradorNegocioImpl;
import java.math.BigDecimal;
import java.util.List;

public class Programa {

	private static ColaboradorNegocioImpl colaboradorNegocio = new ColaboradorNegocioImpl();

	public static void main(String[] args) {

		//Colaborador colaborador = new Colaborador(null,"Wesley2" ,"SI161300121",new BigDecimal(3500));
		//colaboradorNegocio.salva(colaborador);
		//System.out.println(colaborador.toString());

		//Colaborador colaborador = colaboradorNegocio.recuperarPor(Long.valueOf(2));
		//System.out.println(colaborador.toString());

		//List<Colaborador> colaboradores = colaboradorNegocio.recuperar();
		//System.out.println(colaboradores.toString());

		//Colaborador colaboradorAlterado = new Colaborador(Long.valueOf(1),"Update","Update", new BigDecimal(4500));
		//colaboradorNegocio.altera(colaboradorAlterado);
		//System.out.println(colaboradorAlterado.toString());

		colaboradorNegocio.excluir(Long.valueOf(3));

		System.out.println("Transação Concluída");
	}
}
