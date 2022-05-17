package models;
import java.util.UUID;

public class Produto {
	
	private String id;
	
	private String nome; 
	
	private String fabricante;

	public Produto(String nome, String fabricante) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.fabricante = fabricante;
	}
	
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getFabricante() {
		return fabricante;
	}
	
	public String toString() {
		return "Produto ID: " + getId() + " - Fabricante: " + getFabricante();
	}

	public void setNome(String nome2) {
		this.nome = nome2;
	}

    public void setFabricante(String fabricante2) {
		this.fabricante = fabricante2;
    }
}
