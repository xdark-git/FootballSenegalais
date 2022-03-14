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
 * Use the {@link ResultatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultatsFragment extends Fragment {
    private ListView listResults;
    private String[] tabResults, tabDetaisResults;
    private String details,results;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_resultats, container, false);
        listResults = view.findViewById(R.id.listResults);
        tabResults = view.getResources().getStringArray(R.array.tab_results);
        tabDetaisResults=view.getResources().getStringArray(R.array.tab_detailsResluts);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,tabResults);
        listResults.setAdapter(adapter);
        listResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                results=tabResults[position];
                details=tabDetaisResults[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.drawable.ic_launcher_foreground);
                dialog.setTitle(results);
                dialog.setMessage(details);
                dialog.setNegativeButton(R.string.back, null);
                dialog.show();
            }
        });
        return view;
    }
}