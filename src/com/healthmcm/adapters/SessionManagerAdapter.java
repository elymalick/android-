package com.healthmcm.adapters;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.healthmcm.controllers.Main;

public class SessionManagerAdapter {

	//on declare une preference qui stockera nous données
	SharedPreferences mesprefs;
	//on declare un editor pour ecrire le "content" sharedpreferences
	Editor editor;
	//un context d'appli
	Context context;
	//type d'enregistrement dans le content prefrencess
	int PRIVATE_MODE=0;
	//donner un nom à ma prefrences
	private String NOM_PREF="HealthMCM";

	// Ci-dessous les quelques variables que je stockerai dans mon conteneur de prefrences
	private static final String IS_LOGIN="isLogged";
	public static final String LOGIN="login";
	public static final String MDP="mdp";
	public static final String NOM_PATIENT="nom_patient";
	public static final String PRENOM_PATIENT="prenom_patient";

	//creation de la session et de l'editor
	public SessionManagerAdapter(Context context){
		this.context=context;
		mesprefs=context.getSharedPreferences(NOM_PREF, PRIVATE_MODE);
		editor=mesprefs.edit();
	}
	//fonction qui enregistre les données concernat le login
	public void createLoginSession(String login, String mdp){
		editor.putBoolean(IS_LOGIN, true);
		editor.putString(LOGIN, login);
		editor.putString(MDP, mdp);
		editor.commit();
	}
	//fonction qui recupere les données enregistrees concernant le login
	public HashMap<String, String> getLoginSessionData(){
		HashMap<String, String> data=new HashMap<String, String>();
		data.put(LOGIN, mesprefs.getString(LOGIN, null));
		data.put(MDP, mesprefs.getString(MDP, null));
		return data;
	}
	//fonction qui verifie si l'utilisateur est logue ou pas/ sinon on redirige vers le form de login
	public void VerifierLogin(){
		if( ! mesprefs.getBoolean(IS_LOGIN, false)){
			Intent i = new Intent(context, Main.class);
			//close all activities
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			//un flag pour demarrer une activitie
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
		}
	}

	public boolean VerifierConnection(){
		boolean res= mesprefs.getBoolean(IS_LOGIN, false);		 
		return res;
	}
	
	//fonction qui delogue un user
	public void Deconnecter(){
		editor.clear();
		editor.commit();
		Intent i = new Intent(context, Main.class);
		//close all activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		//un flag pour demarrer une activitie
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}
}
