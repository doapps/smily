package com.doapps.me.beans;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Entidades")
public class Entidad_DTO extends ParseObject {

	public Entidad_DTO() {}
	
	public String getNombre() {
		return getString("nombre");
	}
	public int getTipo() {
		return getInt("tipo");
	}
	public int getCantidad() {
		return getInt("cantidad");
	}
	public void setNombre(String nombre) {
		put("nombre", nombre);
	}
	public void setTipo(int tipo) {
		put("tipo", tipo);
	}
	public void setCantidad(int cantidad) {
		put("cantidad", cantidad);
	}	
}
