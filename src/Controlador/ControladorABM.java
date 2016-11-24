package Controlador;
import java.util.ArrayList;

import org.omg.CORBA.portable.ApplicationException;

import Data.DataPersonaje;

import Entidades.*;

public class ControladorABM {
	
	ArrayList<Personaje> arrayPer = new ArrayList<Personaje>();
	
	private Data.DataPersonaje dataPer;
	
	public ControladorABM()
	{   
		
		dataPer=new DataPersonaje();
	/*	Personaje p = new Personaje();
		p.setAtaque(3);
		p.setDefensa(4);
		p.setEnergia(13);
		p.setEvasion(2);
		p.setNombre("Super Man");
		p.setId(1);
		arrayPer.add(p);*/
		
			
	}	
	
	public void agregar(Personaje p)throws ApplicationException{
		dataPer.add(p);
	}
	
	
	public Personaje Buscar(Personaje per)
	{
		/*Personaje personaje=null;
		for(Personaje p: arrayPer)
			{
				if(per.getId()==p.getId()){
					personaje=p;
				}
			}
		return personaje;*/
		return dataPer.getByID(per);
	}
	
	public void Modificar(Personaje per)throws ApplicationException{
		/*if(arrayPer.contains(per)){
		Personaje perEnc=this.Buscar(per);
		perEnc.setId(per.getId());
		perEnc.setNombre(per.getNombre());
		perEnc.setEnergia(per.getEnergia());
		perEnc.setAtaque(per.getAtaque());
		perEnc.setDefensa(per.getDefensa());
		perEnc.setEvasion(per.getEvasion());
		//perEnc.setTotalRestante(per.getTotalRestante());*/
		dataPer.update(per);
		
		
	}
	
	public void Eliminar(Personaje p)
	{
		/*if(arrayPer.contains(p)){
		Personaje perEnc=this.Buscar(p);
		arrayPer.remove(perEnc);
		}*/
		dataPer.delete(p);;
	}
}





