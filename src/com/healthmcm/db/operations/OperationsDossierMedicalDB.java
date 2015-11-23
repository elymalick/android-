package com.healthmcm.db.operations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.healthmcm.db.helper.SqlDossierMedicalHelper;
import com.healthmcm.models.DossierMedical;
import com.healthmcm.models.Patient;

public class OperationsDossierMedicalDB {
	
	private Context context;
	private SqlDossierMedicalHelper SqlDMAdapter;
	private SQLiteDatabase db;
	private Cursor cursor;

	//constructeur
	public OperationsDossierMedicalDB(Context context){
		this.context=context;
		SqlDMAdapter=new  SqlDossierMedicalHelper(context);
	}
	

	//open the db
	public OperationsDossierMedicalDB openDB(){
		db=SqlDMAdapter.getWritableDatabase();
		return this;
	}
	//fermer la base de données;
	public void closeDB(){
		db.close();
	}
	//supprimer tout dans la base de données
	public void TruncateDb(){
		db.execSQL("DELETE * FROM dossiersmedicaux");
	}
	//ajouter un utilisateur
	public boolean AjouterUnDossier(DossierMedical d, Integer idpatient){
		db=SqlDMAdapter.getWritableDatabase();
		ContentValues vals=new ContentValues();
		vals.put("id_patient",idpatient);
		vals.put("date_arrivee",d.getDate_Arrivee().toString());
		vals.put("date_sortie", d.getDate_Sortie().toString());
		vals.put("derniere_consultation", d.getDate_Derniere_Consultation().toString());
		vals.put("medecin_intervenant", d.getMedecin_intervenant().toString());
		vals.put("nombre_jours_sejour", d.getNombre_Jours_Sejour());
		vals.put("type_reglement", d.getType_Reglement());
		vals.put("etat_actuel_patient", d.getEtat_Actuel_Patient());
		vals.put("liste_medicament_administres", d.getListe_Medicament_Administres().toString());
		vals.put("maladie_soignee", d.getMaladie_Soignee());
		vals.put("alergies", d.getAlergies().toString());
		vals.put("type_sanguin", d.getType_Sanguin());		
		return db.insert("patients", null, vals)>0;//on insere le produit
	}

	//supprimer un utilisateur
	public boolean SupprimerUnDossier(DossierMedical dm){
		db=SqlDMAdapter.getWritableDatabase();
		return db.delete("dossiersmedicaux", "id_patient="+dm.getId_patient()+"and id_Dossier="+dm.getId_dossier(), null)>0;
	}
	
	//recuperer la liste des utilsiateurs
	public Cursor RecupererDossierPatient(Integer idpatient){
		db=SqlDMAdapter.getReadableDatabase();
		String req="select * from dossiersmedicaux where id_patient='"+idpatient+"'"; 
		cursor = db.rawQuery(req, null);
		return cursor;
	}
	//recuperer un utilisateur en fonction de son login et son mot de passe
	public boolean VerifierExistencePatient(Integer idpatient){
		db=SqlDMAdapter.getReadableDatabase();
		if(idpatient ==null){
			String request="Select * From dossiersmedicaux where id_patient = '" + idpatient+"'";
			cursor=db.rawQuery(request, null);
		}
		if(cursor.getCount()==0) return false;
		else return true;
	}
}
