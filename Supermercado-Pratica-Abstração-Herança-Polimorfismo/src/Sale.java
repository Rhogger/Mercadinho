import java.util.ArrayList;

public class Sale extends Product {
	
	//TODO criar método toString que retorne informações da nota fiscal

	private Double priceOfPurchase;

	public Double getPriceOfPurchase() {
		return priceOfPurchase;
	}

	@Override
	public Double getPriceProduct() {
		return priceProduct * 0.9;
	}

	public void finalizePurchase() {
		this.priceOfPurchase = this.quantityProduct * getPriceProduct();
	}

	public void throwAwayProduct() {
		if (this.quantityProduct > 0) {
			this.quantityProduct--;
		} else {
			System.out.println("Não tem produto no carrinho!");
		}
	}

	public void addToCart() {
		this.quantityProduct++;
	}

	public void productsInCart(ArrayList<Sale> cart) {

		for (Sale product : cart) {

			System.out.println("=-----------------------------------------=");
			System.out.println("Código: " + product.getID());
			System.out.println("Nome: " + product.getProductName());
		}
		System.out.println("Total: R$");
		System.out.println("=-----------------------------------------=");
	}
}
