package business;

public class ClienteVip extends Cliente {
	private int pontosFidelidade;
	private SistemaRecompensas sistemaRecompensas;

	public ClienteVip(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.pontosFidelidade = 0;
		this.sistemaRecompensas = new SistemaRecompensas();
	}

	// Métodos específicos para o cliente VIP
	public void acumularPontosFidelidade(double saldo) {
		int pontosGanhos = (int) (saldo / 2000) * 30;
		pontosFidelidade += pontosGanhos;
		sistemaRecompensas.acumularPontos(pontosGanhos);
	}

	public void verificarSaldoFidelidade() {
		System.out.println("Pontos de fidelidade: " + pontosFidelidade);
	}

	public void resgatarRecompensas(int quantidadePontos) {
		sistemaRecompensas.resgatarPontos(quantidadePontos);
	}

	@Override
	public String getTipoCliente() {
		throw new UnsupportedOperationException("Cliente Gold'");
	}
}