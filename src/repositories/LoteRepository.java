package repositories;

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

    public void atualizarLote(String loteID, Lote novoLote){
        this.catalogo.replace(loteID, novoLote);
    };

    public Lote recuperaLote(String loteID){
        return this.catalogo.get(loteID);
    };

    public List<Lote> listarLotes(){

        List<Lote> lista = catalogo.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        return lista;

    };


}
