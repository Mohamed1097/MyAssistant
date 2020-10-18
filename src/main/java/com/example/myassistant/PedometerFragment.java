package com.example.myassistant;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;


public class PedometerFragment extends Fragment implements SensorEventListener {

    private TextView pedotxt;
    private SensorManager sensorManager;
    private Sensor sensor;
    private boolean isCounterStepPresent;
    private int stepCounter=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_pedometer, container, false);
       getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        pedotxt=view.findViewById(R.id.pedometer);
        sensorManager= (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        {
            sensor=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterStepPresent=true;
        }
        else{
            pedotxt.setText("Step Counter is not Present");
            isCounterStepPresent=false;
        }
        return view;
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor==sensor)
        {
            stepCounter= (int) event.values[0];
            pedotxt.setText(String.valueOf(stepCounter));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        {
            sensorManager.registerListener((SensorEventListener) getContext(),sensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        {
            sensorManager.unregisterListener((SensorEventListener) getContext(),sensor);
        }
    }
}