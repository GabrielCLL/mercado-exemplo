package services;

import repositories.LoteRepository;
import repositories.ProdutoRepository;

public class ProdutoService {

    ProdutoRepository catalogoProdutos; 
    LoteRepository catalogoLotes; 

    public ProdutoService(){
        this.catalogoProdutos = new ProdutoRepository();
        this.catalogoLotes = new LoteRepository();
    }

    

}
