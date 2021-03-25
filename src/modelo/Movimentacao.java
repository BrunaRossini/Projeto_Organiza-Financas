package modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Movimentacao {

	private int idMovimentacao;
	private double valorMovimentacao;
	private LocalDate dataCadastroMovimentcao;
	private Categoria tipoCategoria;

	public int getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(int idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public double getValorMovimentacao() {
		return valorMovimentacao;
	}

	public void setValorMovimentacao(double valorMovimentacao) {
		this.valorMovimentacao = valorMovimentacao;
	}

	public LocalDate getDataCadastroMovimentcao() {
		return dataCadastroMovimentcao;
	}

	public void setDataCadastroMovimentcao(LocalDate localDate) {
		this.dataCadastroMovimentcao = localDate;
	}

	public Categoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(Categoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public void quitarUmaDespesa(List<Categoria> listaCategoria) {
		Movimentacao quitar = new Movimentacao();
		Scanner lerDados = new Scanner(System.in);
		int buscarId;
		try {
			System.out.println("Selecionar por id qual despesa quitar!");
			listaCategoria.stream().filter(e -> e.getTipoCategoria() == 0).forEach(e -> System.out.println(
					"ID: " + e.getIdCategoria() + " | " + e.getDescricaoCategoria() + " | " + e.getSaldoCategoria()));
			System.out.println("Inserir opção do id: ");
			buscarId = lerDados.nextInt();
			long totalIdDespesa = listaCategoria.stream().filter(e -> e.getIdCategoria() == 0).count();
			if (buscarId <= totalIdDespesa) {
				listaCategoria.removeIf(e -> e.getIdCategoria() == buscarId);
				System.out.println("Removida a despesa solicitada!");
				quitar.setDataCadastroMovimentcao(LocalDate.now());
				System.out.println("Data do cadastro da quitacao: " + quitar.getDataCadastroMovimentcao());
			} else {
				System.out.println("Por favor, escolher entre as opções solicitadas!");
			}
		} catch (Exception e) {
			System.err.println("Erro em Tipo da Categoria" + e.getMessage());
		}

	}

	public void removerUmaCategoriadeRenda(List<Categoria> listaCategoria) {
		Movimentacao remover = new Movimentacao();
		Scanner lerDados = new Scanner(System.in);
		int buscarId;
		try {
			listaCategoria.stream().filter(e -> e.getTipoCategoria() == 1).forEach(e -> System.out.println(
					"ID: " + e.getIdCategoria() + " | " + e.getDescricaoCategoria() + " | " + e.getSaldoCategoria()));
			System.out.println("Selecionar por id qual renda remover: ");
			buscarId = lerDados.nextInt();
			long totalIdRenda = listaCategoria.stream().filter(e -> e.getIdCategoria() == 0).count();
			if (buscarId <= totalIdRenda) {
				listaCategoria.removeIf(e -> e.getIdCategoria() == buscarId);
				System.out.println("Removida a despesa solicitada!");
				remover.setDataCadastroMovimentcao(LocalDate.now());
				System.out.println("Data do cadastro da remoção: " + remover.getDataCadastroMovimentcao());
			} else {
				System.out.println("Por favor, escolher entre as opções solicitadas!");
			}
		} catch (Exception e) {
			System.err.println("Erro em Tipo da Categoria" + e.getMessage());
		}

	}

}
