package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment{
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    EditText pomodoroLength, breakLength, restLength;
    Spinner alertType;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        settings=getActivity().getSharedPreferences("Pomodoro Length", Context.MODE_PRIVATE);
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pomodoroLength = getView().findViewById(R.id.pmET);
        breakLength =getView().findViewById(R.id.brET);
        restLength =getView().findViewById(R.id.rsET);
        alertType=getView().findViewById(R.id.alertSP);
    }
}
