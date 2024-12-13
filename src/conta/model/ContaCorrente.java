package conta.model;

public class ContaCorrente extends Conta{ // extends -> herança/herda

	// Atributos
	private float limite;
	

	/*
	 * 3 Modificadores de Acesso: - Private: somente essa classe acessa esses
	 * artibutos - Exemplos: celular/wifi de casa - Protected: somente classes
	 * dentro desse pacote e classes herdadas acessam esses atributos - Exemplos:
	 * Telefone residencial/Wifi do trabalho - Public: todas as classes acessam
	 * esses esses atributos - Exemplos: Orelhão/ Wifi livre - Default: somente
	 * classes dentro desse pacote acessam esses atributos (sem as classes herdadas)
	 */

	// Método Especial - Método construtor
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo); // Invocando o método Construtor Conta 
		// this -> Classe ContaCorrente
		this.limite = limite;
	}
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo); // Invocando o método Construtor Conta 
		// this -> Classe ContaCorrente
		this.limite = 5000.0f;
	}
	
	// Métodos de Acesso
	public float getLimite() {
		return limite;
	}
	
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	public boolean sacar(float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
				return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	//Polimorfismo de Sobrescrita -> adiciona mais lógica a um método já existente
	public void visualizar() {
		super.visualizar(); //Método da classe Conta
		System.out.println("Limite de Crédito: "+this.limite);
	}
}