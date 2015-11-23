package com.healthmcm.models;

import java.sql.Date;

import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

public class Patient {

	private String Idpatient;
	private String Nom;
	private String Prenom;
	private String Datenaissance;
	private String Adresse;
	private String Email;
	private String NumeroSecuritesociale;
	private String Telephone;
	private String TelephoneUrgence;
	private String Nom_personne_tuteur;
	private String Prenom_personne_tuteur;
	private String Tel_personne_tuteur;





	public Patient(String nom, String prenom,	String datenaissance, String adresse,
			String email,		String numeroSecuritesociale,
			String telephone,String telephoneUrgence,	String nompersonner_tuteur, String prenom_personne_tuteur,
			String tel_personne_tuteur) {		
		super();
		Nom = nom;
		Prenom = prenom;
		Datenaissance = datenaissance;
		Adresse = adresse;
		Email = email;
		NumeroSecuritesociale = numeroSecuritesociale;
		Telephone = telephone.toString();
		TelephoneUrgence = telephoneUrgence;
		//Coordonnees_gps = coordonnees_gps;
		Nom_personne_tuteur = nompersonner_tuteur;
		Prenom_personne_tuteur = prenom_personne_tuteur;
		Tel_personne_tuteur = tel_personne_tuteur;
	}





	public String getIdpatient() {
		return Idpatient;
	}





	public void setIdpatient(String idpatient) {
		Idpatient = idpatient;
	}





	public String getNom() {
		return Nom;
	}





	public void setNom(String nom) {
		Nom = nom;
	}





	public String getPrenom() {
		return Prenom;
	}





	public void setPrenom(String prenom) {
		Prenom = prenom;
	}





	public String getDatenaissance() {
		return Datenaissance;
	}





	public void setDatenaissance(String datenaissance) {
		Datenaissance = datenaissance;
	}





	public String getAdresse() {
		return Adresse;
	}





	public void setAdresse(String adresse) {
		Adresse = adresse;
	}





	public String getEmail() {
		return Email;
	}





	public void setEmail(String email) {
		Email = email;
	}





	public String getNumeroSecuritesociale() {
		return NumeroSecuritesociale;
	}





	public void setNumeroSecuritesociale(String numeroSecuritesociale) {
		NumeroSecuritesociale = numeroSecuritesociale;
	}





	public String getTelephone() {
		return Telephone;
	}





	public void setTelephone(String telephone) {
		Telephone = telephone;
	}





	public String getTelephoneUrgence() {
		return TelephoneUrgence;
	}





	public void setTelephoneUrgence(String telephoneUrgence) {
		TelephoneUrgence = telephoneUrgence;
	}





	public String getNom_personne_tuteur() {
		return Nom_personne_tuteur;
	}





	public void setNom_personne_tuteur(String nom_personner_tuteur) {
		Nom_personne_tuteur = nom_personner_tuteur;
	}





	public String getPrenom_personne_tuteur() {
		return Prenom_personne_tuteur;
	}





	public void setPrenom_personne_tuteur(String prenom_personne_tuteur) {
		Prenom_personne_tuteur = prenom_personne_tuteur;
	}





	public String getTel_personne_tuteur() {
		return Tel_personne_tuteur;
	}





	public void setTel_personne_tuteur(String tel_personne_tuteur) {
		Tel_personne_tuteur = tel_personne_tuteur;
	}
	
	
	
}
