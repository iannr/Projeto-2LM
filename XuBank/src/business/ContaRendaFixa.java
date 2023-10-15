package business;

public class ContaRendaFixa {
    private double saldo;
    private double taxaJurosAnual = 0.05; // 5% de juros anuais

    public ContaRendaFixa(double saldoInicial) {
        saldo = saldoInicial;
    }

    public void aplicarJurosAnuais() {
        saldo += saldo * taxaJurosAnual;
    }

    public void cobrarImpostoSaque() {
        double rendimento = saldo - (saldo / (1 + taxaJurosAnual));
        double imposto = rendimento * 0.15; // Imposto de 15% sobre o rendimento
        saldo -= imposto;
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

    public static void main(String[] args) {
        ContaRendaFixa minhaConta = new ContaRendaFixa(1000.0);
        System.out.println("Saldo inicial: R$" + minhaConta.getSaldo());

        minhaConta.aplicarJurosAnuais();
        System.out.println("Saldo após a aplicação de juros anuais: R$" + minhaConta.getSaldo());

        minhaConta.cobrarImpostoSaque();
        System.out.println("Saldo após o saque com cobrança de imposto: R$" + minhaConta.getSaldo());

        double deposito = 500.0;
        minhaConta.depositar(deposito);
        System.out.println("Saldo após o depósito de R$" + deposito + ": R$" + minhaConta.getSaldo());
    }
}
