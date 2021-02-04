package aplicacao.programa;
import aplicacao.dominio.Colaborador;
import aplicacao.dominio.Empresa;
import aplicacao.negocio.colaborador.ColaboradorNegocioImpl;
import aplicacao.negocio.empresa.EmpresaNegocioImpl;
import java.math.BigDecimal;

public class Programa {

	private static ColaboradorNegocioImpl colaboradorNegocio = new ColaboradorNegocioImpl();
	private static EmpresaNegocioImpl empresaNegocio = new EmpresaNegocioImpl();

	public static void main(String[] args) {

		Empresa empresa = new Empresa(null,"WesleyTI","565655565","São Luís");
		empresaNegocio.salva(empresa);
		System.out.println("emp1 = " + empresa.toString() + "\n");

		Colaborador colaborador01 = new Colaborador(null,"Luis" ,"SI161300121",new BigDecimal(5500));
		colaborador01.setEmpresa(empresa);
		colaboradorNegocio.salva(colaborador01);
		System.out.println("c1 = " + colaborador01.toString() + "\n");

		//Colaborador colaborador = colaboradorNegocio.recuperarPor(Long.valueOf(2));
		//System.out.println(colaborador.toString());

		//List<Colaborador> colaboradores = colaboradorNegocio.recuperar();
		//System.out.println(colaboradores.toString());

		//Colaborador colaboradorAlterado = new Colaborador(Long.valueOf(1),"Update","Update", new BigDecimal(4500));
		//colaboradorNegocio.altera(colaboradorAlterado);
		//System.out.println(colaboradorAlterado.toString());

		//colaboradorNegocio.excluir(Long.valueOf(3));

		System.out.println("Transação Concluída");
	}
}
