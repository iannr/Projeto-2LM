package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Cliente;
import business.Conta;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Conta> contas = new ArrayList<Conta>();

		while (true) {
			System.out.println("\nXuBank Menu:");
			System.out.println("1. Criar Cliente");
			System.out.println("2. Criar Conta");
			System.out.println("3. Consultar Saldo");
			System.out.println("4. Consultar Extrato");
			System.out.println("5. Depositar");
			System.out.println("6. Sacar");
			System.out.println("7. Transferir");
			System.out.println("8. Sair");
			System.out.print("Escolha uma opção: ");

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpa a quebra de linha

			switch (opcao) {
			case 1:

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				System.out.println("Saindo do XuBank. Até logo!");
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

}
