package services;


import java.util.List;

import models.Produto;
import models.Lote;
import repositories.LoteRepository;
import repositories.ProdutoRepository;

public class Services {

    private static ProdutoRepository catalogoProdutos; 
    private static LoteRepository catalogoLotes; 

    private ProdutoService produtoService;
    private LoteService loteService;

    public Services(){
       catalogoProdutos = new ProdutoRepository();
       catalogoLotes = new LoteRepository();
       setServices(catalogoProdutos, catalogoLotes);
    }

    private void setServices(ProdutoRepository catalogoProdutos, LoteRepository catalogoLotes){
        this.produtoService = new ProdutoService(catalogoProdutos, catalogoLotes);
        this.loteService = new LoteService(catalogoProdutos, catalogoLotes);
    }

    public void addProduto(Produto produto) {
		produtoService.addProduto(produto);
	}

    public void addLote(Lote lote){
        loteService.addLote(lote);
    }

    public List<Produto> listarProdByName(String nome){
        return produtoService.listarProdByName(nome);
    }

    public List<Produto> listarProdsLoteByName(String nome) {
		return produtoService.listarProdsLoteByName(nome);
	}
   

}
