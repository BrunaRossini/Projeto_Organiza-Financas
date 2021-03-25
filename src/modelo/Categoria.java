package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Categoria {
	private static int sequence = 0;
	private int idCategoria;
	private String descricaoCategoria;
	private int tipoCategoria;
	private double saldoCategoria;
	private LocalDate dataTransacao;
	private int tipoTransacao;
	private double valorTransacao;

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
		System.out.println("Incluir nova Categoria para controle no Sistema:");
		try {
			System.out.println("Descrição: ");
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
				System.out.println("Inserir as opções solicitadas");
			}
		} catch (InputMismatchException e) {
			System.err.println("Erro em Tipo da Categoria");
			throw new InputMismatchException("Tipo inserido incorretamente.");
		}
	}

	public void listarTodasCategorias(List<Categoria> listaCategoria) {
		System.out.println("\n Categorias Incluidas");
		listaCategoria.forEach(
				e -> System.out.println(e.getDescricaoCategoria() + "\n" + "Valor R$ " + e.getSaldoCategoria()));

	}

	public void listarCategoriasTipoDespesa(List<Categoria> listaCategoria) {
		System.out.println("\n Despesas");
		listaCategoria.stream().filter(e -> e.getTipoCategoria() == 0)
				.forEach(e -> System.out.println(e.getDescricaoCategoria()));
	}

	public void listarCategoriasTipoRenda(List<Categoria> listaCategoria) {
		System.out.println("\n Renda - Ganhos");
		listaCategoria.stream().filter(e -> e.getTipoCategoria() == 1)
				.forEach(e -> System.out.println(e.getDescricaoCategoria()));
	}

	public void calcularSaldoTotalRenda(List<Categoria> listaCategoria) {
		System.out.println("Renda Total");
		Double total = listaCategoria.stream().filter(e -> e.getTipoCategoria() == 1)
				.collect(Collectors.summingDouble(Categoria::getSaldoCategoria));

		System.out.println("Total R$: " + total);

	}

	public void calcularSaldoTotalDespesa(List<Categoria> listaCategoria) {
		System.out.println("Total de despesas");
		Double total = listaCategoria.stream().filter(e -> e.getTipoCategoria() == 0)
				.collect(Collectors.summingDouble(Categoria::getSaldoCategoria));

		System.out.println("Total R$: " + total);

	}

}
