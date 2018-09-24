package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static String EXTRA_DEPARTURE = "EXTRA_DEPARTURE";
    public static String EXTRA_NAME = "EXTRA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final Calendar myCalendar = Calendar.getInstance();

        final EditText editTextDate = findViewById(R.id.editText_date);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(editTextDate, myCalendar);
            }

        };

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        final Button buttonSearchTravel = findViewById(R.id.button_search_travel);
        buttonSearchTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText editTextDeparture = findViewById(R.id.editText_departure);
                String DepartureValue = editTextDeparture.getText().toString();

                EditText editTextName = findViewById(R.id.editText_name);
                String NameValue = editTextName.getText().toString();

                if (DepartureValue.isEmpty() || NameValue.isEmpty()) {
                    Toast.makeText(ItinerarySearchActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                } else {
                    Intent goToItineraryListActivity = new Intent(ItinerarySearchActivity.this,
                            ItineraryListActivity.class);
                    goToItineraryListActivity.putExtra(EXTRA_DEPARTURE, DepartureValue);
                    goToItineraryListActivity.putExtra(EXTRA_NAME, NameValue);
                    ItinerarySearchActivity.this.startActivity(goToItineraryListActivity);
                }
            }
        });





    }

    private void updateLabel(EditText edittext, Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);


        edittext.setText(sdf.format(myCalendar.getTime()));
    }
}
