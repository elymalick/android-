package com.healthmcm.controllers;
import com.example.healthmcm.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ResultatsRecherche extends Fragment{

	@Override													   //Method implements action to do when view printed
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View vue=inflater.inflate(R.layout.layout_resultats_recherche, container, false);
		return vue;
	}
}
