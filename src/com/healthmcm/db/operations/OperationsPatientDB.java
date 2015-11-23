package com.healthmcm.db.operations;

import java.sql.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import com.healthmcm.db.helper.SqlPatientHelper;
import com.healthmcm.models.Patient;
import com.healthmcm.models.Utilisateur;

public class OperationsPatientDB {
	private Context context;
	private SqlPatientHelper SqlPartientAdapter;
	private SQLiteDatabase db;
	private Cursor cursor;

	//constructeur
	public OperationsPatientDB(Context context){
		this.context=context;
		SqlPartientAdapter=new  SqlPatientHelper(context);
	}
	

	//open the db
	public OperationsPatientDB openDB(){
		db=SqlPartientAdapter.getWritableDatabase();
		return this;
	}
	//fermer la base de données;
	public void closeDB(){
		db.close();
	}
	//supprimer tout dans la base de données
	public void TruncateDb(){
		db.execSQL("DELETE * FROM patients");
	}
	//ajouter un utilisateur
	public boolean AjouterUnPatient(Patient p){
		db=SqlPartientAdapter.getWritableDatabase();
		ContentValues vals=new ContentValues();
		vals.put("Idpatient", p.getIdpatient());
		vals.put("nom_patient",p.getNom());
		vals.put("prenom_patient", p.getPrenom());
		vals.put("data_naissaance", p.getDatenaissance().toString());
		vals.put("adresse", p.getAdresse());
		vals.put("email", p.getEmail().toString());
		vals.put("nb_securite_social", p.getNumeroSecuritesociale());
		vals.put("tel", p.getTelephone().toString());
		vals.put("tel_urgence", p.getTelephoneUrgence().toString());
		//vals.put("coord_gps", p.getCoordonnees_gps().toString());
		vals.put("nom_personne_tuteur", p.getNom_personne_tuteur().toString());
		vals.put("prenom_personne_tuteur", p.getPrenom_personne_tuteur());
		vals.put("tel_personne_tuteur", p.getTel_personne_tuteur().toString());
		return db.insert("patients", null, vals)>0;//on insere le produit
	}

	//supprimer un utilisateur
	public boolean SupprimerUnPatient(Patient p){
		db=SqlPartientAdapter.getWritableDatabase();
		return db.delete("patients", "nom_patient="+p.getNom()+"and prenom_patient="+p.getPrenom(), null)>0;
	}
	
	//recuperer la liste des utilsiateurs
	public Cursor RecupererListePatients(){
		db=SqlPartientAdapter.getReadableDatabase();
		cursor=db.query("patients", new String[]{"prenom_patient","nom_patient","date_naissance",
						"adresse", "nb_securite_social"}, //on recupere les resultat dans 
						null, null, null, null, null, null);//tableau de 3 champs qu'on lira avec
		return cursor;//a l'aide d'un cursor
	}
	//recuperer un utilisateur en fonction de son login et son mot de passe
	public boolean VerifierExistencePatient(String nom, String prenom, double nss){
		db=SqlPartientAdapter.getReadableDatabase();
		if(nom != null && prenom !=null){
			String request="Select * From patients where nom_patient = '" + nom +"'and prenom_patient='"
					+prenom+"' nb_securite_social='"+nss+"'";
			cursor=db.rawQuery(request, null);
		}
		if(cursor.getCount()==0) return false;
		else return true;
	}
}
