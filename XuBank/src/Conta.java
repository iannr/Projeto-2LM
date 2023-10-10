import java.util.ArrayList;
import java.util.List;

abstract class Conta {
    private double saldo;
    private Cliente cliente;
    private List<String> extrato;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
        this.extrato = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getExtrato() {
        return extrato;
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add("Depósito: +" + valor);
    }

    // Método abstrato para sacar (será implementado nas subclasses)
    public abstract void sacar(double valor);

    // Método para transferir entre contas
    public void transferir(Conta destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            extrato.add("Transferência para " + destino.getClass().getSimpleName() + ": -" + valor);
            destino.getExtrato().add("Transferência de " + getClass().getSimpleName() + ": +" + valor);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }
}