package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.Produto;
import repositories.LoteRepository;
import repositories.ProdutoRepository;

public class ProdutoService {

    private static ProdutoRepository catalogoProdutos; 
    private static LoteRepository catalogoLotes; 

    public ProdutoService(){
       catalogoProdutos = new ProdutoRepository();
       catalogoLotes = new LoteRepository();
    }

    public void addProduto(Produto produto) {
		addProdutoRepo(produto);
	}

    public List<Produto> listarProdByName(String nome){
        return getProdsByName(nome);
    }

    public List<Produto> listarProdsLoteByName(String nome) {
		return getProdsWithLoteByName(nome);
	}
   
    //metodos private - camada sem acesso direto

    private List<Produto> getProdsByName(String nome){

        List<Produto>  listOut = new ArrayList<Produto>(); 

        listOut =  catalogoProdutos.getProdsByName(nome);

        return listOut;
    }

    private List<Produto> getProdsWithLote() {

        List<Produto> listAux = new ArrayList<Produto>();

        catalogoLotes.listarLotes().stream().forEach( x -> {listAux.add(x.getProduto());});

        return listAux;
    }

    private List<Produto> getProdsWithLoteByName(String nome){
       
       
        List<Produto> listAux = getProdsWithLote();
        List<Produto> listProdutos = listAux.stream().filter(x -> x.getNome().toLowerCase().contains(nome.toLowerCase())).collect(Collectors.toList());

        return listProdutos;

    }
    private void addProdutoRepo(Produto produto){
        catalogoProdutos.addProduto(produto);
    }


}
