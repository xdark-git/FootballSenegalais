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

public class HelpFragment extends Fragment {
    private ListView listHelp;
    private String[] tabHelp, tabHelpDetails;
    String help, details;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_help_fragment, container, false);
        listHelp=view.findViewById(R.id.listHelp);
        tabHelp=view.getResources().getStringArray(R.array.help);
        tabHelpDetails=view.getResources().getStringArray(R.array.helpDetails);
        ArrayAdapter <String>adapter=new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,tabHelp);
        listHelp.setAdapter(adapter);
        listHelp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                help=tabHelp[position];
                details=tabHelpDetails[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.drawable.ic_launcher_foreground);
                dialog.setTitle(help);
                dialog.setMessage(details);
                dialog.setNegativeButton(R.string.back,null);
                dialog.show();
            }
        });
        return view;
    }
}