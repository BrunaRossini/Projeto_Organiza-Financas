package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import modelo.Categoria;
import modelo.Movimentacao;

public class Main {

	public static void main(String[] args) {

		Categoria categoria = new Categoria();
		List<Categoria> listaCategoria = new ArrayList<>();

		// instanciada algumas categorias para iniciar listar
		Categoria novacategoria1 = new Categoria("Aluguel", 0);
		Categoria novacategoria2 = new Categoria("Luz", 0);
		Categoria novacategoria3 = new Categoria("Condominio", 0);
		Categoria novacategoria4 = new Categoria("Cartão de Crédito", 0);
		Categoria novacategoria5 = new Categoria("Salário", 1);
		Categoria novacategoria6 = new Categoria("Poupança", 1);
		Categoria novacategoria7 = new Categoria("Investimentos", 1);

		listaCategoria.add(novacategoria1);
		listaCategoria.add(novacategoria2);
		listaCategoria.add(novacategoria3);
		listaCategoria.add(novacategoria4);
		listaCategoria.add(novacategoria5);
		listaCategoria.add(novacategoria6);
		listaCategoria.add(novacategoria7);

		// Instanciando Movimentaçoes

		Movimentacao m1 = new Movimentacao();
		m1.setValorMovimentacao(700);
		m1.setTipoCategoria(novacategoria1);

		Movimentacao m2 = new Movimentacao();
		m2.setValorMovimentacao(500);
		m2.setTipoCategoria(novacategoria1);

		int opcaoSwitch = 0;

		Scanner lerDados = new Scanner(System.in);

		do {

			System.out.println("=======Organiza Finanças======= \n Menu:"
					+ " \n 1 - Cadastrar nova Categoria \n 2 - Listar as Categorias"
					+ " \n 3 - Verificar Despesas \n 4 - Verificar Renda \n 5 - Registrar Valor ");

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

				// movimentacao.registrarValor(categoria);
				break;

			default:
				if (opcaoSwitch != 0)
					System.out.println("Digite opção válida!\n");
				else
					System.out.println("Encerrado \n");
				break;
			}

		} while (opcaoSwitch != 0);

		lerDados.close();
	}
}
