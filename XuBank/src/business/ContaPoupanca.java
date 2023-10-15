package business;
import java.util.Calendar;
import java.util.Date;

public class ContaPoupanca {
    private double saldo;
    private Date ultimaDataDeRendimento;

    public ContaPoupanca(double saldoInicial) {
        saldo = saldoInicial;
        ultimaDataDeRendimento = new Date();
    }

    public double getSaldo() {
        return saldo;
    }

    public void calcularRendimento() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ultimaDataDeRendimento);
        int diaDoMes = calendar.get(Calendar.DAY_OF_MONTH);

        if (diaDoMes >= 5) {
            double rendimento = saldo * 0.005; // 0,5% de rendimento
            saldo += rendimento;
            ultimaDataDeRendimento = new Date();
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("O valor de depósito deve ser maior que zero.");
        }
    }

    public static void main(String[] args) {
        ContaPoupanca minhaConta = new ContaPoupanca(1000.0);
        System.out.println("Saldo inicial: R$" + minhaConta.getSaldo());

        minhaConta.calcularRendimento();
        System.out.println("Saldo após o cálculo de rendimento: R$" + minhaConta.getSaldo());

        double deposito = 500.0;
        minhaConta.depositar(deposito);
        System.out.println("Saldo após o depósito de R$" + deposito + ": R$" + minhaConta.getSaldo());
    }
}
