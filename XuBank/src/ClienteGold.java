
class ClienteGold extends Cliente {
    private int pontosFidelidade;
    private SistemaRecompensas sistemaRecompensas;

    public ClienteGold(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.pontosFidelidade = 0;
        this.sistemaRecompensas = new SistemaRecompensas();
    }

    // Métodos específicos para o cliente Gold
    public void acumularPontosFidelidade() {
        pontosFidelidade += 10;
        sistemaRecompensas.acumularPontos(10);
    }

    public void verificarSaldoFidelidade() {
        System.out.println("Pontos de fidelidade: " + pontosFidelidade);
    }

    public void resgatarRecompensas(int quantidadePontos) {
        sistemaRecompensas.resgatarPontos(quantidadePontos);
    }
}