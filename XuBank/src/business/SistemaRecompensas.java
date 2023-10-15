package business;

public class SistemaRecompensas {
	private int pontos;

	public SistemaRecompensas() {
		this.pontos = 0;
	}

	// Método para acumular pontos
	public void acumularPontos(int quantidade) {
		pontos += quantidade;
	}

	// Método para verificar o saldo de pontos
	public int getSaldoPontos() {
		return pontos;
	}

	// Método para resgatar pontos por prêmios, descontos, ou conversão em dinheiro
	public void resgatarPontos(int quantidade) {
		if (pontos >= quantidade) {
			pontos -= quantidade;
			// Implemente aqui a lógica para conceder prêmios, descontos ou conversão em
			// dinheiro.
		} else {
			System.out.println("Saldo insuficiente de pontos.");
		}
	}

}
