package business;

import java.util.List;

public interface Conta {
	double consultarSaldo();

	List<String> consultarExtrato();

	boolean saque(double valor);

	void depositar(double valor);

	void transferir(Conta destino, double valor);

}
