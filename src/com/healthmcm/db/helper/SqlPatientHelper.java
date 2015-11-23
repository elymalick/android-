package com.healthmcm.db.helper;

import java.sql.Date;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public class SqlPatientHelper extends SQLiteOpenHelper{

	private static final String Patient_table="patients";
	private static final int DATABASE_VERSION = 1;
	private static final String tag_Idpatient = "id_patient";
	private static final String tag_Nom="nom_patient";
	private static final String tag_Prenom="prenom_patient";
	private static final String tag_Datenaissance="date_naissance";
	private static final String tag_Adresse="adresse";
	private static final String tag_Email="email";
	private static final String tag_NumeroSecuritesociale="nb_securite_social";
	private static final String tag_Telephone="tel";
	private static final String tag_TelephoneUrgence="tel_urgence";
	private static final String tag_Coordonnees_gps="coord_gps";
	private static final String tag_Nom_personner_tuteur="nom_personne_tuteur";
	private static final String tag_Prenom_personne_tuteur="prenom_personne_tuteur";
	private static final String tag_Tel_personne_tuteur="tel_personne_tuteur";
	
	private static final String create_table_patient=
			"create table"+Patient_table+"("
			+ tag_Idpatient + " integer primary key autoincrement, " 
			+ tag_Nom + " text not null,"
			+ tag_Prenom + " text not null,"
			+ tag_Datenaissance + " text not null,"
			+ tag_Adresse +" text not null,"
			+ tag_Email + " text,"
			+ tag_NumeroSecuritesociale + " text not null,"
			+ tag_Telephone + " text not null,"
			+ tag_TelephoneUrgence +" text,"
			+ tag_Coordonnees_gps  + " text,"
			+ tag_Nom_personner_tuteur + " text,"
			+ tag_Prenom_personne_tuteur +" text,"
			+ tag_Tel_personne_tuteur + " text"
			+");";
	
	
	public SqlPatientHelper(Context context){
		super(context, Patient_table, null, DATABASE_VERSION);
	}	
	/**
	 * Creation de la base de données 
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(create_table_patient);
	}
	/**
	 * Suppression de la base de données et réecreation
	 */	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldveriob, int newversion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop table if exists"+ this.Patient_table); //on supprime la table patient
		onCreate(db);//on la recrée
	}

}
