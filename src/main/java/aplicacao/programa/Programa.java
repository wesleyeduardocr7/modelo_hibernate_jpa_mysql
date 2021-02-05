package aplicacao.programa;
import aplicacao.dominio.Colaborador;
import aplicacao.dominio.Empresa;
import aplicacao.dominio.TipoColaborador;
import aplicacao.dto.EmpregadoDTO;
import aplicacao.negocio.colaborador.ColaboradorNegocioImpl;
import aplicacao.negocio.empregado.EmpregadoNegocioImpl;
import aplicacao.negocio.empresa.EmpresaNegocioImpl;
import java.math.BigDecimal;
import java.util.List;

public class Programa {

    private static ColaboradorNegocioImpl colaboradorNegocio = new ColaboradorNegocioImpl();
    private static EmpresaNegocioImpl empresaNegocio = new EmpresaNegocioImpl();
    private static EmpregadoNegocioImpl empregadoNegocio = new EmpregadoNegocioImpl();

    public static void main(String[] args) {

        criarEmpresa(null, "Nokia", "8981", "SLZ");

        criarColaborador(null, 4L, "Luis", "SI161300121", new BigDecimal(5500), TipoColaborador.CLT);

        recuperarColaboradorPorId(2L);

        recuperarTodosOsColaboradores();

        alterarEmpresa(2L, "novaEmpresa", "5555", "SLZ");

        excluirEmpresaPor(2L);

        recuperarEmpregadosPor(2L);
    }

    private static void criarEmpresa(Long id, String nomeFantasia, String cnpj, String endereco) {
        try {
            Empresa empresa = new Empresa(id, nomeFantasia, cnpj, endereco);
            empresaNegocio.salva(empresa);
            System.out.println("empresa = " + empresa.toString() + "\n");
        } catch (Exception e) {
            System.out.println("erro = " + e);
        }
    }

    private static void criarColaborador(Long id, Long idEmpresa, String nome, String matricula, BigDecimal salario, TipoColaborador tipoColaborador) {
        try {
            Empresa empresa = empresaNegocio.recuperarPor(idEmpresa);
            Colaborador colaborador0 = new Colaborador(id, nome, matricula, salario, tipoColaborador);
            colaborador0.setEmpresa(empresa);
            colaboradorNegocio.salva(colaborador0);
            System.out.println("colaborador = " + colaborador0.toString() + "\n");
        } catch (Exception e) {
            System.out.println("erro = " + e);
        }
    }

    private static void recuperarEmpregadosPor(Long idEmpresa) {
        try {
            List<EmpregadoDTO> empregadoDTOS = empregadoNegocio.recuperarEmpregadosDTOSPor(idEmpresa);
            if ((empregadoDTOS.isEmpty())) {
                System.out.println("Lista de Empregados Vazia");
            } else {
                empregadoDTOS.forEach(empregadoDTO -> {
                    System.out.println(empregadoDTO.toString());
                });
            }
        } catch (Exception e) {
            System.out.println("erro = " + e);
        }
    }

    private static void recuperarColaboradorPorId(Long id) {
        try {
            Colaborador colaborador = colaboradorNegocio.recuperarPor(id);
            System.out.println(colaborador.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro = " + e);
        }
    }

    private static void recuperarTodosOsColaboradores() {
        try {
            List<Colaborador> colaboradores = colaboradorNegocio.recuperar();
            System.out.println(colaboradores.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro = " + e);
        }

    }

    private static void alterarEmpresa(Long id, String novoNomeFantasia, String novoCnpj, String novoEndereco) {
        try {
            Empresa empresaAlterada = new Empresa(id, novoNomeFantasia, novoCnpj, novoEndereco);
            empresaNegocio.salva(empresaAlterada);
            System.out.println(empresaAlterada.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro = " + e);
        }
    }

    private static void excluirEmpresaPor(Long id) {
        try {
            empresaNegocio.excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro = " + e);
        }
    }
}


