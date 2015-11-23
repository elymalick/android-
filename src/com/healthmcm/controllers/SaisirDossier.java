package com.healthmcm.controllers;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthmcm.R;
import com.healthmcm.db.operations.OperationsPatientDB;
import com.healthmcm.models.Patient;

public class SaisirDossier extends Activity{

	private OperationsPatientDB dbo;
	private Context context;
	private EditText nomP, prenomP, datenaissP, adresseP, emailP, numeroSecuP, telP, telurgenceP, nomtuteurP, prenomtuteurP, teltuteurP;
	private Patient patient;
	private Dialog dialog;
	private Button cancel,save_user;
	private TextView msg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_create_patient);

		this.context=getApplicationContext();//set the context
		dialog=new Dialog(SaisirDossier.this);// Dilaog for show the errors
		dialog.setContentView(R.layout.layout_error_dialog);
		msg=(TextView)dialog.findViewById(R.id.error_message);
		cancel=(Button)dialog.findViewById(R.id.goback);
		//Get views attributes
		save_user=(Button)findViewById(R.id.enregistre_user);
		nomP=(EditText)findViewById(R.id.nom_Patient);
		prenomP=(EditText)findViewById(R.id.prenom_Patient);
		datenaissP=(EditText)findViewById(R.id.naissance_Patient);
		emailP=(EditText)findViewById(R.id.email_Patient);
		numeroSecuP=(EditText)findViewById(R.id.numero_secu_Patient);
		telP=(EditText)findViewById(R.id.NumeroTelphone_Patient);
		telurgenceP=(EditText)findViewById(R.id.TelephoneUrgence_Patient);
		nomtuteurP=(EditText)findViewById(R.id.nomTuteur_Patient);
		prenomtuteurP=(EditText)findViewById(R.id.prenomTuteur_Patient);
		teltuteurP=(EditText)findViewById(R.id.Telephone_Tuteur);

		dbo=new OperationsPatientDB(SaisirDossier.this); //instanciate the db accesseur
		dbo.openDB(); //open the db		

		//CANCEL BUTTON
		cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		// SAVE BUTTON
		save_user.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(nomP.getText().toString().trim().length()==0 ||  prenomP.getText().toString().trim().length()==0	||
						datenaissP.getText().length()==0 ||  emailP.getText().length()==0
						||  numeroSecuP.length()==0 || telP.length()==0
						|| telurgenceP.length()==0 ||nomtuteurP.length()==0
						|| prenomP.length()==0 || teltuteurP.length()==0)
				{
					msg.setText(" Tous les champs doivent etre remplis");
					dialog.setTitle("Loging Failed");
					dialog.setCancelable(true);
					dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,	R.drawable.emo_failed);
					dialog.show();
				}
				else{
					//patient = new Patient(idpatient, nom, prenom, datenaissance, adresse, email, numeroSecuritesociale, telephone, telephoneUrgence, nomper_sonner_tuteur, prenom_personne_tuteur, tel_personne_tuteur)
					patient = new Patient(nomP.getText().toString(),
							prenomP.getText().toString(), datenaissP.getText().toString(),	adresseP.getText().toString(),
							emailP.getText().toString(), numeroSecuP.getText().toString(),
							telP.getText().toString(), telurgenceP.getText().toString(), 
							nomtuteurP.getText().toString(), prenomtuteurP.getText().toString(),
							prenomtuteurP.getText().toString());

					//ajout a la bd du patient
					try{
						dbo.AjouterUnPatient(patient);
					}
					catch(Exception e){
						e.printStackTrace();
					}

				}
			}
		});

		//uilisation de tache asynchtask au lieu d'ajout direct:
		//comme ceci :

		/**
		 * save_user.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(nomP.getText().toString().trim().length()==0 ||  prenomP.getText().toString().trim().length()==0	||
						datenaissP.getText().length()==0 ||  emailP.getText().length()==0
						||  numeroSecuP.length()==0 || telP.length()==0
						|| telurgenceP.length()==0 ||nomtuteurP.length()==0
						|| prenomP.length()==0 || teltuteurP.length()==0)
				{
					msg.setText(" Tous les champs doivent etre remplis");
					dialog.setTitle("Loging Failed");
					dialog.setCancelable(true);
					dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,	R.drawable.emo_failed);
					dialog.show();
				}
				else{
					//appel de l'asynchTask ci-dessous
					AjouterPatientAsynTask th=new AjouterPatientAsynTask();
					th.execute();
				}
			});
		 */

	}

	// Cette classe est un AsyncTask()
	// tu peut l'utiliser comme ceci:
	/**
	private class AjouterPatientAsynTask extends AsyncTask{
		private ProgressDialog progress;
		@Override
		protected void onPostExecute() {
			//tu lance le progress dialog
			//progress.
		};
		@Override
		protected result doInBackground(Params... params) {
			// ici tu rajouter les données ds la base
			 //patient = new Patient(idpatient, nom, prenom, datenaissance, adresse, email, numeroSecuritesociale, telephone, telephoneUrgence, nomper_sonner_tuteur, prenom_personne_tuteur, tel_personne_tuteur)
					patient = new Patient(nomP.getText().toString(),
							prenomP.getText().toString(), datenaissP.getText().toString(),	adresseP.getText().toString(),
							emailP.getText().toString(), numeroSecuP.getText().toString(),
							telP.getText().toString(), telurgenceP.getText().toString(), 
							nomtuteurP.getText().toString(), prenomtuteurP.getText().toString(),
							prenomtuteurP.getText().toString());

					//ajout a la bd du patient
					try{
						dbo.AjouterUnPatient(patient);
					}
					catch(Exception e){
						e.printStackTrace();
					}
		}

	}
	 **/
}
