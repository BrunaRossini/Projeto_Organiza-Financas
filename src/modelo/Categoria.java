package modelo;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Categoria {
	private static int sequence = 0;
	private int idCategoria;
	private String descricaoCategoria;
	private int tipoCategoria;
	private double saldoCategoria;

	public Categoria(String descricaoCategoria, int tipoCategoria, double saldoCategoria) {

		this.idCategoria = sequence++;
		this.descricaoCategoria = descricaoCategoria;
		this.tipoCategoria = tipoCategoria;
		this.saldoCategoria = saldoCategoria;

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

	public double getSaldoCategoria() {
		return saldoCategoria;
	}

	public void setSaldoCategoria(double saldoCategoria) {
		this.saldoCategoria = saldoCategoria;
	}

	public void cadastrarCategoria(List<Categoria> listaCategoria) throws RuntimeException {
		Scanner lerDados = new Scanner(System.in);
		Categoria novoCadastro = new Categoria();
		System.out.println("\nIncluir nova categoria para controle no Sistema!");
		try {
			System.out.println("Título da nova categoria: ");
			novoCadastro.descricaoCategoria = lerDados.nextLine();
			System.out.println("Tipo: (0 para Despesas e 1 para Renda)");
			novoCadastro.tipoCategoria = lerDados.nextInt();
			lerDados.nextLine();
			if (novoCadastro.tipoCategoria == 0 || novoCadastro.tipoCategoria == 1) {
				novoCadastro.idCategoria = sequence++;
				System.out.println("Valor R$: ");
				novoCadastro.saldoCategoria = lerDados.nextDouble();

				listaCategoria.add(novoCadastro);

				System.out.println(novoCadastro.descricaoCategoria + " incluído com sucesso! ");
			} else {
				System.out.println("Por favor, escolher entre as opções solicitadas!");
			}
		} catch (InputMismatchException e) {
			System.err.println("Erro em Tipo da Categoria");
			throw new InputMismatchException("Tipo inserido incorretamente.");
		}
	}

	public void listarTodasCategorias(List<Categoria> listaCategoria) {
		System.out.println("\nTodas as categorias Incluídas:");
		listaCategoria.forEach(
				e -> System.out.println(e.getDescricaoCategoria() + " | " + "Valor R$ " + e.getSaldoCategoria() + "\n"));

	}

	public void listarCategoriasTipoDespesa(List<Categoria> listaCategoria) {
		System.out.println("\nDespesas:");
		listaCategoria.stream().filter(e -> e.getTipoCategoria() == 0)
				.forEach(e -> System.out.println(e.getDescricaoCategoria()));
	}

	public void listarCategoriasTipoRenda(List<Categoria> listaCategoria) {
		System.out.println("\nRenda - Ganhos:");
		listaCategoria.stream().filter(e -> e.getTipoCategoria() == 1)
				.forEach(e -> System.out.println(e.getDescricaoCategoria()));
	}

	public void calcularSaldoTotalRenda(List<Categoria> listaCategoria) {		
		Double totalRenda = listaCategoria.stream().filter(e -> e.getTipoCategoria() == 1)
				.collect(Collectors.summingDouble(Categoria::getSaldoCategoria));
		System.out.println("\nRenda Total: R$ " + totalRenda);
		

	}

	public void calcularSaldoTotalDespesa(List<Categoria> listaCategoria) {		
		Double totalDespesa = listaCategoria.stream().filter(e -> e.getTipoCategoria() == 0)
				.collect(Collectors.summingDouble(Categoria::getSaldoCategoria));
		System.out.println("\nTotal de despesas : R$ " + totalDespesa);
		

	}

}
