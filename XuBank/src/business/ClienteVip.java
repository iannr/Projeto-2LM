package business;

public class ClienteVip extends Cliente {
	private double saldoTotal;
	private int pontosFidelidade;
	private SistemaRecompensas sistemaRecompensas;
	  private static final double TAXA_MENSAL = 30.0;

	public ClienteVip(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.pontosFidelidade = 0;
		this.sistemaRecompensas = new SistemaRecompensas();
		this.saldoTotal = 0;
	}

	// Métodos específicos para o cliente VIP
	public void acumularPontosFidelidadeSaldo(double saldo) {
		int pontosGanhos = (int) (saldo / 2000) * 30;
		pontosFidelidade += pontosGanhos;
		sistemaRecompensas.acumularPontos(pontosGanhos);
	}
	
	// Métodos específicos para o cliente VIP
		public void acumularPontosFidelidadeMensal() {
			pontosFidelidade += 35;
			sistemaRecompensas.acumularPontos(35);
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