package business;

import java.util.ArrayList;
import java.util.List;

public class XuBank {
    private List<Cliente> clientes;
    private List<Conta> contas;

    public XuBank() {
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void abrirConta(Cliente cliente, TipoConta tipoConta, double... parametros) {
        Conta conta;
        switch (tipoConta) {
            case CONTA_CORRENTE:
                conta = new ContaCorrente(cliente);
                break;
            case CONTA_POUPANCA:
                conta = new ContaPoupanca(cliente);
                break;
            case CONTA_RENDA_FIXA:
                if (parametros.length != 1) {
                    throw new IllegalArgumentException("A conta de Renda Fixa requer a taxa de rendimento contratada.");
                }
                conta = new ContaRendaFixa(cliente, parametros[0]);
                break;
            case CONTA_INVESTIMENTO:
                if (parametros.length != 1) {
                    throw new IllegalArgumentException("A conta de Investimento requer a taxa de rendimento diário.");
                }
                conta = new ContaInvestimento(cliente, parametros[0]);
                break;
            default:
                throw new IllegalArgumentException("Tipo de conta inválido.");
        }
        contas.add(conta);
    }

    public List<String> consultarExtrato(Cliente cliente, Conta conta) {
        if (conta.getCliente() == cliente) {
            return conta.consultarExtrato();
        }
        return new ArrayList<>();
    }

    public double calcularSaldoMedio() {
        double totalSaldo = 0;
        int totalContas = 0;

        for (Conta conta : contas) {
            totalSaldo += conta.consultarSaldo();
            totalContas++;
        }

        if (totalContas == 0) {
            return 0; // Evita divisão por zero
        }

        return totalSaldo / totalContas;
    }

    public int contarClientesComSaldoNegativo() {
        int contador = 0;

        for (Conta conta : contas) {
            if (conta.consultarSaldo() < 0) {
                contador++;
            }
        }

        return contador;
    }

    public Cliente encontrarClienteComMaiorSaldo() {
        Cliente clienteMaiorSaldo = null;
        double maiorSaldo = Double.NEGATIVE_INFINITY;

        for (Conta conta : contas) {
            double saldo = conta.consultarSaldo();
            if (saldo > maiorSaldo) {
                maiorSaldo = saldo;
                clienteMaiorSaldo = conta.getCliente();
            }
        }

        return clienteMaiorSaldo;
    }

    public Cliente encontrarClienteComMenorSaldo() {
        Cliente clienteMenorSaldo = null;
        double menorSaldo = Double.POSITIVE_INFINITY;

        for (Conta conta : contas) {
            double saldo = conta.consultarSaldo();
            if (saldo < menorSaldo) {
                menorSaldo = saldo;
                clienteMenorSaldo = conta.getCliente();
            }
        }

        return clienteMenorSaldo;
    }
}