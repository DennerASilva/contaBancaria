package conta;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

public class Menu {

	public static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		System.out.println("\nCriar Conta\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 12, 1, "João da Silva",1000f,100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 12, 1, "Maria da Silva",2000f,100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 12, 2, "Mariana dos Santos", 4000f,12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 12, 2, "Juliana Ramos",8000f,15);
		contas.cadastrar(cp2);	
		
		contas.listarTodas();
		
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("==============================================================================================================");
			System.out.println("																												");
			System.out.println("						BANCO DO LIMOEIRO																		");
			System.out.println("																												");
			System.out.println("==============================================================================================================");
			System.out.println("																												");
			System.out.println("				1 - Criar Conta																					");
			System.out.println("			 	2 - Listar todas as Contas 																		");
			System.out.println("				3 - Buscar Conta por Numero																		");
			System.out.println("				4 - Atualizar Dados da Conta																	");
			System.out.println("				5 - Apagar Conta																				");
			System.out.println("				6 - Sacar																						");
			System.out.println("				7 - Depositar 																					");
			System.out.println("				8 - Transferir valores entre Contas																");
			System.out.println("				9 - Sair																						");
			System.out.println("																												");
			System.out.println("==============================================================================================================");
			System.out.print("Entre com a opção desejada: "+Cores.TEXT_RESET);

			try {
				opcao = ler.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros.");
				ler.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nBanco do Limoeiro - O seu Futuro começa aqui!");
				sobre();
				ler.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar Conta\n\n");
				
				System.out.print("Digite o número da agência: ");
				agencia = ler.nextInt();
				System.out.print("Digite o nome do titular: ");
				ler.skip("\\R?");
				titular = ler.nextLine();
				
				do {
					System.out.print("Digite o tipo da Conta(1-CC ou 2-CP): ");
					tipo = ler.nextInt();
				} while (tipo < 1 && tipo >2); 
				
				System.out.print("Digite o Saldo da Conta: R$");
				saldo = ler.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.print("Digite o Limite de Crédito: R$");
					limite = ler.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.print("Digite o dia do Aniversário da Conta: ");
					aniversario = ler.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = ler.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da Conta\n\n");
				
				System.out.print("Digite o número da Conta: ");
				numero = ler.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.print("Digite o número da agência: ");
					agencia = ler.nextInt();
					System.out.print("Digite o nome do titular: ");
					ler.skip("\\R?");
					titular = ler.nextLine();
					
					System.out.print("Digite o saldo da conta: R$");
					saldo = ler.nextFloat();
					
					switch (tipo) {
						case 1 -> {
							System.out.print("Digite o Limite de Crédito: R$");
							limite = ler.nextFloat();
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.print("Digite o dia do Aniversário da Conta: ");
							aniversario = ler.nextInt();
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
	
						}
						default -> {
							System.out.println("Tipo de Conta inválido!");
						}
					}		
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				
				System.out.println("Digite o número da Conta: ");
				numero = ler.nextInt();
				
				contas.deletar(numero);
								
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = ler.nextInt();
				
				do {
					System.out.print("Digite o valor do saque: R$");
					valor = ler.nextFloat();
				} while (valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				
				System.out.print("Digite o Numero da Conta: ");
				numero = ler.nextInt();
				
				do {
					System.out.print("Digite o valor do depósito: R$");
					valor  = ler.nextFloat();
				}while (valor <=0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
				
				System.out.print("Digite o número da Conta de Origem: ");
				numero = ler.nextInt();
				System.out.print("Digite o número da Conta de Destino: ");
				numeroDestino = ler.nextInt();
				
				do {
					System.out.print("Digite o valore da transferência: R$");
					valor = ler.nextFloat();
				} while (valor <=0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida.\n");
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("==============================================================================================================");
		System.out.println("Projeto Desenvolvido por: 											");
		System.out.println("Denner A M Silva - denner.a.moura.s@gmail.com						");
		System.out.println("github.com/DennerASilva												");
		System.out.println("==============================================================================================================");
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferentes de Enter!");
		}
	}
}

