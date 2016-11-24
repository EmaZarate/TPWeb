package Controlador;
import org.omg.CORBA.portable.ApplicationException;

import Data.*;
import Entidades.*;

public class ControladorJuego {
	Personaje personajeTurno,personajeTurnoOriginal,personajeNoTurno,personajeNoTurnoOriginal;
    DataPersonaje data = new DataPersonaje();
	
	
	
	public Personaje Buscar(Personaje p)
	{
		return data.getByID(p);
	}
	
	public void Seleccionar(Personaje p1,Personaje p2){
		personajeTurno=p1;
		personajeTurnoOriginal=data.getByID(personajeTurno);
		personajeNoTurno=p2;
		personajeNoTurnoOriginal=data.getByID(personajeNoTurno);
	}
	
	public boolean Atacar(int puntosDeEnergia)throws ApplicationException{
                personajeTurno.Atacar(puntosDeEnergia);
		return (personajeNoTurno.RecibirAtaque(puntosDeEnergia));
	}
	
	public void Defender(){
		personajeTurno.Defender(personajeTurnoOriginal.getEnergia(),personajeTurnoOriginal.getVida());
	}
	
	
	public void Turno(){
		Personaje aux=personajeTurno;
		personajeTurno=personajeNoTurno;
		personajeNoTurno=aux;
		aux=personajeTurnoOriginal;
		personajeTurnoOriginal=personajeNoTurnoOriginal;
		personajeNoTurnoOriginal=aux;
	}
	
	public void updateGanador(){
		data.updateGanador(personajeTurno);
	}
	public String getTurno(){
		return personajeTurno.getNombre();
	}
	
	public int getVidaJugadorAtacado(){
		return personajeNoTurno.getVida();
	}
	
}
