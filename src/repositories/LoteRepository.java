package repositories;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Lote;

public class LoteRepository {

    private Map<String, Lote> catalogo ;
    
    public LoteRepository(){
        this.catalogo = new HashMap<String, Lote>();
    }

    public void addLote(Lote lote) {
        this.catalogo.put(lote.getId(), lote);
    }

    public void removerLote(String loteID){
        this.catalogo.remove(loteID);
    };

    public void atualizarLote(String loteID, Date dataFabricacao, Date dataValidade, Long quantidade){
        if(!catalogo.containsKey(loteID)){
            //donothing
        } 
        else{
            catalogo.get(loteID).setDataFabricacao(dataFabricacao);
            catalogo.get(loteID).setDataValidade(dataValidade);
            catalogo.get(loteID).setQuantidade(quantidade);
        }
    };

    public Lote recuperaLote(String loteID){

        if(catalogo.containsKey(loteID)){
            return catalogo.get(loteID);
        }
        else{
            return null;
        }
        
    };

    public List<Lote> listarLotes(){

        List<Lote> lista = catalogo.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return lista;

    };


}
