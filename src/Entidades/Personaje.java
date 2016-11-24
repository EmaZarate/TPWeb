package Entidades;
import java.io.Serializable;
import java.util.Random;

public class Personaje implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5726014092518557481L;
	String nombre;
	int energia,vida,defensa,evasion,id,puntos;
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
	
	@Override
	public boolean equals(Object per){
		return per instanceof Personaje && ((Personaje)per).getId() == this.getId();
	}
	
	
	public boolean RecibirAtaque(int PuntosDeEnergia){
		boolean evadio=true;
		Random rnd = new Random();
		int numAle=(int)(rnd.nextDouble()*100);
		
		if(numAle>getEvasion()){
		this.vida=this.vida-PuntosDeEnergia;
		evadio=false;
		}
		
		return evadio;
	}
	
	public void Atacar(int PuntosDeEnergia)
	{
		this.energia=this.energia-PuntosDeEnergia;
	}
	
	public void Defender(int energia,int vida) {
		this.energia=this.energia+(energia*this.defensa/100);
		if(this.energia>energia){
			this.energia=energia;
		}
		
		this.vida=this.vida+(vida*this.defensa/100);
		if(this.vida>vida){
			this.vida=vida;
		}
		
	}

}
