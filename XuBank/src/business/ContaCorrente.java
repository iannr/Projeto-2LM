package business;

public class ContaCorrente {
	private double saldo;

	public ContaCorrente(double saldoInicial) {
		saldo = saldoInicial;
	}

	public void cobrarTaxaMensal() {
		saldo -= 20.0;
	}

	public boolean realizarSaqueEspecial(double valor) {
		if (valor > 0 && valor <= (saldo + 200.0)) {
			saldo -= valor;
			return true;
		} else {
			System.out.println("Saque especial excedeu o limite de R$200 ou é um valor inválido.");
			return false;
		}
	}

	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
		} else {
			System.out.println("O valor de depósito deve ser maior que zero.");
		}
	}

	public double getSaldo() {
		return saldo;
	}
}
