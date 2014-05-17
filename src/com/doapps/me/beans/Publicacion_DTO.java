package com.doapps.me.beans;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Publicaciones")
public class Publicacion_DTO extends ParseObject {

	public Publicacion_DTO() {}

	public String getSenderId() {
		return getString("senderId");
	}
	public ParseFile getImagen() {
		return getParseFile("imagen");
	}
	public String getDescripcion() {
		return getString("descripcion");
	}
	public int getEntidadId() {
		return getInt("entidadId");
	}
	public String getFacebookId() {
		return getString("facebookId");
	}
	public void setSenderId(String senderId) {
		put("senderId", senderId);
	}
	public void setImagen(ParseFile imagen) {
		put("imagen", imagen);
	}
	public void setDescripcion(String descripcion) {
		put("descripcion", descripcion);
	}
	public void setEntidadId(int entidadId) {
		put("entidadId", entidadId);
	}
	public void setFacebookId(String facebookId) {
		put("facebookId", facebookId);
	}
}
