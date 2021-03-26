package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Categoria;
import modelo.Movimentacao;

public class Main {

	public static void main(String[] args) {

		Categoria categoria = new Categoria();
		Movimentacao movimentacao = new Movimentacao();
		List<Categoria> listaCategoria = new ArrayList<>();

		int opcaoSwitch = 0;

		Scanner lerDados = new Scanner(System.in);

		System.out.println("\n=======Organiza Finanças - Controle sua vida financeira ======= \n "
				+ "Criado por: Bruna Rossini \n Projeto integrador LP3A5 \n=============================================================== \n");

		do {

			System.out.println("============Menu============ \n Digite uma opção abaixo:"
					+ " \n 1 - Cadastrar nova Categoria no sistema \n 2 - Listar as Categorias"
					+ " \n 3 - Listar as Despesas \n 4 - Listar a Renda \n 5 - Consultar Renda Total  \n 6 - Consultar Total de Despesas \n 7 - Quitar Despesa"
					+ "\n Para sair inclua 0");

			opcaoSwitch = lerDados.nextInt();

			switch (opcaoSwitch) {

			case 1:

				categoria.cadastrarCategoria(listaCategoria);
				break;

			case 2:
				categoria.listarTodasCategorias(listaCategoria);
				break;

			case 3:
				categoria.listarCategoriasTipoDespesa(listaCategoria);
				break;

			case 4:
				categoria.listarCategoriasTipoRenda(listaCategoria);
				break;

			case 5:
				categoria.calcularSaldoTotalRenda(listaCategoria);

				break;

			case 6:
				categoria.calcularSaldoTotalDespesa(listaCategoria);

				break;

			case 7:
				movimentacao.quitarUmaDespesa(listaCategoria);
				break;
				
				//Removido por inconsistencia nas validações
			/*case 8:
			//	movimentacao.removerUmaCategoriadeRenda(listaCategoria);
				break;*/

			default:
				if (opcaoSwitch != 0)
					System.out.println("Digite uma opção válida!\n");
				else
					System.out.println(" Encerrado o Organiza Finanças, obrigada por utilizar!!\n");
				break;
			}

		} while (opcaoSwitch != 0);

		lerDados.close();
	}
}
