package com.example.footballsenegalais;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetFragment extends Fragment {
    private ListView listMeet;
    private String[] tabMeet, tabDetails;
    private String meet, details;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_meet, container, false);
        listMeet=view.findViewById(R.id.listMeet);
        tabMeet=view.getResources().getStringArray(R.array.tab_meet);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,tabMeet);
        listMeet.setAdapter(adapter);
        return view;
    }
}