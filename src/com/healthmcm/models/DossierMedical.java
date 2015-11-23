package com.healthmcm.models;

import java.sql.Date;
import java.util.ArrayList;

public class DossierMedical {

	private int Id_patient;
	private int Id_dossier;
	private Date Date_Arrivee;
	private Date Date_Sortie;
	private Date Date_Derniere_Consultation;
	private ArrayList<Maladie> Liste_Antecedent_Medicaux;
	private ArrayList<String> Medicaments_Administres;	
	private ArrayList<Medecin> Medecin_intervenant;
	private int Nombre_Jours_Sejour;
	private String Type_Reglement;
	private String Etat_Actuel_Patient;
	private ArrayList<String> Liste_Medicament_Administres;
	private String Maladie_Soignee;
	private ArrayList<String> Alergies;
	private String Type_Sanguin;
	
	
	public DossierMedical(int id_patient, int id_dossier, Date date_Arrivee,
			Date date_Sortie, Date date_Derniere_Consultation,
			ArrayList<Maladie> liste_Antecedent_Medicaux,
			ArrayList<String> medicaments_Administres,
			ArrayList<Medecin> medecin_intervenant, int nombre_Jours_Sejour,
			String type_Reglement, String etat_Actuel_Patient,
			ArrayList<String> liste_Medicament_Administres,
			String maladie_Soignee, ArrayList<String> alergies,
			String type_Sanguin) {
		super();
		Id_patient = id_patient;
		Id_dossier = id_dossier;
		Date_Arrivee = date_Arrivee;
		Date_Sortie = date_Sortie;
		Date_Derniere_Consultation = date_Derniere_Consultation;
		Liste_Antecedent_Medicaux = liste_Antecedent_Medicaux;
		Medicaments_Administres = medicaments_Administres;
		Medecin_intervenant = medecin_intervenant;
		Nombre_Jours_Sejour = nombre_Jours_Sejour;
		Type_Reglement = type_Reglement;
		Etat_Actuel_Patient = etat_Actuel_Patient;
		Liste_Medicament_Administres = liste_Medicament_Administres;
		Maladie_Soignee = maladie_Soignee;
		Alergies = alergies;
		Type_Sanguin = type_Sanguin;
	}



	public DossierMedical(int id_patient, int id_dossier, Date date_Arrivee,
			Date date_Sortie, Date date_Derniere_Consultation,
			String type_Reglement, String maladie_Soignee,
			ArrayList<String> alergies) {
		super();
		Id_patient = id_patient;
		Id_dossier = id_dossier;
		Date_Arrivee = date_Arrivee;
		Date_Sortie = date_Sortie;
		Date_Derniere_Consultation = date_Derniere_Consultation;
		Type_Reglement = type_Reglement;
		Maladie_Soignee = maladie_Soignee;
		Alergies = alergies;
	}
	
	
	
	public ArrayList<Medecin> getMedecin_intervenant() {
		return Medecin_intervenant;
	}

	public void setMedecin_intervenant(ArrayList<Medecin> medecin_intervenant) {
		Medecin_intervenant = medecin_intervenant;
	}

	public int getId_patient() {
		return Id_patient;
	}

	public void setId_patient(int id_patient) {
		Id_patient = id_patient;
	}

	public int getId_dossier() {
		return Id_dossier;
	}

	public void setId_dossier(int id_dossier) {
		Id_dossier = id_dossier;
	}

	public Date getDate_Arrivee() {
		return Date_Arrivee;
	}

	public void setDate_Arrivee(Date date_Arrivee) {
		Date_Arrivee = date_Arrivee;
	}

	public Date getDate_Sortie() {
		return Date_Sortie;
	}

	public void setDate_Sortie(Date date_Sortie) {
		Date_Sortie = date_Sortie;
	}

	public Date getDate_Derniere_Consultation() {
		return Date_Derniere_Consultation;
	}

	public void setDate_Derniere_Consultation(Date date_Derniere_Consultation) {
		Date_Derniere_Consultation = date_Derniere_Consultation;
	}

	public ArrayList<Maladie> getListe_Antecedent_Medicaux() {
		return Liste_Antecedent_Medicaux;
	}

	public void setListe_Antecedent_Medicaux(
			ArrayList<Maladie> liste_Antecedent_Medicaux) {
		Liste_Antecedent_Medicaux = liste_Antecedent_Medicaux;
	}

	public ArrayList<String> getMedicaments_Administres() {
		return Medicaments_Administres;
	}

	public void setMedicaments_Administres(ArrayList<String> medicaments_Administres) {
		Medicaments_Administres = medicaments_Administres;
	}

	public int getNombre_Jours_Sejour() {
		return Nombre_Jours_Sejour;
	}

	public void setNombre_Jours_Sejour(int nombre_Jours_Sejour) {
		Nombre_Jours_Sejour = nombre_Jours_Sejour;
	}

	public String getType_Reglement() {
		return Type_Reglement;
	}

	public void setType_Reglement(String type_Reglement) {
		Type_Reglement = type_Reglement;
	}

	public String getEtat_Actuel_Patient() {
		return Etat_Actuel_Patient;
	}

	public void setEtat_Actuel_Patient(String etat_Actuel_Patient) {
		Etat_Actuel_Patient = etat_Actuel_Patient;
	}

	public ArrayList<String> getListe_Medicament_Administres() {
		return Liste_Medicament_Administres;
	}

	public void setListe_Medicament_Administres(
			ArrayList<String> liste_Medicament_Administres) {
		Liste_Medicament_Administres = liste_Medicament_Administres;
	}

	public String getMaladie_Soignee() {
		return Maladie_Soignee;
	}

	public void setMaladie_Soignee(String maladie_Soignee) {
		Maladie_Soignee = maladie_Soignee;
	}

	public ArrayList<String> getAlergies() {
		return Alergies;
	}

	public void setAlergies(ArrayList<String> alergies) {
		Alergies = alergies;
	}

	public String getType_Sanguin() {
		return Type_Sanguin;
	}

	public void setType_Sanguin(String type_Sanguin) {
		Type_Sanguin = type_Sanguin;
	}
	
	
}
