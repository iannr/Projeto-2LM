package business;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContaPoupanca implements Conta{
	 private Cliente cliente;
	    private double saldo;
	    private List<String> extrato;
	    private static final double RENDIMENTO_MENSAL = 0.005; // 0,5%

	    public ContaPoupanca(Cliente cliente) {
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
	        // Aplicar rendimento mensal
	        double rendimento = saldo * RENDIMENTO_MENSAL;
	        saldo += rendimento;
	        extrato.add("Rendimento Mensal: + R$" + rendimento);
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
	    public void transferir(Conta destino, double valor)
	{
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
