package business;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimento implements Conta {
    private Cliente cliente;
    private double saldo;
    private double rendimentoDiario;
    private List<String> extrato;
    private static final double IMPOSTO_SAQUE = 0.15; // 15%

    public ContaInvestimento(Cliente cliente, double rendimentoDiario) {
        this.cliente = cliente;
        this.saldo = 0;
        this.rendimentoDiario = rendimentoDiario;
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
            double imposto = valor * IMPOSTO_SAQUE;
            saldo -= (valor + imposto);
            extrato.add("Saque: - R$" + valor);
            extrato.add("Imposto de Saque: - R$" + imposto);
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

    public double getRendimentoDiario() {
        return rendimentoDiario;
    }
    public void setRendimentoDiario(double rendimentoDiario) {
    	this.rendimentoDiario = rendimentoDiario;
    }
}
