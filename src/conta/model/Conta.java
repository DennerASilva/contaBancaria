package conta.model;

public class Conta {

	// Atributos
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	/*
	 * 3 Modificadores de Acesso: - Private: somente essa classe acessa esses
	 * artibutos - Exemplos: celular/wifi de casa - Protected: somente classes
	 * dentro desse pacote e classes herdadas acessam esses atributos - Exemplos:
	 * Telefone residencial/Wifi do trabalho - Public: todas as classes acessam
	 * esses esses atributos - Exemplos: Orelhão/ Wifi livre - Default: somente
	 * classes dentro desse pacote acessam esses atributos (sem as classes herdadas)
	 */

	// Método Especial - Método construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {

		// this -> Classe Conta
		// Conta.numero
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	// Métodos de acesso
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	// Comportamentos/Métodos
	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() +valor);		
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch (this.tipo) {
		case 1:
			tipo = "Conta Corrente";
			break;
		case 2:
			tipo = "Conta Poupança";
			break;
		}
		
		System.out.println("\n\n==============================================================================================================");
		System.out.println("Dados da Conta:");
		System.out.println("==============================================================================================================");
		System.out.println("Número da Conta: "+this.numero);
		System.out.println("Agência: "+this.agencia);
		System.out.println("Tipo da Conta:"+tipo);
		System.out.println("Titular:"+this.titular);
		System.out.println("Saldo: "+this.saldo);
		
	}
	
}
