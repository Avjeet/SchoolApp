package com.labs.daphnis.iviewsmart.Activity.TimeTable;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.labs.daphnis.iviewsmart.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimeTableActivity extends AppCompatActivity {

    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_THREE_DAY_VIEW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        final WeekView weekView = findViewById(R.id.weekView);
        final Spinner spinner = findViewById(R.id.spinner_time_table);

        ActionBar actionBar = getSupportActionBar();

        assert actionBar != null;
        actionBar.setTitle(getString(R.string.time_table));
        actionBar.setDisplayHomeAsUpEnabled(true);

        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,
                new ArrayList<String>() {{
                    add("Today");
                    add("Day View");
                    add("Three Day View");
                    add("Week View");
                }}));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                weekView.setDateTimeInterpreter(new DateTimeInterpreter() {
                    @Override
                    public String interpretDate(Calendar date) {
                        SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                        String weekday = weekdayNameFormat.format(date.getTime());
                        SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());

                        // All android api level do not have a standard way of getting the first letter of
                        // the week day name. Hence we get the first char programmatically.
                        // Details: http://stackoverflow.com/questions/16959502/get-one-letter-abbreviation-of-week-day-of-a-date-in-java#answer-16959657
                        if (spinner.getSelectedItemPosition() == 3)
                            weekday = String.valueOf(weekday.charAt(0));
                        return weekday.toUpperCase() + format.format(date.getTime());
                    }

                    @Override
                    public String interpretTime(int hour) {
                        return hour > 11 ? (hour - 12) + " PM" : (hour == 0 ? "12 AM" : hour + " AM");
                    }
                });

                switch (position) {
                    case 0:
                        weekView.goToToday();
                        break;
                    case 1:
                        if (mWeekViewType != TYPE_DAY_VIEW) {
                            view.setSelected(false);
                            mWeekViewType = TYPE_DAY_VIEW;
                            weekView.setNumberOfVisibleDays(1);

                            // Lets change some dimensions to best fit the view.
                            weekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                            weekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                            weekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                        }
                        break;
                    case 2:
                        if (mWeekViewType != TYPE_THREE_DAY_VIEW) {
                            view.setSelected(false);
                            mWeekViewType = TYPE_THREE_DAY_VIEW;
                            weekView.setNumberOfVisibleDays(3);

                            // Lets change some dimensions to best fit the view.
                            weekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                            weekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                            weekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                        }
                        break;
                    case 3:
                        if (mWeekViewType != TYPE_WEEK_VIEW) {
                            view.setSelected(false);
                            mWeekViewType = TYPE_WEEK_VIEW;
                            weekView.setNumberOfVisibleDays(7);

                            // Lets change some dimensions to best fit the view.
                            weekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                            weekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                            weekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                        }
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        weekView.setOnEventClickListener(new WeekView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                Toast.makeText(TimeTableActivity.this, "Clicked " + event.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        weekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                List<WeekViewEvent> events = new ArrayList<>();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                Calendar endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 1);
                endTime.set(Calendar.MONTH, newMonth - 1);
                WeekViewEvent event = new WeekViewEvent(1, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.red));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 4);
                endTime.set(Calendar.MINUTE, 30);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(10, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.black));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 4);
                startTime.set(Calendar.MINUTE, 20);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 5);
                endTime.set(Calendar.MINUTE, 0);
                event = new WeekViewEvent(10, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorAccent));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(2, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.green));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 1);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(3, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.grey));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 15);
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(4, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorPrimary));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 1);
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(5, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorPrimaryDark));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
                startTime.set(Calendar.HOUR_OF_DAY, 15);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(5, getEventTitle(startTime), startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorAccent));
                events.add(event);

                return events;
            }
        });

        weekView.setEventLongPressListener(new WeekView.EventLongPressListener() {
            @Override
            public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
                Toast.makeText(TimeTableActivity.this, "Event Long Pressed " + event.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private String getEventTitle(Calendar time) {
        return String.format(Locale.ENGLISH, "Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH) + 1, time.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            default: return false;
        }
    }
}

