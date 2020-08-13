package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class PomodoroFragment extends Fragment implements View.OnClickListener {
    private static Vibrator vibrator;
    private long[] vibratepattern={1000,500,500};
    private CountDownTimer cTimer = null;
    private TextView TimeTV;
    private Button TomatoBT, RestBT, BreakBT, StopBT;
    private SharedPreferences settings;
    public DBAdapter helper;
    public PomodoroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        helper=new DBAdapter(getActivity());
        settings= this.requireActivity().getSharedPreferences("Pomodoro Length", Context.MODE_PRIVATE);
        return inflater.inflate(R.layout.fragment_pomodoro, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vibrator = (Vibrator) requireActivity().getSystemService(Context.VIBRATOR_SERVICE);
//        getActivity().setContentView(R.layout.fragment_pomodoro);
        TomatoBT = (Button) getActivity().findViewById(R.id.TomatoBT);
        TomatoBT.setOnClickListener(this); // calling onClick() method
        RestBT = (Button) getActivity().findViewById(R.id.RestBT);
        RestBT.setOnClickListener(this);
        BreakBT = (Button) getActivity().findViewById(R.id.BreakBT);
        BreakBT.setOnClickListener(this);
        StopBT = (Button) getActivity().findViewById(R.id.StopBT);
        StopBT.setOnClickListener(this);
        TimeTV=(TextView) getActivity().findViewById(R.id.TimeTV);
    }

    @Override
    public void onClick(View v) {
        vibrator.vibrate(15);
        switch(v.getId()){
            case R.id.BreakBT:
                cancelTimer();
                startTimer(settings.getString("Break Length","5"));
                hideStartButton();
                break;
            case R.id.RestBT:
                cancelTimer();
                startTimer(settings.getString("Rest Length","30"));
                hideStartButton();
                break;
            case R.id.TomatoBT:
                cancelTimer();
                startTimer(settings.getString("Pomodoro Length","25"));
                hideStartButton();
                break;
            case R.id.StopBT:
                cancelTimer();
                hideStopButton();
                break;
        }
    }
    private void startTimer(String time) {
        int mtime=Integer.parseInt(time)*60;
        cTimer = new CountDownTimer(mtime*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                long m=millisUntilFinished/1000/60;
                long s=(millisUntilFinished/1000-m*60);
                if (s>=10) {TimeTV.setText(m+":"+s);}
                else {TimeTV.setText(m+":0"+s);}

            }
            public void onFinish() {
                TimeTV.setText(R.string.finish);

                vibrator.vibrate(vibratepattern,-1);
                //hideStopButton();
            }
        };
        cTimer.start();
    }
    private void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
        vibrator.cancel();
        hideStopButton();
    }
    private void hideStartButton(){
        TomatoBT.setVisibility(View.GONE);
        RestBT.setVisibility(View.GONE);
        BreakBT.setVisibility(View.GONE);
        StopBT.setVisibility(View.VISIBLE);
        TimeTV.setText("");
    }
    private void hideStopButton(){
        TomatoBT.setVisibility(View.VISIBLE);
        RestBT.setVisibility(View.VISIBLE);
        BreakBT.setVisibility(View.VISIBLE);
        StopBT.setVisibility(View.GONE);
        TimeTV.setText("");
    }
}
