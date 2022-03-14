package com.example.footballsenegalais;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeamsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamsFragment extends Fragment {
    private ListView listTeams;
    private String [] tabTeams, tabDetails;
    private String teams, details;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_teams, container, false);
        listTeams= view.findViewById(R.id.listTeams);//charger liste des equipes
        //recuperer la liste des tableaux
        tabTeams=getResources().getStringArray(R.array.tab_teams);
        tabDetails=getResources().getStringArray(R.array.tab_details);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item,tabTeams);
        listTeams.setAdapter(adapter);//chargement des données
        listTeams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //recuperation des donnees de teams
                teams=tabTeams[position];
                details=tabDetails[position];
                //Affichage des donnees
                AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.drawable.ic_launcher_foreground);
                dialog.setTitle(teams);
                dialog.setMessage(details);
                dialog.setNegativeButton(R.string.back, null);
                dialog.show();
            }
        });
        return view;
    }
}