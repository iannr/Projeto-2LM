import java.util.ArrayList;
import java.util.List;

// Classe base para representar um cliente
class Cliente {
    private String nome;
    private String CPF;
    private String senha;
    private List<Conta> contas;

    public Cliente(String nome, String CPF, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getSenha() {
        return senha;
    }

    public List<Conta> getContas() {
        return contas;
    }

    // Método para adicionar uma conta ao cliente
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    // Método para consultar saldo de uma conta
    public double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

    // Método para consultar extrato de uma conta
    public List<String> consultarExtrato(Conta conta) {
        return conta.getExtrato();
    }

    // Método para depositar em uma conta
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    // Método para sacar de uma conta
    public void sacar(Conta conta, double valor) {
        conta.sacar(valor);
    }

    // Método para transferir entre contas
    public void transferir(Conta origem, Conta destino, double valor) {
        origem.transferir(destino, valor);
    }
}

