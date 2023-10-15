import java.util.ArrayList;
import java.util.List;

import business.Cliente;
import business.ClienteGold;
import business.ClienteRegular;
import business.ClienteVip;

class SistemaRecompensa {
    private int pontos;

    public SistemaRecompensa() {
        pontos = 0;
    }

    public int getPontos() {
        return pontos;
    }

    public void acumularPontos(int quantidade) {
        pontos += quantidade;
    }

    public boolean verificarElegibilidade(Cliente cliente) {
        if (cliente instanceof ClienteGold) {
            return pontos >= 10;
        } else if (cliente instanceof ClienteVip) {
            return pontos >= 30;
        } else {
            return false;
        }
    }

    public void trocarPontosPorPremio(Cliente cliente, int quantidade) {
        if (verificarElegibilidade(cliente)) {
            pontos -= quantidade;
            System.out.println(cliente.getNome() + " trocou " + quantidade + " pontos por um prêmio.");
        } else {
            System.out.println(cliente.getNome() + " não possui pontos suficientes para trocar por prêmio.");
        }
    }
}

public class SistemaRecompensaTest {
    public static void main(String[] args) {
        SistemaRecompensa sistemaRecompensa = new SistemaRecompensa();


        ClienteRegular clienteRegular = new ClienteRegular("Saulo", "123456789", "senha");
        ClienteGold clienteGold = new ClienteGold("Raul", "987654321", "senha");
        ClienteVip clienteVip = new ClienteVip("Diogo", "111222333", "senha");


        sistemaRecompensa.acumularPontos(5);
        sistemaRecompensa.acumularPontos(15);

        System.out.println("Pontos acumulados: " + sistemaRecompensa.getPontos());


        sistemaRecompensa.trocarPontosPorPremio(clienteRegular, 10);
        sistemaRecompensa.trocarPontosPorPremio(clienteGold, 10);
        sistemaRecompensa.trocarPontosPorPremio(clienteVip, 25);
    }
}
