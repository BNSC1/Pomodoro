package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    public EditText pomodoroLength, breakLength, restLength;
    Spinner alertType;
    SharedPreferences settings=getActivity().getSharedPreferences("Pomodoro Length", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=settings.edit();
    public static Context context;
    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        context=getActivity().getApplicationContext();

    }
    public static Context getaContext(){return context;}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        settings=getActivity().getSharedPreferences("Pomodoro Length", Context.MODE_PRIVATE);

        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pomodoroLength =(EditText) getView().findViewById(R.id.pmET);
        breakLength =(EditText) getView().findViewById(R.id.brET);
        restLength =(EditText) getView().findViewById(R.id.rsET);
        alertType=(Spinner) getView().findViewById(R.id.alertSP);

        pomodoroLength.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putInt("Pomodoro Length", Integer.parseInt(pomodoroLength.getText().toString()));
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
