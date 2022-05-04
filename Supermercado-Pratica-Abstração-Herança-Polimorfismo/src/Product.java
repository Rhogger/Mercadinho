import java.util.ArrayList;

public class Product extends Supermarket {

	private String productName;
	public Double priceProduct;
	public int quantityProduct;
	public int ID = 1;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean validID(int item) {
		boolean valid = false;

		for (int i = 0; i < ID; i++) {

			if (item == ID) {
				valid = true;
			}
		}

		return valid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public void tableOfProducts(ArrayList<Product> productList) {

		// TODO implementar a quantidade do produto

		System.out.println("=-----------------------------------------=");
		for (Product product : productList) {

			System.out.println("Código: " + product.getID());
			System.out.println("Nome: " + product.getProductName());
			System.out.println("Preço: R$" + product.getPriceProduct());
			System.out.println("Seção: " + product.getSection());
			System.out.println("Em estoque: ");
			System.out.println("=-----------------------------------------=");

		}
		System.out.println();
	}

	public boolean consultProductInTable(ArrayList<Product> productList, int id) {

		boolean valid = false;

		for (Product product : productList) {

			if (product.getID() == id) {
				valid = true;
			}

		}

		return valid;

	}
}
