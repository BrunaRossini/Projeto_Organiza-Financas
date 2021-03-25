package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Movimentacao {

	private int idMovimentacao;
	private double valorMovimentacao;
	private LocalDate dataPagamentoMovimentacao;
	private LocalDate dataRecebimentoMovimentacao;
	private LocalDateTime dataCadastroMovimentcao;
	private LocalDate dataCompra;
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

	public LocalDate getDataPagamentoMovimentacao() {
		return dataPagamentoMovimentacao;
	}

	public void setDataPagamentoMovimentacao(LocalDate dataPagamentoMovimentacao) {
		this.dataPagamentoMovimentacao = dataPagamentoMovimentacao;
	}

	public LocalDate getDataRecebimentoMovimentacao() {
		return dataRecebimentoMovimentacao;
	}

	public void setDataRecebimentoMovimentacao(LocalDate dataRecebimentoMovimentacao) {
		this.dataRecebimentoMovimentacao = dataRecebimentoMovimentacao;
	}

	public LocalDateTime getDataCadastroMovimentcao() {
		return dataCadastroMovimentcao;
	}

	public void setDataCadastroMovimentcao(LocalDateTime dataCadastroMovimentcao) {
		this.dataCadastroMovimentcao = dataCadastroMovimentcao;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Categoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(Categoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

}
