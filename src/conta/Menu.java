package conta;

import java.util.Scanner;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;


public class Menu {

	public static void main(String[] args) {

		// Instanciamento | Classe -> Objeto utilizável
		
		ContaCorrente contaC1 = new ContaCorrente(1, 123 , 1 ,"Adriana" , 10000f, 10000f);
		contaC1.visualizar();
		
		ContaCorrente contaC2 = new ContaCorrente(2,123, 1, "João", 5000f, 1000f);
		contaC2.visualizar();
		
		ContaPoupanca contaP3 = new ContaPoupanca(3,123, 1, "Marcos", 1000f, 15);
		contaP3.visualizar();
		
		Scanner ler = new Scanner(System.in);

		int opcao;

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

			opcao = ler.nextInt();


			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nBanco do Limoeiro - O seu Futuro começa aqui!");
				sobre();
				ler.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Criar Conta\n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida.\n");
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
}