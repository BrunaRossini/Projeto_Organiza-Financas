package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Categoria {
	private static int sequence = 0;
	private int idCategoria;
	private String descricaoCategoria;
	private int tipoCategoria;
	private ArrayList<Movimentacao> movimentacoes;
	List<Categoria> listaCategoria;

	public Categoria(String descricaoCategoria, int tipoCategoria) {

		this.idCategoria = sequence++;
		this.descricaoCategoria = descricaoCategoria;
		this.tipoCategoria = tipoCategoria;
	}

	public Categoria() {
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public int getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(int tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public void cadastrarCategoria() throws RuntimeException {
		Scanner lerDados = new Scanner(System.in);
		Categoria novoCadastro = new Categoria();
		System.out.println("Incluir nova Categoria para controle no Sistema:");
		try {
			System.out.println("Descrição: ");
			novoCadastro.descricaoCategoria = lerDados.nextLine();			
			System.out.println("Tipo: (0 para Despesas e 1 para Renda)");
			novoCadastro.tipoCategoria = lerDados.nextInt();
			lerDados.nextLine();
			if (novoCadastro.tipoCategoria == 0 || novoCadastro.tipoCategoria == 1) {
				novoCadastro.idCategoria = sequence++;			
				
				listaCategoria = Arrays.asList(novoCadastro);
				System.out.println(novoCadastro.descricaoCategoria + " incluído com sucesso! ");
			} else {
				System.out.println("Inserir as opções solicitadas");
			}
		} catch (InputMismatchException e) {
			System.err.println("Erro em Tipo da Categoria");
			throw new InputMismatchException("Tipo inserido incorretamente.");
		}
	}

	public void listarTodasCategorias() {
		System.out.println("\n Categorias Incluidas");
		listaCategoria.stream().forEach(e -> System.out.println(e.getDescricaoCategoria()));
	}

}
