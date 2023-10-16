package business;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrente implements Conta{
	private Cliente cliente;
	private double saldo;
	private List<String> extrato;

	public ContaCorrente(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }

	@Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito: + R$" + valor);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            extrato.add("Saque: - R$" + valor);
            return true;
        }
        return false;
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            extrato.add("Transferência para " + destino.getCliente().getNome() + ": - R$" + valor);
        }
    }

    @Override
    public List<String> consultarExtrato() {
        return extrato;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
