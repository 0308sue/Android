package com.example.myapp05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;
    RadioButton radioButtonCal,radioButtonTime;
    Chronometer chronometer;
    TextView tvYear,tvMonth,tvhour,tvDay,tvMinute;
    LinearLayout End;
    int selectYear,selectMonth,selectDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        datePicker = findViewById(R.id.datePicker1);
        timePicker = findViewById(R.id.timePicker1);
        radioButtonCal = findViewById(R.id.rdoCal);
        radioButtonTime = findViewById(R.id.rdoTime);
        chronometer = findViewById(R.id.chronometer1);
        End = findViewById(R.id.End);

        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvhour = findViewById(R.id.tvhour);
        tvDay = findViewById(R.id.tvDay);
        tvMinute = findViewById(R.id.tvMinute);

        Calendar cal = Calendar.getInstance();
        selectYear = cal.get(Calendar.YEAR);
        selectMonth = cal.get(Calendar.MONTH)+1;
        selectDay = cal.get(Calendar.DAY_OF_MONTH);

        datePicker.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);


        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        radioButtonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        radioButtonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });


        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
            }
        });

        End.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvhour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                return true;
            }
        });
    }
}