package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Lote;
import repositories.LoteRepository;
import repositories.ProdutoRepository;

public class LoteService {

    private LoteRepository catalogoLotes; 
    private ProdutoRepository catalogoProdutos;

    public LoteService(ProdutoRepository catalogoProdutos, LoteRepository catalogoLotes){
        this.catalogoProdutos = catalogoProdutos;
        this.catalogoLotes = catalogoLotes;
    }

    public void addLote(Lote lote) {
		addLoteRepo(lote);
	}

    public List<Lote> listarLotes(){
        return getLotes();
    }


    private List<Lote> getLotes() {
        return catalogoLotes.listarLotes();
    }

    private void addLoteRepo(Lote lote) {
        catalogoLotes.addLote(lote);
    }

    

}
