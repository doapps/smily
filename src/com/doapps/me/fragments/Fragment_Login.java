package com.doapps.me.fragments;

import java.util.Arrays;
import java.util.List;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.doapps.me.smily.R;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.model.GraphUser;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

public class Fragment_Login extends Fragment {

	private Dialog mDialog;
	private Context mContext;

	public final static Fragment_Login newInstance(){
		return new Fragment_Login();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_login,container,false);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();

		((Button) getView().findViewById(R.id.btn_login_facebook)).setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View view) {
				onLoginButtonClicked();
			}
		});

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	private void onLoginButtonClicked() {
		final ProgressDialog mDialog = showDialog(R.string.inciando_sesion);
		List<String> permissions = Arrays.asList("basic_info", "user_about_me","user_relationships", "user_birthday", "user_location");
		ParseFacebookUtils.logIn(permissions, getActivity(), new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				mDialog.dismiss();
				if (user == null) {
					Toast.makeText(mContext,"Uh oh. The user cancelled the Facebook login.", Toast.LENGTH_SHORT).show();
				} else if (user.isNew()) {
					Toast.makeText(mContext,"User signed up and logged in through Facebook!", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(mContext,"User logged in through Facebook!", Toast.LENGTH_SHORT).show();
					//showUserDetailsActivity();
				}
			}
		});
	}
	
	private void createFacebookUser() {
		Request.executeMeRequestAsync(ParseFacebookUtils.getSession(), new Request.GraphUserCallback() {
			@Override
			public void onCompleted(GraphUser user, Response response) {

				String facebookUsername = user.getUsername();
				ParseUser.getCurrentUser().setUsername(facebookUsername);
				ParseUser.getCurrentUser().setEmail((String)user.getProperty("email"));
				ParseUser.getCurrentUser().put("nombre",user.getFirstName());
				ParseUser.getCurrentUser().put("apellido",user.getLastName());
				ParseUser.getCurrentUser().put("cumpleanios",(String)user.getProperty("birthday"));
				ParseUser.getCurrentUser().saveInBackground();
			}
		});

		//toPrincipal();
	}
	
	private ProgressDialog showDialog(int stringId) {
		final ProgressDialog mDialog = new ProgressDialog(mContext);
		mDialog.show();
		mDialog.setContentView(R.layout.dialog_main);
		((TextView)mDialog.findViewById(R.id.txt_texto_dialog)).setText(stringId);
		mDialog.setCancelable(false);
		return mDialog;
	}
}