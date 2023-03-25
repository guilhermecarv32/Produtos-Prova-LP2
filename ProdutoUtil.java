package questao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProdutoUtil {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX = 7;
		Produto[] produtos = new Produto[MAX];
		int op;
		int qtdProd = 0;
		boolean Falha = true;
		boolean Excecao = true;
		
		do {
			
			System.out.println("Qual operação deseja realizar? (1 - 5)");
			System.out.println("*****************MENU****************");
			System.out.println("* 1 - Cadastrar produto             *");
			System.out.println("* 2 - Listar produtos sem estoque   *");
			System.out.println("* 3 - Registrar venda de produto    *");
			System.out.println("* 4 - Percentual de faturamento     *");
			System.out.println("* 5 - Sair                          *");
			System.out.println("*************************************");
			op = scanner.nextInt();
			scanner.nextLine();
			System.out.println();
			
			switch(op) {
			case 1:
				do {
					try {
						System.out.println("Nome do produto: ");
						String nome = scanner.nextLine();
						System.out.println("Sigla de unidade de venda deste produto: ");
						String sigla = scanner.nextLine();
						System.out.println("Estoque Inicial: ");
						int estoque = scanner.nextInt();
						System.out.println("Preço R$");
						double preco = scanner.nextDouble();
						
						Falha = false;

						Produto produto = new Produto(nome, sigla, estoque, preco);
						produtos[qtdProd] = produto;
						qtdProd++;
					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}while(Falha);
				
			case 2:

				for(int i = 0; i <= MAX; i++) {
					if (produtos[i].isDisponivel()){
						
					} else {
						System.out.println(produtos[i].getNome());
					}
				}
				
			case 3:
				do {
					try {				
						System.out.println("Qual produto foi vendido? (1 - " + qtdProd + ")");
						int indice = scanner.nextInt();
						System.out.println("Quantas unidades?");
						int unidades = scanner.nextInt();

						produtos[indice - 1].adicionarVenda(unidades);
						
						Excecao = false;
						
					}catch(InputMismatchException e) {
						e.printStackTrace();
					}
				}while(Excecao);

			case 4:
				for(int i = 0; i <= qtdProd; i++) {
					if(produtos[i].getEstoqueDisponivel() == produtos[i].getEstoque()) {
						System.out.println("Nenhum " + produtos[i].getNome() + " vendido ainda.");
					} else {
						System.out.println("R$" + (produtos[i].getFaturamentoVenda() * 100)/produtos[i].getEstoque());
					}
				}
			}
			
		} while(op != 5);
		
		scanner.close();
	}

}