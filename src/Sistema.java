import models.Lote;
import models.Produto;
import repositories.LoteRepository;
import repositories.ProdutoRepository;

public class Sistema {

	public static void main(String[] args) {
		
		//Produtos
		Produto produto = new Produto("Leite", "Parmalat");	
		Produto produto1 = new Produto("Iogurte", "Cariri");

		//Lotes
		Lote lote = new Lote(produto, 10L);
		Lote lote1 = new Lote(produto1, 30L);

		//Repositorios
		ProdutoRepository catalogoProdutos = new ProdutoRepository();
		catalogoProdutos.addProduto(produto);
		catalogoProdutos.addProduto(produto1);
		
		LoteRepository catalogoLotes = new LoteRepository();
		catalogoLotes.addLote(lote);
		catalogoLotes.addLote(lote1);

		//Saida
		System.out.println(catalogoProdutos.listarProdutos());
		System.out.println(catalogoLotes.listarLotes());
	}
}
