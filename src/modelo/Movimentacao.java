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
			quitar.setDataCadastroMovimentcao(LocalDate.now());
			System.out.println("Data do cadastro da quitacao: " + quitar.getDataCadastroMovimentcao());
			listaCategoria.stream().filter(e -> e.getTipoCategoria() == 0).forEach(e -> System.out.println(
					"ID: " + e.getIdCategoria() + " | " + e.getDescricaoCategoria() + " | " + e.getSaldoCategoria()));
			System.out.println("Selecionar por id qual despesa quitar: ");
			buscarId = lerDados.nextInt();
			listaCategoria.removeIf(e -> e.getIdCategoria() == buscarId);
			System.out.println("Removida a despesa solicitada!");
		} catch (Exception e) {
			System.err.println("Erro em Tipo da Categoria" + e.getMessage());
		}

	}
	
	public void removerUmaCategoriadeRenda(List<Categoria> listaCategoria) {
		Movimentacao remover = new Movimentacao();
		Scanner lerDados = new Scanner(System.in);
		int buscarId;
		try {
			remover.setDataCadastroMovimentcao(LocalDate.now());
			System.out.println("Data do cadastro da remoção: " + remover.getDataCadastroMovimentcao());
			listaCategoria.stream().filter(e -> e.getTipoCategoria() == 1).forEach(e -> System.out.println(
					"ID: " + e.getIdCategoria() + " | " + e.getDescricaoCategoria() + " | " + e.getSaldoCategoria()));
			System.out.println("Selecionar por id qual renda remover: ");
			buscarId = lerDados.nextInt();
			listaCategoria.removeIf(e -> e.getIdCategoria() == buscarId);
			System.out.println("Removida a despesa solicitada!");
		} catch (Exception e) {
			System.err.println("Erro em Tipo da Categoria" + e.getMessage());
		}

	}
	
	
	
	
	
	

}
