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
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		System.out.println("\nCriar Conta\n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 12, 1, "João da Silva",1000f,100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 12, 1, "Maria da Silva",2000f,100.0f);
		contas.cadastrar(cc2);
		
		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 12, 2, "Mariana dos Santos", 4000f,12);
		contas.cadastrar(cp1);
		
		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 12, 2, "Juliana Ramos",8000f,15);
		contas.cadastrar(cp2);	
		
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
			System.out.println("				4 - Apagar Conta																				");
			System.out.println("				5 - Apagar 																						");
			System.out.println("				6 - Sacar																						");
			System.out.println("				7 - Depositar 																					");
			System.out.println("				8 - Transferir valores entre Contas																");
			System.out.println("				9 - Sair																						");
			System.out.println("																											");
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
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da Conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
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

