package business;

public class ContaInvestimento {
    private double saldo;
    private double taxaRendimentoDiario = 0.002; // Rendimento diário de 0,2%
    private double taxaImposto = 0.15; // Imposto de 15%
    private double taxaSaque = 0.015; // Taxa de saque de 1,5%

    public ContaInvestimento(double saldoInicial) {
        saldo = saldoInicial;
    }

    public void calcularRendimentoDiario() {
        double rendimento = saldo * taxaRendimentoDiario;
        saldo += rendimento;

        if (rendimento > 0) {
            System.out.println("Rendimento positivo: R$" + rendimento);
        } else if (rendimento < 0) {
            System.out.println("Rendimento negativo: R$" + rendimento);
        } else {
            System.out.println("Sem rendimento.");
        }
    }

    public void sacar(double valor) {
        double rendimento = saldo * taxaRendimentoDiario;
        double valorSaque = valor + (rendimento * taxaSaque);

        if (valorSaque <= saldo) {
            saldo -= valorSaque;
            double imposto = rendimento * taxaImposto;
            saldo -= imposto;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para efetuar o saque.");
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

    public static void main(String[] args) {
        ContaInvestimento minhaConta = new ContaInvestimento(1000.0);
        System.out.println("Saldo inicial: R$" + minhaConta.getSaldo());

        minhaConta.calcularRendimentoDiario();
        System.out.println("Saldo após o cálculo de rendimento diário: R$" + minhaConta.getSaldo());

        double saque = 300.0;
        minhaConta.sacar(saque);
        System.out.println("Saldo após o saque de R$" + saque + ": R$" + minhaConta.getSaldo());

        double deposito = 500.0;
        minhaConta.depositar(deposito);
        System.out.println("Saldo após o depósito de R$" + deposito + ": R$" + minhaConta.getSaldo());
    }
}
