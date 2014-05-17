package com.doapps.me.beans;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Usuarios")
public class Usuario_DTO extends ParseObject{

	public Usuario_DTO() {}
	
	public String getNombres() {
		return getString("nombres");
	}

	public String getFrase() {
		return getString("frase");
	}

	public String getFacebookId() {
		return getString("facebookId");
	}

	public int getCantidad_fotos() {
		return getInt("cantidad_fotos");
	}

	public int getCantidad_amigos() {
		return getInt("cantidad_amigos");
	}

	public void setNombres(String nombres) {
		put("nombres", nombres);
	}

	public void setFrase(String frase) {
		put("frase", frase);
	}

	public void setFacebookId(String facebookId) {
		put("facebookId", facebookId);
	}

	public void setCantidad_fotos(int cantidad_fotos) {
		put("cantidad_fotos", cantidad_fotos);
	}

	public void setCantidad_amigos(int cantidad_amigos) {
		put("cantidad_amigos", cantidad_amigos);
	}
}
