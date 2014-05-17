package com.doapps.me.application;

import android.app.Application;

import com.doapps.me.beans.Entidad_DTO;
import com.doapps.me.beans.Publicacion_DTO;
import com.doapps.me.beans.Usuario_DTO;
import com.doapps.me.smily.R;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class Main_Application extends Application {

	//Parse.com
	private static final String APLICATION_ID = "Klkg2IneFW9pYcSpoM5Uvi3UwTap838f2lmp5C1b";
	private static final String CLIENT_KEY = "1uFL9BwARIEY5sj4jgLnW9bgiqdowWyGmoEats5x";

	@Override
	public void onCreate() {
		super.onCreate();

		ParseObject.registerSubclass(Entidad_DTO.class);
		ParseObject.registerSubclass(Publicacion_DTO.class);
		ParseObject.registerSubclass(Usuario_DTO.class);

		Parse.initialize(this,APLICATION_ID,CLIENT_KEY);
		ParseFacebookUtils.initialize(getString(R.string.app_id));

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
	}
}
