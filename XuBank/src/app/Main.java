package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.Cliente;
import business.ClienteGold;
import business.ClienteRegular;
import business.ClienteVip;
import business.Conta;
import business.ContaCorrente;
import business.ContaInvestimento;
import business.ContaPoupanca;
import business.ContaRendaFixa;
import business.TipoConta;
import business.XuBank;

public class Main {
	public static void main(String[] args) {
	     XuBank banco = new XuBank();
		Scanner scanner = new Scanner(System.in);

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
				System.out.print("Nome do cliente: ");
			    String nomeCliente = scanner.nextLine();
			    System.out.print("CPF do cliente: ");
			    String cpfCliente = scanner.nextLine();
			    System.out.print("Senha do cliente: ");
			    String senhaCliente = scanner.nextLine();
			    
			    System.out.println("Escolha o tipo de cliente:");
			    System.out.println("1. Regular");
			    System.out.println("2. Gold");
			    System.out.println("3. Vip");
			    System.out.print("Escolha o tipo de cliente: ");
			    int tipoCliente = scanner.nextInt();
			    
			    Cliente novoCliente = null;
			    switch (tipoCliente) {
			        case 1:
			            novoCliente = new ClienteRegular(nomeCliente, cpfCliente, senhaCliente);
			            break;
			        case 2:
			            novoCliente = new ClienteGold(nomeCliente, cpfCliente, senhaCliente);
			            break;
			        case 3:
			            novoCliente = new ClienteVip(nomeCliente, cpfCliente, senhaCliente);
			            break;
			        default:
			            System.out.println("Tipo de cliente inválido. Criando como cliente Regular.");
			            novoCliente = new ClienteRegular(nomeCliente, cpfCliente, senhaCliente);
			    }

			    banco.adicionarCliente(novoCliente);
			    System.out.println("Cliente criado com sucesso.");

				break;
			case 2:
				// Criar uma nova conta
                System.out.print("Digite o CPF do cliente associado à conta: ");
                String cpfAssociado = scanner.nextLine();
                Cliente clienteAssociado = null;
                for (Cliente cliente : banco.clientes) {
                    if (cliente.getCpf().equals(cpfAssociado)) {
                        clienteAssociado = cliente;
                        break;
                    }
                }
                if (clienteAssociado == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }
                System.out.println("Escolha o tipo de conta:");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta Poupança");
                System.out.println("3. Conta Renda Fixa");
                System.out.println("4. Conta de Investimento");
                System.out.print("Escolha o tipo de conta: ");
                int tipoConta = scanner.nextInt();
                double[] parametros = null;

                if (tipoConta == 3 || tipoConta == 4) {
                    // Solicitar taxa de rendimento
                    System.out.print("Taxa de rendimento: ");
                    double taxa = scanner.nextDouble();
                    parametros = new double[]{taxa};
                }

                TipoConta tipo = TipoConta.values()[tipoConta - 1];
                banco.abrirConta(clienteAssociado, tipo, parametros);
                System.out.println("Conta criada com sucesso.");
				
				break;
			case 3:
				
				 // Consultar saldo
                System.out.print("Digite o CPF do cliente: ");
                String cpfClienteSaldo = scanner.nextLine();
                Cliente clienteSaldo = null;
                for (Cliente cliente : banco.clientes) {
                    if (cliente.getCpf().equals(cpfClienteSaldo)) {
                        clienteSaldo = cliente;
                        break;
                    }
                }
                if (clienteSaldo == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }

                for (Conta conta : banco.contas) {
                    if (conta.getCliente() == clienteSaldo) {
                        double saldo = conta.consultarSaldo();
                        System.out.println("Saldo de " + clienteSaldo.getNome() + ": R$" + saldo);
                        break;
                    }
                }
				break;
			case 4:
				// Consultar extrato
                System.out.print("Digite o CPF do cliente: ");
                String cpfClienteExtrato = scanner.nextLine();
                Cliente clienteExtrato = null;
                for (Cliente cliente : banco.clientes) {
                    if (cliente.getCpf().equals(cpfClienteExtrato)) {
                        clienteExtrato = cliente;
                        break;
                    }
                }
                if (clienteExtrato == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }

                for (Conta conta : banco.contas) {
                    if (conta.getCliente() == clienteExtrato) {
                        List<String> extrato = banco.consultarExtrato(clienteExtrato, conta);
                        System.out.println("Extrato de " + clienteExtrato.getNome() + ":");
                        for (String transacao : extrato) {
                            System.out.println(transacao);
                        }
                        break;
                    }
                }
				break;
			case 5:
				// Operação de depósito
                System.out.print("Digite o CPF do cliente: ");
                String cpfClienteDeposito = scanner.nextLine();
                Cliente clienteDeposito = null;
                for (Cliente cliente : banco.clientes) {
                    if (cliente.getCpf().equals(cpfClienteDeposito)) {
                        clienteDeposito = cliente;
                        break;
                    }
                }
                if (clienteDeposito == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }

                System.out.print("Digite o valor do depósito: ");
                double valorDeposito = scanner.nextDouble();

                for (Conta conta : banco.contas) {
                    if (conta.getCliente() == clienteDeposito) {
                        conta.depositar(valorDeposito);
                        System.out.println("Depósito de R$" + valorDeposito + " realizado com sucesso.");
                        break;
                    }
                }
				break;
			case 6:
				
				// Operação de saque
                System.out.print("Digite o CPF do cliente: ");
                String cpfClienteSaque = scanner.nextLine();
                Cliente clienteSaque = null;
                for (Cliente cliente : banco.clientes) {
                    if (cliente.getCpf().equals(cpfClienteSaque)) {
                        clienteSaque = cliente;
                        break;
                    }
                }
                if (clienteSaque == null) {
                    System.out.println("Cliente não encontrado.");
                    break;
                }

                System.out.print("Digite o valor do saque: ");
                double valorSaque = scanner.nextDouble();

                for (Conta conta : banco.contas) {
                    if (conta.getCliente() == clienteSaque) {
                        if (conta.sacar(valorSaque)) {
                            System.out.println("Saque de R$" + valorSaque + " realizado com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente para o saque.");
                        }
                        break;
                    }
                }
				break;
			case 7:
				
				 System.out.print("Informe o CPF do cliente de origem: ");
				    String cpfOrigem = scanner.nextLine();
				    Cliente clienteOrigem = null;

				    // Encontrar o cliente correspondente ao CPF de origem
				    for (Cliente cliente : banco.clientes) {
				        if (cliente.getCpf().equals(cpfOrigem)) {
				            clienteOrigem = cliente;
				            break;
				        }
				    }

				    if (clienteOrigem != null) {
				        System.out.print("Informe o número da conta de origem:\n1. Conta Corrente\n2. Conta Poupança\n3. Conta Renda Fixa\n4. Conta Investimento\nEscolha uma opção: ");
				        int numeroContaOrigem = scanner.nextInt();
				        Conta contaOrigem = null;

				        // Encontrar a conta correspondente ao número e ao cliente de origem
				        for (Conta conta : banco.contas) {
				            if (conta.getCliente() == clienteOrigem) {
				                if (conta instanceof ContaCorrente && numeroContaOrigem == 1) {
				                    contaOrigem = conta;
				                    break;
				                } else if (conta instanceof ContaPoupanca && numeroContaOrigem == 2) {
				                    contaOrigem = conta;
				                    break;
				                } else if (conta instanceof ContaRendaFixa && numeroContaOrigem == 3) {
				                    contaOrigem = conta;
				                    break;
				                } else if (conta instanceof ContaInvestimento && numeroContaOrigem == 4) {
				                    contaOrigem = conta;
				                    break;
				                }
				            }
				        }

				        if (contaOrigem != null) {
				            System.out.print("Informe o CPF do cliente de destino: ");
				            scanner.nextLine();  // Limpa a quebra de linha anterior
				            String cpfDestino = scanner.nextLine();
				            Cliente clienteDestino = null;

				            // Encontrar o cliente correspondente ao CPF de destino
				            for (Cliente cliente : banco.clientes) {
				                if (cliente.getCpf().equals(cpfDestino)) {
				                    clienteDestino = cliente;
				                    break;
				                }
				            }

				            if (clienteDestino != null) {
				                System.out.print("Informe o número da conta de destino:\n1. Conta Corrente\n2. Conta Poupança\n3. Conta Renda Fixa\n4. Conta Investimento\nEscolha uma opção: ");
				                int numeroContaDestino = scanner.nextInt();
				                Conta contaDestino = null;

				                // Encontrar a conta correspondente ao número e ao cliente de destino
				                for (Conta conta : banco.contas) {
				                    if (conta.getCliente() == clienteDestino) {
				                        if (conta instanceof ContaCorrente && numeroContaDestino == 1) {
				                            contaDestino = conta;
				                            break;
				                        } else if (conta instanceof ContaPoupanca && numeroContaDestino == 2) {
				                            contaDestino = conta;
				                            break;
				                        } else if (conta instanceof ContaRendaFixa && numeroContaDestino == 3) {
				                            contaDestino = conta;
				                            break;
				                        } else if (conta instanceof ContaInvestimento && numeroContaDestino == 4) {
				                            contaDestino = conta;
				                            break;
				                        }
				                    }
				                }

				                if (contaDestino != null) {
				                    System.out.print("Informe o valor da transferência: R$");
				                    double valorTransferencia = scanner.nextDouble();

				                    if (contaOrigem.sacar(valorTransferencia)) {
				                        contaDestino.depositar(valorTransferencia);
				                        System.out.println("Transferência realizada com sucesso.");
				                    } else {
				                        System.out.println("Saldo insuficiente para a transferência.");
				                    }
				                } else {
				                    System.out.println("Número de conta de destino inválido.");
				                }
				            } else {
				                System.out.println("Cliente de destino com CPF informado não encontrado.");
				            }
				        } else {
				            System.out.println("Número de conta de origem inválido.");
				        }
				    } else {
				        System.out.println("Cliente de origem com CPF informado não encontrado.");
				    }
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
