package com.example.myapp04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity8 extends AppCompatActivity {

    CalendarView calendarView;
    TimePicker timePicker;
    RadioButton radioButtonCal,radioButtonTime;
    Button buttonStart,buttonStop;
    Chronometer chronometer;
    TextView tvYear,tvMonth,tvhour,tvDay,tvMinute;
    int selectYear,selectMonth,selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        calendarView = findViewById(R.id.calendarView1);
        timePicker = findViewById(R.id.timePicker1);
        radioButtonCal = findViewById(R.id.rdoCal);
        radioButtonTime = findViewById(R.id.rdoTime);

        buttonStart = findViewById(R.id.btnStart);
        buttonStop = findViewById(R.id.btnEnd);
        chronometer = findViewById(R.id.chronometer1);

        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvhour = findViewById(R.id.tvhour);
        tvDay = findViewById(R.id.tvDay);
        tvMinute = findViewById(R.id.tvMinute);

        Calendar cal = Calendar.getInstance();
        selectYear = cal.get(Calendar.YEAR);
        selectMonth = cal.get(Calendar.MONTH)+1;
        selectDay = cal.get(Calendar.DAY_OF_MONTH);

        calendarView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);



        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvhour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;

            }
        });

        radioButtonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        radioButtonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

    }
}