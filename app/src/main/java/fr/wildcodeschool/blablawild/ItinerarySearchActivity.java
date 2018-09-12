package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static String EXTRA_DEPARTURE = "EXTRA_DEPARTURE";
    public static String EXTRA_NAME = "EXTRA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);


        final Button buttonSearchTravel = findViewById(R.id.button_search_travel);
        buttonSearchTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextDeparture = findViewById(R.id.editText_departure);
                String DepartureValue = editTextDeparture.getText().toString();

                EditText editTextName = findViewById(R.id.editText_name);
                String NameValue = editTextName.getText().toString();

                EditText editTextDate = findViewById(R.id.editText_date);
                String DateValue = editTextDate.getText().toString();

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
}
