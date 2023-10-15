package business;

import java.util.ArrayList;
import java.util.List;

public abstract class ContaBase implements Conta {
	private double saldo;
	private List<String> extrato;

	public ContaBase() {
		saldo = 0;
		extrato = new ArrayList<>();
	}

	public double consultarSaldo() {
		return saldo;
	}

	public List<String> consultarExtrato() {
		return extrato;
	}

	public void depositar(double valor) {
		saldo += valor;
		extrato.add("Depósito: +R$" + valor);
	}

	public boolean sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			extrato.add("Saque: -R$" + valor);
			return true;
		}
		return false;
	}

	public void transferir(Conta destino, double valor) {
		if (sacar(valor)) {
			destino.depositar(valor);
			extrato.add("Transferência: -R$" + valor);
		}
	}
}
