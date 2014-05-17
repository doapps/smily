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
import android.view.ViewGroup;
import android.widget.Toast;

import com.doapps.me.smily.Main;
import com.doapps.me.smily.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

public class Fragment_Login extends Fragment {

	private Dialog progressDialog;
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
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	private void onLoginButtonClicked() {
		List<String> permissions = Arrays.asList("basic_info", "user_about_me","user_relationships", "user_birthday", "user_location");
		ParseFacebookUtils.logIn(permissions, getActivity(), new LogInCallback() {
			@Override
			public void done(ParseUser user, ParseException err) {
				progressDialog.dismiss();
				if (user == null) {
					Toast.makeText(mContext,"Uh oh. The user cancelled the Facebook login.", Toast.LENGTH_SHORT).show();
				} else if (user.isNew()) {
					Toast.makeText(mContext,"User signed up and logged in through Facebook!", Toast.LENGTH_SHORT).show();
					//showUserDetailsActivity();
				} else {
					Toast.makeText(mContext,"User logged in through Facebook!", Toast.LENGTH_SHORT).show();
					//showUserDetailsActivity();
				}
			}
		});
	}
}