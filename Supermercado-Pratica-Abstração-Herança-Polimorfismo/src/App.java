import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		// TODO inserir no sistema ArrayList do carrinho do user
		//TODO Filtrar tabela dos produtos

		Scanner input = new Scanner(System.in);

		boolean toMenu = true, toMenuCustomer = true, toMenuWorker = true, toMenuPeople = true;
		String delItem, item;
		Double valorD;
		int valorI, identificator, quantity, index;

		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Sale> cart = new ArrayList<Sale>();

		Supermarket people = new Supermarket();
		Sale purchase = new Sale();

		System.out.println("=-=-=- Simulação de Super Mercado -=-=-=");
		System.out.println();
		System.out.print("Insira o nome do Mercado: ");
		people.setSupermarketName(input.nextLine());
		System.out.println();

		while (toMenu == true) {

			System.out.println("=-=-=-=-=-=-=-=-= MENU =-=-=-=-=-=-=-=-=");
			System.out.println("Insira o tipo de usuário que deseja se passar: ");
			System.out.println("1- Funcionário");
			System.out.println("2- Cliente");
			System.out.println();
			System.out.print("Escolha: ");
			people.setChoiceMenu(input.nextInt());
			System.out.println();

			while (people.getChoiceMenu() != 1 && people.getChoiceMenu() != 2) {
				System.out.print("Insira novamente: ");
				people.setChoiceMenu(input.nextInt());
				System.out.println();
			}

			toMenu = false;
			if (people.getChoiceMenu() == 1) {
				toMenuPeople = true;
				toMenuWorker = true;
				toMenuCustomer = false;
			} else if (people.getChoiceMenu() == 2) {
				toMenuPeople = true;
				toMenuWorker = false;
				toMenuCustomer = true;
			}

			while (toMenuPeople == true) {

				Product product = new Product();

				while (toMenuWorker == true) {

					// Seção Funcionário

					if (people.getChoiceOptions() != 3) {
						clearScreen();
					}

					System.out.println("Escolha uma alternativa dos funcionários: ");
					System.out.println("1- Cadastrar Produto");
					System.out.println("2- Excluir Produto");
					System.out.println("3- Mostrar Tabela dos Produtos");
					System.out.println("4- Voltar");
					System.out.println();
					System.out.print("Escolha: ");
					people.setChoiceOptions(input.nextInt());
					System.out.println();

					// Tratamento de Erro
					while (people.getChoiceOptions() != 1 && people.getChoiceOptions() != 2
							&& people.getChoiceOptions() != 3 && people.getChoiceOptions() != 4) {
						System.out.print("Insira novamente: ");
						people.setChoiceOptions(input.nextInt());
						System.out.println();
					}

					toMenuWorker = true;

					input.nextLine().substring(0, 0);

					if (people.getChoiceMenu() == 1 && people.getChoiceOptions() == 1) {
						// Cadastrar Produto

						System.out.print("Código do Produto: " + product.ID);

						product.ID++;

						System.out.print("Insira o nome do Produto: ");
						product.setProductName(input.nextLine());
						System.out.println();

						System.out.print("Insira a qual sessão o Produto faz parte: ");
						product.setSection(input.nextLine());
						System.out.println();

						do {

							System.out.print("Insira o preço do Produto: R$");
							valorD = input.nextDouble();
							System.out.println();

						} while (valorD < 0);
						product.setPriceProduct(valorD);

						do {

							System.out.println("Insira a quantidade em estoque: ");
							valorI = input.nextInt();
							System.out.println();

						} while (valorI < 0);
						product.setStorage(input.nextInt());

						productList.add(product);

					} else if (people.getChoiceMenu() == 1 && people.getChoiceOptions() == 2) {
						// TODO Deletar Produto

						System.out.print("Insira o código do Produto: ");
						delItem = input.nextLine().substring(0, 0);
						System.out.println();

					} else if (people.getChoiceMenu() == 1 && people.getChoiceOptions() == 3) {
						// Mostrar os Produtos da Tabela

						product.tableOfProducts(productList);

					} else if (people.getChoiceMenu() == 1 && people.getChoiceOptions() == 4) {
						// Retornar ao menu principal

						toMenu = true;
						toMenuPeople = false;
						toMenuWorker = false;
						toMenuCustomer = false;

					}

				}

				while (toMenuCustomer == true) {
					// Seção Cliente

					if (people.getChoiceOptions() != 1) {
						clearScreen();
					}

					System.out.println("Escolha uma alternativa dos clientes: ");
					System.out.println("1- Mostrar Tabela dos Produtos");
					System.out.println("2- Adicionar Produto ao carrinho");
					System.out.println("3- Devolver Produto");
					System.out.println("4- Finalizar venda");
					System.out.println("5- Gerar Nota Fiscal");
					System.out.println("6- Voltar");
					System.out.println();
					System.out.print("Escolha: ");
					people.setChoiceOptions(input.nextInt());
					System.out.println();

					// Tratamento de Erro
					while (people.getChoiceOptions() != 1 && people.getChoiceOptions() != 2
							&& people.getChoiceOptions() != 3 && people.getChoiceOptions() != 4
							&& people.getChoiceOptions() != 5 && people.getChoiceOptions() != 6) {
						System.out.print("Insira novamente: ");
						people.setChoiceOptions(input.nextInt());
						System.out.println();
					}

					toMenuCustomer = true;

					if (people.getChoiceMenu() == 2 && people.getChoiceOptions() == 1) {
						// Mostra a Tabela de Produtos

						product.tableOfProducts(productList);

					} else if (people.getChoiceMenu() == 2 && people.getChoiceOptions() == 2) {
						//TODO Add ao carrinho

						do {

							System.out.print("Insira o código do Produto: ");
							identificator = input.nextInt();

						} while (product.validID(identificator) == false);
						
						index = productList.indexOf(identificator);
						
						//ERRO
						do {
							
							System.out.print("Insira a quantidade de produto: ");
							quantity = input.nextInt();
							
							
						}while(product.getStorage() >= quantity);

						//ERRO
						if (productList.contains(identificator) && productList.contains(product.getStorage() == quantity)) {
							//System.out.println("Não possui esse produto em estoque!");
						} else {
							//purchase.addToCart();
						}
						
						cart.add(purchase);

					} else if (people.getChoiceMenu() == 2 && people.getChoiceOptions() == 3) {
						// TODO Devolver Produto
						
						do {

							System.out.println("Insira o código do Produto: ");
							identificator = input.nextInt();

						} while (product.validID(identificator) == false);

						if (product.getStorage() < 0) {
							System.out.println("Não possui esse produto em estoque!");
						} else {
							purchase.addToCart();
						}

						purchase.throwAwayProduct();

					} else if (people.getChoiceMenu() == 2 && people.getChoiceOptions() == 4) {
						// TODO Finalizar Venda

						// purchase.finalizePurchase();

					} else if (people.getChoiceMenu() == 2 && people.getChoiceOptions() == 5) {
						// TODO Gera Nota Fiscal

					} else if (people.getChoiceMenu() == 2 && people.getChoiceOptions() == 6) {
						// Retorna ao Menu

						toMenu = true;
						toMenuPeople = false;
						toMenuWorker = false;
						toMenuCustomer = false;

					}
				}

			}

		}

	}

	public static void clearScreen() {
		System.out.println(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
