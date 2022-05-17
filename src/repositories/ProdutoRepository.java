package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Produto;

public class ProdutoRepository {

    private Map<String, Produto> catalogo;

    public ProdutoRepository(){
        this.catalogo = new HashMap<String, Produto>();
    };

    public void addProduto(Produto produto){
        this.catalogo.put(produto.getId(), produto);
    }

    public void atualizarProduto(String produtoID, String nome, String fabricante){
        if(!catalogo.containsKey(produtoID)){
            //donothing
        } 
        else{
            catalogo.get(produtoID).setNome(nome);
            catalogo.get(produtoID).setFabricante(fabricante);
        }
    };

    public void removerProduto(String produtoID){
        this.catalogo.remove(produtoID);
    };

    public Produto recuperaProduto(String produtoID){

        if(catalogo.containsKey(produtoID)){
            return catalogo.get(produtoID);
        }
        else{
            return null;
        }
        
    };

    public List<Produto> listarProdutos(){

        List<Produto> lista = catalogo.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return lista;

    };

    public List<Produto> getProdsByName(String nome){
        List<Produto> lista = catalogo.entrySet().stream().filter(s ->  s.getValue().getNome().toLowerCase().contains(nome.toLowerCase())).map(Map.Entry::getValue).collect(Collectors.toList());
        return lista;
    }
}
