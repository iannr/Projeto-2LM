package business;

public class ClienteGold extends Cliente {
	private double saldoTotal;
	private int pontosFidelidade;
	private SistemaRecompensas sistemaRecompensas;
    private static final double TAXA_MENSAL = 10.0;

	public ClienteGold(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.pontosFidelidade = 0;
		this.sistemaRecompensas = new SistemaRecompensas();
		this.saldoTotal = 0;
	}

	// Métodos específicos para o cliente GOLD
		public void acumularPontosFidelidadeSaldo(double saldo) {
			int pontosGanhos = (int) (saldo / 1000) * 10; // Acumula 10 pontos para cada R$1.000 de saldo
			pontosFidelidade += pontosGanhos;
			sistemaRecompensas.acumularPontos(pontosGanhos);
		}
		
	// Métodos específicos para o cliente GOLD
	public void acumularPontosFidelidadeMensal() {
		pontosFidelidade += 10;
		sistemaRecompensas.acumularPontos(10);
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
	
	public void cobrarTaxaMensal() {
        saldoTotal -= TAXA_MENSAL;
    }
	
	 public double getSaldoTotal() {
	        return saldoTotal;
	    }
}