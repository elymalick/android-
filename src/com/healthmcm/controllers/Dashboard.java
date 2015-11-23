package com.healthmcm.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.healthmcm.R;
import com.healthmcm.adapters.SessionManagerAdapter;



public class Dashboard extends Activity{

	private SessionManagerAdapter session;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_dashboard);
		Button consultdossier=(Button)findViewById(R.id.consulter_dossier);//get consult dossier button
		consultdossier.setOnClickListener(new OnClickListener(){//listen to the buttons actions
			@Override
			public void onClick(View v) {
				Intent i=new Intent(Dashboard.this,ConsulterDossier.class);
				startActivity(i);
				
			}	        	
		});
		
		((ImageButton)findViewById(R.id.action_deconnecter)).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				session= new SessionManagerAdapter(getApplicationContext());
				session.Deconnecter();
			}
		});
		// Bouton pour acces a la page saisir dossier 
		Button createpatient=(Button)findViewById(R.id.saisir_dossier);//get consult dossier button
		createpatient.setOnClickListener(new OnClickListener(){//listen to the buttons actions
			@Override
			public void onClick(View v) {
				Intent i=new Intent(Dashboard.this,SaisirDossier.class);
				startActivity(i);
				
			}	        	
		});	    
		//---------------------------------------------------------------
		Bundle b=getIntent().getExtras();
		TextView nlu=(TextView)findViewById(R.id.nom_ou_login_user);
		TextView mdp_prenom=(TextView)findViewById(R.id.mdp_prenom_user);
		nlu.setText(b.getString("login"));
		mdp_prenom.setText(b.getString("mdp"));
		//---------------------------------------------------------------
	}
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){
		//recuperer ici les valeurs enregistres dans onSaveInstanceState
	}

	/**
	 * cette methode sert a sauvegarder les données de la vue au moment de la destruction
	 * de l'activite en question.
	 * Les données sont enregistrées dans le bundle sous de cle-valeur.
	 * 
	 * dans la methode onCreate() : on pourrait recuperer les valeurs sauvegardes lors de la 
	 * derniere destrcution de l'activité, en faisant:
	 * 
	 * if(savedInstanceState != null).
	 * 
	 * Mais au lieu de faire ça on peut :
	 * Appeller tout simplement la methode :
	 * onRestoreInstanceState(Bundle savedInstanceState), pour récuperer les valeurs 
	 * enregistrées dans onSaveInstanceState().
	 * 
	 */
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);

		//enregistrer ici les valeurs à récuperer prochainement lors de la recreation
		//de l'activite par : onCreate(), ou onRestoreInstanceState()
	}
	// GERER L'ACTOIN BAR DE L ACTIVITE CONSULTE DOSSIER
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.menu_consulte_dossier, menu);
		return true;		
	}

	// GESTION DES CLISQUES SUR LES ITEMS DU MENU
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.action_refresh:
			break;
		case R.id.action_settings:
			break;
		default:
			break;
		}
		return true;
	}
}
