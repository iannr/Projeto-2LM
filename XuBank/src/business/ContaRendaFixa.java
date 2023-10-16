package business;

import java.util.ArrayList;
import java.util.List;

public class ContaRendaFixa implements Conta {
    private Cliente cliente;
    private double saldo;
    private double rendimentoContratado;
    private List<String> extrato;
    private static final double IMPOSTO_SAQUE = 0.15; // 15%

    public ContaRendaFixa(Cliente cliente, double rendimentoContratado) {
        this.cliente = cliente;
        this.saldo = 0;
        this.rendimentoContratado = rendimentoContratado;
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

    public double getRendimentoContratado() {
        return rendimentoContratado;
    }
    
    public void setRendimentoContratado(double rendimentoContratado) {
    	this.rendimentoContratado = rendimentoContratado;
    }
}